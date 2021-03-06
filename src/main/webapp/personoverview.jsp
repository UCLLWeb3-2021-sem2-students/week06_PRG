<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="User Overview"/>
    </jsp:include>
    <main>
        <c:choose>
            <c:when test="${not empty persons}">
                <table>
                    <tr>
                        <th>E-mail</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </tr>
                    <c:forEach items="${persons}" var="person">
                        <tr>
                            <td>${person.email}</td>
                            <td>${person.firstName}</td>
                            <td>${person.lastName}</td>
                        </tr>
                    </c:forEach>

                    <caption>Users Overview</caption>
                </table>
            </c:when>
            <c:otherwise>
                <p>No users to show</p>
            </c:otherwise>
        </c:choose>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>