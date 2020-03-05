
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="Header.jsp" %>
<div class="container">
    <h1 style="margin: 50px">Account</h1>
    <form style="margin: 100px; margin-top: 50px;" method="post">

        <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="${ user.getFirstName() }">
        </div>

        <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="${ user.getLastName() }">
        </div>

        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email" value="${ user.getEmail() }">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>

        <div class="row">
            <div class="col-md-6">
                <button style="width: 100%" type="submit" class="btn btn-primary">Submit</button>
            </div>
            <div class="col-md-6">
                ${message}
            </div>
        </div>
    </form>
</div>
<%@ include file="Footer.jsp" %>
