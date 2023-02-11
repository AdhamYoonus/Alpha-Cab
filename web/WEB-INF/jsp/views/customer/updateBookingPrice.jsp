<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Admin</title>
    </head>
    <body>
        
        <div align="center">
            <h1>Update Booking Price</h1>
            <form action="update-booking" method="POST">
                <input type="hidden" name="bookingId" value="${booking.id}">
                <label>Booking ID:</label><br>
                <input type="text" disabled value="${booking.id}"><br>
                <label>Booking Price: </label><br>
                <input type="text" name="cost" value="${booking.cost}"><br>
                <input type="submit" value="Update Price" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
