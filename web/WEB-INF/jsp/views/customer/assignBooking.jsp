<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Admin</title>
    </head>
    <body>
        <c:url var="url" scope="request" value="/admin/booking" />
        <div align="center">
            <h1>Assign Booking to Driver</h1>
            <form action="${url}" method="POST">
                <label>Booking ID: </label> <br>
                <input type="text" name="id" value="${id}" /><br>
                <label>Driver Username</label><br/>
                <input required placeholder="Enter driver username" type="text" name="username"><br><br>
                <input class="btn btn-primary" type="submit" value="Assign">
            </form>
        </div>
    </body>
</html>
