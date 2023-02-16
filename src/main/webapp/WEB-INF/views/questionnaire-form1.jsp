<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head></head>
	    <title>Questionnaire Form</title>
	    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='/resources/css/add-style.css' />" rel="stylesheet"></link>
	</head>
	
	<body>
		<div class="generic-container">
    	<div class="well lead">Questionnaire Form</div>
    	
    	<form:form method="POST" modelAttribute="questionnaire" class="form-horizontal">
    		<form:input type="hidden" path="id" id="id"/>
    		
    		<div class="row">
    			<div class="form-group col-md-12">
                	<label class="col-md-3 control-lable" for="title">Title</label>
                	<div class="col-md-7">
                    	<form:input type="text" path="title" id="title" class="form-control input-sm"/>
                    	<div class="has-error">
                        	<form:errors path="title" class="help-inline"/>
                    	</div>
                	</div>
            	</div>
            	
            <div class="row">
            	<div class="form-group col-md-12">
                	<label class="col-md-3 control-lable" for="subject">Subject</label>
                	<div class="col-md-7">
                    	<form:input type="text" path="subject" id="subject" class="form-control input-sm" />
                    	<div class="has-error">
                        	<form:errors path="subject" class="help-inline"/>
                    	</div>
                	</div>
            	</div>
        	</div>
            
    		</div>
    	</form:form>
	</body>

</html>