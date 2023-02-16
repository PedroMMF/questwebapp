<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Questions</title>
		
		<!-- Style sheet reference -->
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath }/resources/css/style.css"/>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Questionnary Manager</h2>
			</div>	
		</div>
		<div id="container">
			<div id="content">
				
				<input type="button" value="Add Question"
						onclick="window.location.href='showFormForAdd'; return false;"
						class="add-button">
							
				<select id="selectedQuestion" name="selectedQuestion" class="droplist">
					<c:forEach var="tempQuestion" items="${questions}">
						<option value="${tempQuestion.id}">${tempQuestion.text}</option>
					</c:forEach>
				</select>
			
			</div>	
		</div>
	</body>
</html>