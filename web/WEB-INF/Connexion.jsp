<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<div class="container">
    <h1 style="margin: 50px">Login</h1>
    <form style="margin: 100px; margin-top: 50px;" method="post">
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email" autofocus value="${email}">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <c:if test="${ error }">
            <div style="text-align: center; margin-bottom: 20px;">
                <small style="color: red;text-align: center">Try to reconnect, email or password is wrong</small>
            </div>
        </c:if>
        <div class="row">
            <div class="col-md-6">
                <button style="width: 100%" type="submit" class="btn btn-primary">Submit</button>
            </div>
            <div class="col-md-6" style="text-align: center">
                <a href="Signin"><i class="fa fa-user-o"></i> You don't have any account ? Create it !</a>
            </div>
        </div>
    </form>
</div>

<%@ include file="Footer.jsp" %>