	def articlesFound= Article.search().list{
			should {
				phrase 'name',param
				
				
			}<%@ page import="com.att.phutungoto.Article" %>



<div class="fieldcontain ${hasErrors(bean: articleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="article.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${articleInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: articleInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="article.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${articleInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: articleInstance, field: 'unite', 'error')} required">
	<label for="unite">
		<g:message code="article.unite.label" default="Unite" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="unite" required="" value="${articleInstance?.unite}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: articleInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="article.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" type="number" min="0" max="10000" value="${articleInstance.quantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: articleInstance, field: 'prix', 'error')} required">
	<label for="prix">
		<g:message code="article.prix.label" default="Prix" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="prix" value="${fieldValue(bean: articleInstance, field: 'prix')}" required=""/>
</div>

