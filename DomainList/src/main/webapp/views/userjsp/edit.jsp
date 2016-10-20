<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<div class="jumbotron">
	<form:form id="formAddUser" action="user/update" method="post" modelAttribute="user">
	<fieldset>
		
			<form:input path="id" type="hidden"/>
     		<table class="table">
		<thead class="thead-inverse">
    		<tr>
  		    	<th>Field</th>     			  			
  			    <th>Value</th>
       		</tr>
    	</thead>  
    	<tbody class="tbodyClient">
    			<tr class="success">
       				<td><label for="curl">User name</label></td>
       				<td><form:input class="form-control" id="curl" type="text" path="name" required="true"/></td>
       			</tr>
       			<tr class="success">
       				<td><label for="curl">User last name</label></td>
       				<td><form:input class="form-control" id="curl" type="text" path="lName" required="true"/></td>
       			</tr>
       			<tr class="success">
       				<td><label for="curl">User email</label></td>
       				<td><form:input class="form-control" id="curl" type="email" path="email" required="true"/>
       				<form:errors class="error" path="email"  /></td>
       			</tr>
       			
       		</tbody>
    	</table>   		
      		<form:input path="password" type="hidden"/>
    	

    	<p>
      		<input class="submit" type="submit" value="Submit">
    	</p>
	</fieldset>
	</form:form>
	
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
<script>
$("#formAddUser").validate();
</script>
</div>
</div>
