<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<c:url var="edit" value="/domain/edit" />
<c:url var="delete" value="/domain/delete" />
<c:url var="create" value="/domain/create" />
<c:url var="add" value="/domain/create" />

<div class="container">
<div class="jumbotron" style="height: 450px;">
<a href="${add}" class="btn btn-success">Add new domain</a>	
	<table class="table">
		<thead class="thead-inverse">
    		<tr>
  		    	<th>Name</th>     			  			
  			    <th>Status</th>
       		</tr>
    	</thead>
    	<tbody class="tbodyClient">
    	<c:forEach var="domain" items="${domains}">
			<tr class="success">
       			<td><h5>${domain.name}</h5></td>
       			<c:choose>
    				<c:when test="${domain.status == 'true'}">
        				<td><h5>Danger</h5></td>        	
    				</c:when>    
    				<c:otherwise>
        				<td><h5>Legitimate</h5></td>        	
    				</c:otherwise>
				</c:choose>
       			<sec:authorize access="hasAnyRole('ROLE_ADMIN')">		
					<td>
       					<a href="${edit}/${domain.id}">edit</a>	
					</td>  
					<td>
						<a href="${delete}/${domain.id}">delete</a>	
					</td>     
				</sec:authorize>	        			
        	   	 		        			
        	</tr>	        	
        	</c:forEach>	
       </tbody>
	</table>
</div>
 	
<c:url var="firstUrl" value="/domain/all/1" />
<c:url var="lastUrl" value="/domain/all/${domainLog.totalPages}" />
<c:url var="prevUrl" value="/domain/all/${currentIndex - 1}" />
<c:url var="nextUrl" value="/domain/all/${currentIndex + 1}" />

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
            <c:url var="pageUrl" value="/domain/all/${i}" />
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
            <c:when test="${currentIndex == domainLog.totalPages}">
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

	
	
	


