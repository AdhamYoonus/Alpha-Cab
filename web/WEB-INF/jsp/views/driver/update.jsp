<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Admin</title>
    </head>
    <body>
        <div class="container-sm">
            <a class="btn btn-primary text-dark" href="<c:url value="/home"></c:url>">Home</a>
        </div>
        <h1 align="center">Update Driver</h1>
        <div align="center">
            <form class="w-75" action="<c:url value="/updateDriver" />" method="POST">
            <label>Username: </label><br>
            <input class="w-50" type="text" name="username" value="${driver.username}"><br>
            <input type="hidden" name="oldusername" value="${driver.username}">
            <label>Driver Name: </label><br>
            <input class="w-50" type="text" name="driverName" value="${driver.driverName}"><br>
            <label>Driving License Number: </label><br>
            <input class="w-50" type="text" name="licenseNumber" value="${driver.licenseNumber}"><br>
            <label>Car Type </label><br>
            <input class="w-50" type="text" name="carType" value="${driver.carType}"><br>
            <label>Car Model: </label><br>
            <input class="w-50" type="text" name="carModel" value="${driver.carModel}"><br>
            <label>Password: </label><br>
            <input class="w-50" type="text" name="password" value="${driver.password}"><br><br>
            <input class="btn btn-primary" type="submit" value="Update"><br>
        </form>
        </div>
    </body>
</html>
