<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alpha-Cab|Admin</title>
        <link href="assests/css/bootstrap.css" rel="stylesheet">
        <script src="assests/js/bootstrap.bundle.min.js"></script>
    </head>

    <body class="p-2 text-dark bg-opacity-10 pt-5">
        <div class="container-sm">
            <a class="btn btn-danger" href="<c:url value="login">
                 <c:param name="logout" value="logout" />
          </c:url>">Logout</a>
        </div>
        <h1 class="text-center mt-5 pt-5 mb-5">Admin Panel</h1>
    <form>
    <div class="d-grid gap-4 mx-auto">
      <%-- Register Driver Panel --%>
          <a class="btn btn-dark mx-auto" href="<c:url value = "/admin/driver"> 
                 <c:param name = "action" value="register" />
              </c:url>">Register New Driver</a>
      <%-- Register New Customer Panel --%>
          <a class="btn btn-dark mx-auto" href="<c:url value="/admin/customer">
                 <c:param name="action" value="register" />
          </c:url>">Register New Customer</a>
      <%-- List All Drivers Panel --%>
          <a class="btn btn-dark mx-auto" href="<c:url value="/admin/driver">
                 <c:param name="action" value="list"/>
          </c:url>">List All Drivers</a>
          <a href="<c:url value="/admin/customer">
                 <c:param name="action" value="list" />
          </c:url>" class="btn btn-dark mx-auto">List All Customers</a>
          <a class="btn btn-dark mx-auto" href="<c:url value="/admin/booking">
                 <c:param name="action" value="list" />
          </c:url>">Assign Bookings</a>
          
          <a class="btn btn-dark mx-auto" href="<c:url value="/admin/customer-report">
                 <c:param name="action" value="report" />
          </c:url>">Generate Customer Report</a>
          
          <a class="btn btn-dark mx-auto" href="<c:url value="/admin/booking">
                 <c:param name="action" value="price" />
          </c:url>">Set Price</a>
      </div>
    </form>
</body>
</html>
