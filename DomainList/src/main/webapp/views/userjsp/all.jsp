<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
<c:url var="edit" value="/user/edit" />
<c:url var="delete" value="/user/delete" />
<c:url var="create" value="/user/create" />
<div class="container">
<div class="jumbotron" style="height: 450px;">
	<table class="table">
		<thead>
    		<tr>
  		    	<th>Name</th>     			  			
  			    <th>Last name</th>
  			    <th>Email</th>
       		</tr>
    	</thead>
    	<tbody class="tbodyClient">
    	<c:forEach var="user" items="${users}">
			<tr class="success">
       			<td><h3>${user.name}</h3></td>
       			<td><h3>${user.lName}</h3></td>
       			<td><h3>${user.email}</h3></td>          			   		        		
        	   	<td>
       				<a href="${edit}/${user.id}">edit</a>	
				</td>  
				<td>
					<a href="${delete}/${user.id}">delete</a>	
				</td>      		        			
        	</tr>	        	
        	</c:forEach>	
       </tbody>
	</table>
</div>

	
	

<c:url var="firstUrl" value="/user/all/1" />
<c:url var="lastUrl" value="/user/user/all/${userLog.totalPages}" />
<c:url var="prevUrl" value="/user/all/${currentIndex - 1}" />
<c:url var="nextUrl" value="/user/all/${currentIndex + 1}" />

<div class="pagination">
    <ul class="pagination">
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/user/all/${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == userLog.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
</div>