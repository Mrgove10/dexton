<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<div class="container">
    <h1>Page d'admininstration</h1>
    <!--Products-->
    <c:if test="${listProducts.isEmpty() == false}">
        <h2>Products</h2>
        <table style="width:100%">
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listProducts}" var="product">
                <tr>
                    <td>${product.getName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>
                        <button>Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if><br>

    <!--Users-->
    <c:if test="${listUsers.isEmpty() == false}">
        <h2>Users</h2>
        <table style="width:100%">
            <tr>
                <th>Id</th>
                <th>Email</th>
                <th>Name</th>
                <th>Role</th>
            </tr>
            <c:forEach items="${listUsers}" var="user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getRole()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if><br>

    <!--Orders-->
    <c:if test="${listOrders.isEmpty() == false}">
        <h2>Orders</h2>
        <table style="width:100%">
            <tr>
                <th>Id</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${listOrders}" var="order">
                <tr>
                    <td>${order.getId()}</td>
                    <td>${order.getStatus()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>


</div>
<%@ include file="Footer.jsp" %>