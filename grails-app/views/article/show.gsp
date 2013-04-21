
<%@ page import="com.att.phutungoto.Article" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'article.label', default: 'Article')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-article" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-article" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list article">
			
				<g:if test="${articleInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="article.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${articleInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articleInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="article.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${articleInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articleInstance?.unite}">
				<li class="fieldcontain">
					<span id="unite-label" class="property-label"><g:message code="article.unite.label" default="Unite" /></span>
					
						<span class="property-value" aria-labelledby="unite-label"><g:fieldValue bean="${articleInstance}" field="unite"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articleInstance?.quantity}">
				<li class="fieldcontain">
					<span id="quantity-label" class="property-label"><g:message code="article.quantity.label" default="Quantity" /></span>
					
						<span class="property-value" aria-labelledby="quantity-label"><g:fieldValue bean="${articleInstance}" field="quantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articleInstance?.prix}">
				<li class="fieldcontain">
					<span id="prix-label" class="property-label"><g:message code="article.prix.label" default="Prix" /></span>
					
						<span class="property-value" aria-labelledby="prix-label"><g:fieldValue bean="${articleInstance}" field="prix"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${articleInstance?.id}" />
					<g:link class="edit" action="edit" id="${articleInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
