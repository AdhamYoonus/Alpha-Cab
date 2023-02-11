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
            <h1>Update Price/KM: </h1>
            <form action="updatPrice" method="POST">
                <label>Price/KM</label><br>
                <input type="text" name="price" value="${price}" required><br><br>
                <input class="btn btn-primary" type="submit" value="Update">
            </form>
        </div>
    </body>
</html>
