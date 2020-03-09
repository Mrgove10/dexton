<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<div class="container">
    <h1>Page d'admininstration</h1>
    <c:if test="${listProducts.isEmpty() == false}">
        <ul>
            <c:forEach items="${listProducts}" var="product">
                <li> ${product.getName()}</li>
            </c:forEach>
        </ul>
    </c:if>
</div>
<%@ include file="Footer.jsp" %>