package com.att.phutungoto

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException
import com.att.phutungoto.tools.Util;

import com.sun.java.util.jar.pack.Utils;

class ArticleController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[articleInstanceList: Article.list(params), articleInstanceTotal: Article.count()]
	}

	def create() {
		[articleInstance: new Article(params)]
	}

	def save() {
		params.nameTokenized=Util.convertToLowCase(params.name)
		def articleInstance = new Article(params)
		
		if (!articleInstance.save(flush: true)) {
			render(view: "create", model: [articleInstance: articleInstance])
			return
		}
		Article.findByName(articleInstance.getName()).search().index();
		flash.message = message(code: 'default.created.message', args: [
			message(code: 'article.label', default: 'Article'),
			articleInstance.id
		])
		redirect(action: "show", id: articleInstance.id)
	}

	def show(Long id) {
		def articleInstance = Article.get(id)
		if (!articleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'article.label', default: 'Article'),
				id
			])
			redirect(action: "list")
			return
		}

		[articleInstance: articleInstance]
	}

	def edit(Long id) {
		def articleInstance = Article.get(id)
		if (!articleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'article.label', default: 'Article'),
				id
			])
			redirect(action: "list")
			return
		}

		[articleInstance: articleInstance]
	}

	def update(Long id, Long version) {
		def articleInstance = Article.get(id)
		if (!articleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'article.label', default: 'Article'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (articleInstance.version > version) {
				articleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'article.label', default: 'Article')] as Object[],
						"Another user has updated this Article while you were editing")
				render(view: "edit", model: [articleInstance: articleInstance])
				return
			}
		}

		articleInstance.properties = params

		if (!articleInstance.save(flush: true)) {
			render(view: "edit", model: [articleInstance: articleInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'article.label', default: 'Article'),
			articleInstance.id
		])
		redirect(action: "show", id: articleInstance.id)
	}

	def delete(Long id) {
		def articleInstance = Article.get(id)
		if (!articleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'article.label', default: 'Article'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			articleInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'article.label', default: 'Article'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'article.label', default: 'Article'),
				id
			])
			redirect(action: "show", id: id)
		}
	}



	

	def searchAjax(String param) {
		def articlesFound
		if(param!=""){
			def keywords=Util.convertToLowCase(param);
			String keywords_wildcard;
			keywords.endsWith(' ')?(keywords_wildcard=keywords+'*'):(keywords_wildcard=keywords+' *')
			System.out.println(keywords_wildcard);
			articlesFound= Article.search().list{
				should {
					//startWith for phrase
					wildcard 'nameTokenized',keywords_wildcard
					wildcard 'nameTokenized',keywords+'*'
				//	A Query that matches documents containing a particular sequence of terms.
					keyword 'name',keywords
					phrase 'name',keywords
				}
			}
			
//			if(paramTab.size()>=1) {
//				articlesFound= Article.search().list{
//					wildcard 'name',param+'*';
//				}
//			}
//			else {
//				String lastString=paramTab.pop();
//				String firstString = paramTab.join(" ");
//				articlesFound= Article.search().list{
//					should {
//						phrase 'name',firstString
//						must{
//							phrase 'name',firstString
//							wildcard 'name',lastString+'*';
//						}
//					}
//				}
//			}
			def result=[];
			
			articlesFound.each{
				def temp=[];
				temp << it.code << it.name << it.quantity <<it.unite << it.prix
				result << temp
				
			}

			def resultFinal = [aaData: result]
			int i=0;
			result.each{
				i++
//				println it.toString() +'-------------------'+i
			}
			render resultFinal as JSON
		}
	}
	}
