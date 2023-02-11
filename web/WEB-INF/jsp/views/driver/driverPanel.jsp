<%-- 
    Document   : login
    Created on : 18-Nov-2022, 16:39:43
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Driver - Alpha Cab</title>
        <link href="assests/css/bootstrap.css" rel="stylesheet">
        <script src="assests/js/bootstrap.bundle.min.js"></script>
    </head>

    <body class="p-2 text-dark pt-5">
        <div class="container-sm">
            <a class="btn btn-danger" href="<c:url value="login">
                 <c:param name="logout" value="logout" />
          </c:url>">Logout</a>
        </div>
        <h1 class="text-center mt-5 pt-5">Driver Panel</h1>
        <div class="d-grid gap-4 mx-auto">
           <%-- Register Driver Panel --%>
           <a class="btn btn-dark mx-auto" href="<c:url value = "/driver"> 
                  <c:param name = "action" value="list" />
              </c:url>">View Assigned jobs</a>
       </div>
</body>
</html>
