<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../shared/Layout.jsp" />
<h1>Students</h1>
<div>
<form method="post" action="/students/add" id="addStudent">
    <input type="text" name="name" placeholder="Enter the title" />
    <input type="text" name="secondName" placeholder="Enter curator family" />
    <input type="text" name="lastName" placeholder="Enter title of direction" />
    <select name="groupId" form="addStudent">
            <c:forEach var="group" items="${groups}">
                <option value="${group.id}">"${group.title}"</option>
            </c:forEach>
    </select>
    <button type="submit">Add</button>
</form>
</div>
<div>
<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>Name</th>
            <th>Second Name</th>
            <th>Last Name</th>
            <th>Group</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.name}" /></td>
            <td><c:out value="${student.secondName}" /></td>
            <td><c:out value="${student.lastName}" /></td>
            <td><c:out value="${student.group.title}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
