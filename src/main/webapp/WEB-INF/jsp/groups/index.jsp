<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../shared/Layout.jsp" />
<h1>Groups</h1>
<div>
<form method="post" action="/groups/add">
    <input type="text" name="title" placeholder="Enter the title" />
    <input type="text" name="curatorFamily" placeholder="Enter curator family" />
    <input type="text" name="titleDirection" placeholder="Enter title of direction" />
    <button type="submit">Add</button>
</form>
<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Curator Family</th>
            <th>Title Direction</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${groups}">
        <tr>
            <td><input type="checkbox" id="check"></td>
            <td><c:out value="${group.title}" /></td>
            <td><c:out value="${group.curatorFamily}" /></td>
            <td><c:out value="${group.titleDirection}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>