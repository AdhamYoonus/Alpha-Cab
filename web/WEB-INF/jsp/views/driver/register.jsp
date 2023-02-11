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
        
        <div align="center">
            <h1>Register New Driver</h1>
            <form class="w-75" action="driver" method="POST">
            <label>Username: </label><br>
            <input class="w-50" type="text" name="username"><br>
            <label>Driver Name: </label><br>
            <input class="w-50" type="text" name="driverName"><br>
            <label>Driving License Number: </label><br>
            <input class="w-50" type="text" name="licenseNumber"><br>
            <label>Car Type </label><br>
            <input class="w-50" type="text" name="carType"><br>
            <label>Car Model: </label><br>
            <input class="w-50" type="text" name="carModel"><br>
            <label>Password: </label><br>
            <input class="w-50" type="password" name="password"><br><br>
            <input class="btn btn-primary" type="submit" value="Register"><br>
        </form>
        </div>
    </body>
</html>
