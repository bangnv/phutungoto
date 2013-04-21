package com.att.phutungoto
import com.att.phutungoto.tools.Util;
class Article {
	String name
	String nameTokenized;
	String code;
	String unite
	Integer quantity
	Float prix
	
//	public Article() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

//	public Article(Map map) {
//    println "vao construter"
//	map?.each { k, v ->
//		println k + v;
//		 this[k] = v } 
//	nameTokenized=Util.convertToLowCase(name)
//	}
	
	static constraints = {
		name blank: false, nullable: false
		code  blank: false, nullable: false,unique:true
		unite blank: false, nullable: false
		quantity blank: false, nullable: false
		nameTokenized blank: true, nullable: true
		quantity(min:0,max:10000)
		prix (min: 0f, max: 500000000.99f)
	}
	
	
	static search ={
// use full value as a single term		
	name index: 'tokenized', store: 'yes'
	nameTokenized index:'un_tokenized', store: 'yes'
	}
	
	
	
	
	
	
	
	
	
	
	
}
