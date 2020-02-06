<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<div class="container">
    <form action="Inscription.jsp" method="post">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="prenom">First name :</label>
                    <input type="text" class="form-control" id="prenom" placeholder="First name...">
                </div>
            </div>
            <div class="col-md-12">
                <div class="form-group">
                    <label for="nom">Last name :</label>
                    <input type="text" class="form-control" id="nom" placeholder="Last name...">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email" required>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="pwd">Password</label>
            <input type="password" class="form-control" id="pwd" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@ include file="Footer.jsp" %>