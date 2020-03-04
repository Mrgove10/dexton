<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<div class="container">
    <h1 style="margin: 50px">Login</h1>
    <form style="margin: 100px" method="post">
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <c:if test="${ error }">
            <div style="text-align: center">
                <small style="color: red;text-align: center">Try to reconnect, your email or password is wrong</small>
            </div>
        </c:if>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%@ include file="Footer.jsp" %>