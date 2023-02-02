<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Save Answer</title>
		
		<!-- Style sheet reference -->
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-style.css">
			
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Questionnary Manager</h2>
			</div>
		</div>
		<div id="container">
			<h3>Save Answer</h3>
			<form:form action="saveAnswer" modelAttribute="answer" method="POST">
			
				<!-- Associating this data with answer id -->
				<form:hidden path="id"/>
			
				<table>
					<tr>
						<td><label>Text:</label></td>
						<td><form:input path="text"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</table>
			</form:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/answer/list">Back to List</a>
			</p>
		</div>
	</body>
</html>