<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Admin</title>
    </head>
    <body>
        <div align="center">
            <h1>All Registered Customers</h1>
        </div>
        
        <div class="container-sm">
            <a class="btn btn-primary text-dark" href="<c:url value="/home"></c:url>">Home</a>
        </div>
        <c:choose>
            <c:when test="${list.size() == 0}">
                <h1 align="center">No Customers Registered</h1>
            </c:when>
                
                <c:otherwise>
                    <div class="container-sm">
                        <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">Username</th>
                                <th scope="col">Customer name</th>
                                <th scope="col">Contact No</th>
                                <th>Email</th>
                                <th scope="col">Password</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach items="${list}" var="c">
                                <tr>
                                    <td scope="col">
                                        <a href="<c:url value="/admin/customer">
                                               <c:param name="action" value="update" />
                                               <c:param name="username" value="${c.username}" />
                                        </c:url>">${c.username}</a>
                                    </td>
                                    <td scope="col">${c.name}</td>
                                    <td scope="col">${c.contactNumber}</td>
                                    <td scope="col">${c.email}</td>
                                    <td scope="col">${c.password}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    </div>

                </c:otherwise>
        </c:choose>
    </body>
</html>
