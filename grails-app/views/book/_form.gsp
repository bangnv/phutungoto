<%@ page import="com.att.phutungoto.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="book.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="book.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	
</div>

