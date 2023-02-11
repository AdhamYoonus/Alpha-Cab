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
            <h1>Update Customer</h1>
            <form class="w-75" action="<c:url value="/updateCustomer" />" method="POST">
                <input class="w-50" type="hidden" name="oldUsername" value="${customer.username}">
                <label>Username: </label><br>
                <input class="w-50" type="text" name="username" value="${customer.username}"><br>
                <label>Name: </label><br>
                <input class="w-50" type="text" name="name" value="${customer.name}"><br>
                <label>Contact No: </label><br>
                <input class="w-50" type="text" name="contactno" value="${customer.contactNumber}"><br>
                <label>Email: </label><br>
                <input class="w-50" type="email" name="email" value="${customer.email}"><br>
                <label>Password: </label><br>
                <input class="w-50" type="text" name="password" value="${customer.password}"><br><br>
                <input type="submit" value="Update" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
