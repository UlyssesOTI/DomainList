<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<div class="jumbotron">
		<form:form id="formAddDomain" action="add" method="post" modelAttribute="domain">
			<fieldset>
				<p>
     				<label for="curl">Domain name </label>
      				<form:input id="curl" type="url" path="name" />
      				<form:errors class="error" path="name"  />
    			</p>

    			<p>
      				<input class="submit" type="submit" value="Submit">
    			</p>
			</fieldset>
		</form:form>
	</div>
</div>
<script>
$("#formAddDomain").validate();
</script>

