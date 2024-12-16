<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>Vehicle List</title>
<body>
<h1>Vehicle List</h1>
<ul>
    <c:forEach var="vehicle" items="${vehicles}">
        <li><a href="./${vehicle.id}">${vehicle.licensePlate}</a></li>
    </c:forEach>
</ul>
</body>
</html>