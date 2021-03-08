<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>My Log</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="My Activities"/>
    </jsp:include>
    <main>
        <c:choose>
            <c:when test="${empty activities}">
                <p>No activities yet</p>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                    <tr>
                        <th>Time</th>
                        <th>Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="activity" items="${activities}">
                        <tr>
                            <td>${activity.time}</td>
                            <td>${activity.type}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>