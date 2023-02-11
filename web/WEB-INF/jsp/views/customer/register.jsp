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
            <h1>Register new Customer</h1>
            <form class="w-75" action="customer" method="POST">
                <label>Username: </label><br>
                <input class="w-50" type="text" name="username"><br>
                <label>Name: </label><br>
                <input class="w-50" type="text" name="name"><br>
                <label>Contact No: </label><br>
                <input class="w-50" type="text" name="contactno"><br>
                <label>Email: </label><br>
                <input class="w-50" type="email" name="email"><br>
                <label>Password: </label><br>
                <input class="w-50" type="password" name="password"><br><br>
                <input type="submit" value="Register" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
