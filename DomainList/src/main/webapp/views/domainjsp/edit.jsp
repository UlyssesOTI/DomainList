<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<div class="container">
	<div class="jumbotron">
	<form:form id="formAddDomain" action="update" method="put" modelAttribute="domain">
	<fieldset>
		<p>
			<form:input path="id" type="hidden"/>
     		<label for="curl">Domain name </label>
      		<form:input id="curl" type="url" path="name"/>
      		<form:input path="status" type="hidden"/>
      		<form:input path="user" type="hidden"/>

    	</p>

    	<p>
      		<input class="submit" type="submit" value="Submit">
    	</p>
	</fieldset>
	</form:form>
</div>
</div>	
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
<script>
$("#formAddDomain").validate();
</script>

