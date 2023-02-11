<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Driver</title>
    </head>
    <body>
        <div class="container-smm mt-3">
            <a class="btn btn-primary text-dark" href="<c:url value="/home"></c:url>">Home</a>
        </div>
        <h1 align="center">Jobs Assigned Today!</h1>
        <div>
        <c:if test="${list.size() == 0}">
                <h4>No Bookings made yet, </h4>
                <a href="<c:url value = "/customer"> 
                  <c:param name = "action" value="book" />
              </c:url>">Start Now</a>
            </c:if>
            
                <c:if test="${list.size() > 0}">
                    <div class="container-sm">
                        <table class="table table-striped">
                            <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>From Address</th>
                                <th>Destination Address</th>
                                <th>Booking Date &AMP; Time</th>
                                <th>Distance(KMs)</th>
                                <th>Cost</th>
                                <th>Username</th>
                                <th>Driver Assigned</th>
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
                                    <td>${b.username}</td>
                                    <td>
                                        <c:if test="${b.driverUsername == null}">None</c:if>
                                        <c:if test="${b.driverUsername != null}">${b.driverUsername}</c:if>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.status == 1}">
                                                <a class="btn btn-warning" href="<c:url value="/driver">
                                                       <c:param name="action" value="complete" />
                                                       <c:param name="id" value="${b.id}" />
                                                </c:url>">complete</a>
                                            </c:when>
                                                
                                            <c:when test="${b.status == 2}">
                                                <button class="btn btn-success">Completed</button>
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
