<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Customer</title>
    </head>
    <body>
        <div class="container-sm">
            <a class="btn btn-primary text-dark" href="<c:url value="/home"></c:url>">Home</a>
        </div>
        <div class="text-center container-sm mx-auto">
            <h1>Your Invoice</h1>
            <div align="center">
                <table>
                <tbody>
                    <tr>
                        <th>Booking ID: </th>
                        <td>${booking.id}</td>
                    </tr>
                    <tr>
                        <th>From: </th>
                        <td>${booking.address}</td>
                    </tr>
                    
                    <tr>
                        <th>Destination: </th>
                        <td>${booking.destinationAddress}</td>
                    </tr>
                    
                    <tr>
                        <th>Distance: </th>
                        <td>${booking.distance}</td>
                    </tr>
                    
                    <tr>
                        <th>Cost: </th>
                        <td>${booking.cost}</td>
                    </tr>
                    
                    <tr>
                        <th>Date &AMP; Time: </th>
                        <td>${booking.date}, ${booking.time}</td>
                    </tr>
                </tbody>
            </table>
            </div>
        </div>
    </body>
</html>
