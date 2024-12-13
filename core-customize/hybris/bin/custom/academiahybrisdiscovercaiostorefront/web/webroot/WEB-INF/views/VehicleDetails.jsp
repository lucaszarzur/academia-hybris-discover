<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <title>Vehicle Details</title>
        <body>
            <h1>Vehicle Details</h1>
            Vehicle Details for ${vehicle.model}
            <p>${vehicle.licensePlate}</p>
            <p>${vehicle.brand}</p>
            <p>${vehicle.color}</p>
            <p>${vehicle.model}</p>
            <p>${vehicle.year}</p>
            <a href="../vehicles">Back to Vehicle List</a>
        </body>
</html>