<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Answers</title>
		
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
			
				<input type="button" value="Add Answer"
						onclick="window.location.href='showFormForAdd'; return false;"
						class="add-button">
						
				<table>
					<tr>
						<th>Text</th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print our answers - jstl -->				
					<c:forEach var="tempAnswer" items="${answers}">
					
						<!-- "update" link with answer id -->
						<c:url var="updateLink" value="/answer/showFormForUpdate">
							<c:param name="answerId" value="${tempAnswer.id}"/>
						</c:url>
						
						<!-- "delete" link with answer id -->
						<c:url var="deleteLink" value="/answer/delete">
							<c:param name="answerId" value="${tempAnswer.id}"/>
						</c:url>
						
						<tr>
							<td>${tempAnswer.text}</td>
							<td>
								<!-- display the update link -->
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this answer?'))) return false">Delete</a>
							</td>						
						</tr>
					</c:forEach>
					
				</table>
			</div>		
		</div>
	</body>
</html>