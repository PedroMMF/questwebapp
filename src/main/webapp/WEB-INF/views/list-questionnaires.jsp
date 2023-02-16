<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Questionnaires</title>
		
		<!-- Style sheet reference -->
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath }/resources/css/style.css"/>	
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Questionnaire Manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
			
				<input type="button" value="Add Questionnaire"
						onclick="window.location.href='showFormForAdd'; return false;"
						class="add-button">
						
				<table>
					<tr>
						<th>Title</th>
						<th>Subject</th>
						<th>Level</th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print our questionnaires - jstl -->				
					<c:forEach var="tempQuestionnaire" items="${questionnaires}">
					
						<!-- "update" link with questionnaire id -->
						<c:url var="updateLink" value="/questionnaire/showFormForUpdate">
							<c:param name="questionnaireId" value="${tempQuestionnaire.id}"/>
						</c:url>
						
						<!-- "delete" link with answer id -->
						<c:url var="deleteLink" value="/questionnaire/delete">
							<c:param name="questionnaireId" value="${tempQuestionnaire.id}"/>
						</c:url>
						
						<tr>
							<td>${tempQuestionnaire.title}</td>
							<td>${tempQuestionnaire.subject}</td>
							<td>${tempQuestionnaire.level}</td>
							<td>
								<!-- display the update link -->
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this questionnaire?'))) return false">Delete</a>
							</td>						
						</tr>
					</c:forEach>
					
				</table>
			</div>		
		</div>
	</body>
</html>