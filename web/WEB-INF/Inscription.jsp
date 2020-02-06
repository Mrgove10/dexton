<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<div class="container">
    <h1 style="margin: 50px">Create your account !</h1>
    <form style="margin: 100px" method="post">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="prenom">First name :</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="First name..." required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="nom">Last name :</label>
                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Last name..." required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email" required>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="pwd">Password</label>
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@ include file="Footer.jsp" %>