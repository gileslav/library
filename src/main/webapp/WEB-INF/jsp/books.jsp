<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<div class="container text-center">  
			<h1>Library - Books</h1>
			<c:out value="${booksCount}"></c:out>
			<table class="table text-center">
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">Name</th>
					<th class="text-center">Books</th>
				</tr>
				<c:forEach items="${booksModel}" var="book">
					<tr>
						<td><c:out value="${book.id}"></c:out></td>
						<td><c:out value="${book.name}"></c:out></td>
						<td>
							<a href="/books/remove/${book.id}">Remove</a>
							<a href="/books/edit/${book.id}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<a href="/books/add">Add new book</a>
		
</div>

	
<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>