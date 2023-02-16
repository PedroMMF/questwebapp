<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Questionnaire Form</title>
		
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
				<h2>Questionnaires Manager</h2>
			</div>
		</div>
		<div id="container">
			<h3>Create Questionnaire</h3>
			<form:form action="saveQuestionnaire" modelAttribute="questionnaire" method="POST">
			
				<!-- Associating this data with questionnaire id -->
				<form:hidden path="id"/>
				
				
			
				<table>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/></td>
					</tr>
					<tr>
						<td><label>Subject:</label></td>
						<td><form:input path="subject"/></td>
					</tr>
					<tr>
						<td><label>Level:</label></td>
						<td>
						<select name="level">
							<option>1</option>
    						<option>2</option>
    						<option>3</option>
    						<option>4</option>
    						<option>5</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<!-- <td><label for="tests">Tests:</label></td> -->
						<td><label>Tests:</label></td>
						<!--  
						<td>
							<select path="tests" items="${tests}" multiple="true" itemValue="id"
								itemLabel="title" />
						</td>
						-->
						<!--  
						<select name="category">
    						<c:forEach items="${listCategory}" var="category">
        						<option value="${category.id}">${category.name}</option>
    						</c:forEach>
						</select>
						-->
					
					
					<td>
						<table>
							<tr>
								<th>Title</th>
								<!-- <th>Subject</th>
								<th>Level</th> -->
								<th>Action</th>
							</tr>
							
							<!-- loop over and print our tests - jstl -->				
							<c:forEach var="tempTest" items="${questionnaire.tests}">
					
						
							<!-- "delete" link with test id -->
							<c:url var="deleteLink" value="/questionnaire/deleteTest">
								<c:param name="testId" value="${tempTest.id}"/>
							</c:url>
						
						<tr>
							<td>${tempTest.title}</td>
							<!-- <td>${tempTest.subject}</td>
							<td>${tempTest.level}</td> -->
							<td>
								<a href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this test?'))) return false">Delete</a>
							</td>						
						</tr>
					</c:forEach>
						</table>
					</td>
					</tr>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</table>
				
				
				
			</form:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/questionnaire/list">Back to List</a>
			</p>
		</div>
		
		<div id="container">
			<h3>Select Tests for the questionnaire</h3>
		
		<div>
			<table>
				<tr>
					<th>Title</th>
					<th>Subject</th>
					<th>Level</th>
					<th>Action</th>
				</tr>
							
					<!-- loop over and print our tests - jstl -->				
					<c:forEach var="tempTest" items="${tests}">
					
						
						<!-- "add" link with test id -->
						<c:url var="addTestLink" value="/questionnaire/addTest">
							<c:param name="testId" value="${tempTest.id}"/>
						</c:url>
							
						<tr>
							<td>${tempTest.title}</td>
							<td>${tempTest.subject}</td>
							<td>${tempTest.level}</td>
							<td>
							<a href="${addTestLink}">Add</a>
									<!-- onclick="if(!(confirm('Are you sure you want to delete this test?'))) return false">Delete</a> -->
							</td>						
						</tr>
					</c:forEach>
			</table>
			</div>
		</div>
	</body>
</html>