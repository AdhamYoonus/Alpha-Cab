<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alph-Cab|Admin</title>
    </head>
    <body>
        
        <div>
            <h1 align="center">Customers Served: ${date}</h1>
            <br><br>
            
            <div class="container-smm mt-3">
                <a class="btn btn-primary text-dark" href="<c:url value="/home"></c:url>">Home</a>
            </div>
            <div align="left">
                <c:url scope="request" var="url" value="/admin/customer-report" />
                <form action="${url}" method="POST">
                    <label>Select Date: </label>
                    <input type="datetime-local" name="date"><br>
                    <input type="submit" class="btn btn-primary" value="Filter">
                </form>
            </div>
            <c:choose>
                <c:when test="${list.size() == 0}">
                    <h3 align="center">No Customers Served On: ${date}</h3>
                </c:when>
                    
                    <c:otherwise>
                        <c:set scope="page" var="total" value="0" />
                        <div align="center" class="container-sm">
                            <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <th>Customer username</th>
                                    <th>From</th>
                                    <th>Destination</th>
                                    <th>Charged</th>
                                </tr>
                                
                                <c:forEach items="${list}" var="b">
                                    <tr>
                                        <td>${b.username}</td>
                                        <td>${b.address}</td>
                                        <td>${b.destinationAddress}</td>
                                        <td>${b.cost}</td>
                                        
                                        <c:set var="total" scope="page" >${ total + b.cost}</c:set>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th colspan="3">TOTAL</th>
                                    <td>${total}</td>
                                </tr>
                            </tfoot>
                        </table>
                        </div>
                    </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
