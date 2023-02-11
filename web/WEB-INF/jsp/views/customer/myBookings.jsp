<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Customer</title>
    </head>
    <body>
        <div class="container-smm mt-3">
            <a class="btn btn-primary text-dark" href="<c:url value="/home"></c:url>">Home</a>
        </div>
        <div align="center">
            <h1>All Your Bookings</h1>
            <c:if test="${list.size() == 0}">
                <h4>No Bookings made yet, </h4>
                <a href="<c:url value = "/customer"> 
                  <c:param name = "action" value="book" />
              </c:url>">Start Now</a>
            </c:if>
            
                <c:if test="${list.size() > 0}">
                    <div class="container-sm">
                        <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>From Address</th>
                                <th>Destination Address</th>
                                <th>Booking Date &AMP; Time</th>
                                <th>Distance</th>
                                <th>Cost</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="b">
                                <tr>
                                    <td>${b.id}</td>
                                    <td>${b.address}</td>
                                    <td>${b.destinationAddress}</td>
                                    <td>${b.date}, ${b.time.hour}:<c:if test="${b.time.minutes == 0}">00</c:if>
                                        <c:if test="${b.time.minutes > 0}">${b.time.minutes}</c:if>
                                    </td>
                                    <td>${b.distance}</td>
                                    <td>${b.cost}</td>
                                    
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.status == 0}">
                                                <span class="btn btn-warning">Pending</span>
                                            </c:when>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    </div>
                </c:if>
        </div>
    </body>
</html>
