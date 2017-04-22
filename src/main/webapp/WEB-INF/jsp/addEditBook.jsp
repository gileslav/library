<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="container text-center">
	<h1>Library - Add/edit book</h1>
	
	<form:form action="/books" method="post" modelAttribute="book">
		<form:hidden path="id" />
		
		<label>Name</label>
		<form:input path="name" />
		<button type="submit">Save</button>
	</form:form>
</div>
<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>