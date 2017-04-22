<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<div class="container text-center">
    <!-- Example row of columns -->
    <h1>Library - Home</h1>
    <div class="row">
        <div class="col-md-6">
            <h2>Books</h2>
            <p>CRUD operations on books</p>
            <p><a class="btn btn-default" href="books">Go to books</a>
            </p>
        </div>
        <div class="col-md-6">
            <h2>Users</h2>
            <p>CRUD operations on users</p>
            <p><a class="btn btn-default" href="users">Go to users</a>
            </p>
        </div>
    </div>
    <hr>
</div>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>