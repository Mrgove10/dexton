<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>

<form id="login" method="post">
    <h1>Connexion</h1>
    <fieldset id="inputs">
        <img class="connect" src="img/username.png">&nbsp;&nbsp;&nbsp;
        <input name="login" type="email" value="${ user.getEmail() }" placeholder="Email" autofocus>
        <br/>
        <img class="connect" src="img/password.png" style="width: 128px">&nbsp;&nbsp;&nbsp;
        <input name="pwd" type="password" value="${ user.getPassword() }" placeholder="Mot de passe">
    </fieldset>
    <fieldset id="actions">
        <input type="submit" class="btn btn-primary" id="submit" value="Valider">&nbsp;&nbsp;&nbsp;
        <input type="reset" class="btn btn-primary" id="reset" value="Remise à zéro">
        <a href="Message">Mot de passe oublié ?</a>
    </fieldset>
    <fieldset id="new">
        <p>Nouveau sur le site ?
            <a href="Inscription">Créer votre compte</a></p>
    </fieldset>
</form>

<%@ include file="Footer.jsp" %>