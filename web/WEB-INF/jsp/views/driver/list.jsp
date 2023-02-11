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
            <h1>All Drivers</h1>
        </div>
        <c:choose>
            <c:when test="${list.size() == 0}">
                <h1 align="center">No Drivers Registered</h1>
            </c:when>
                
                <c:otherwise>
                    <div class="">
                        <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">Username</th>
                                <th scope="col">Driver name</th>
                                <th scope="col">Driving License</th>
                                <th scope="col">Car Type</th>
                                <th scope="col">Car Model</th>
                                <th scope="col">Password</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach items="${list}" var="d">
                                <tr>
                                    <td scope="col">
                                        <a href="<c:url value="/admin/driver">
                                               <c:param name="action" value="update" />
                                               <c:param name="username" value="${d.username}" />
                                        </c:url>">${d.username}</a>
                                    </td>
                                    <td scope="col">${d.driverName}</td>
                                    <td scope="col">${d.licenseNumber}</td>
                                    <td scope="col">${d.carType}</td>
                                    <td scope="col">${d.carModel}</td>
                                    <td scope="col">${d.password}</td>
                                    
                                    <td scope="col">
                                        <a class="btn btn-outline-danger" href="<c:url value="/admin/driver">
                                               <c:param name="action" value="delete" />
                                               <c:param name="username" value="${d.username}" />
                                        </c:url>">Delete</a>
                                    </td>
                                    
                                    <td scope="col">
                                        <a class="btn btn-outline-primary" href="<c:url value="/admin/driver">
                                               <c:param name="action" value="jobs" />
                                               <c:param name="username" value="${d.username}" />
                                        </c:url>">View Jobs</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    </div>

                </c:otherwise>
        </c:choose>
    </body>
</html>
