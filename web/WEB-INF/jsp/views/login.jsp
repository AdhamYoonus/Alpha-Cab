<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In - Alpha Cab</title>
    </head>
    
    <body class="p-2 text-dark bg-opacity-10 pt-5">
        <h1 class="text-center mt-5 pt-5">Log In</h1>
        <c:if test="${loginFailed}">
            <p class ="text-center alert alert-danger w-25 mx-auto"  >
                Invalid Credentials.Try again!
            </p>
        </c:if>
        <form class='text-white w-75 text-center mx-auto' action="login" method='post'>
            <label class="form-label">Username
            </label>
                <input class="form-control w-50 mx-auto mb-2" name='username' />
            <label class="form-label">Password
            </label>
                <input  class="form-control w-50 mx-auto mb-4" type="password" name='password' /> 
                 <!-- <p class ="alert alert-danger w-25 mx-auto"  > ${error}</p> -->
            <button type="submit" style="background-color: black; border-radius: 10px; width: 100px;" class="btn btn-primary">Login</button>
        </form>
      
    </body>
</html>
