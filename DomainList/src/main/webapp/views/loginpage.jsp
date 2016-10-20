<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container margin-top">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">

			<c:if test="${not empty message}">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span>


					<c:out value="${message}" />

				</div>
			</c:if>

			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Enter</h3>
				</div>
				<div class="panel-body">
					<form role="form" action="loginprocessing" method="post"
						autocomplete="off">



						<fieldset>
							<div class="form-group">
								<label for="inputLogin">Login</label> <input
									class="form-control" placeholder="E-mail"
									type="text" name="username" required autofocus>
							</div>
							<div class="form-group">
								<label for="inputPassword">Password</label> <input
									class="form-control" type="password" name="password"
									placeholder="Пароль" required>
							</div>

							<!-- Change this to a button or input when using this as a form -->
							<button class="btn btn-lg btn-success btn-block" type="submit">Sign in</button>
     				
						</fieldset>
					</form>
					<a class="btn btn-lg btn-link" href="signIn">Sign up</a>
					
				</div>
				
			</div>
		</div>
	</div>
</div>