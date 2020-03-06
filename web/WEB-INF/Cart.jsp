<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="Header.jsp" %>

<div class="container">
    <h1 class="text-center">Your Cart</h1>
    <c:if test="${!empty sessionScope.list_products}">
        <div class="cart-list" style="width: 250px" >
            <c:forEach items="${ sessionScope.list_products }" var="list_product" varStatus="status">
                <form action="Cart" method="post">
                    <div class="product-widget">
                        <div class="product-img">
                            <img src="./img/product01.png" alt="">
                        </div>
                        <div class="product-body">
                            <h3 class="product-name"><a href="#"><c:out value="${ list_product.name }" /></a></h3>
                            <h4 class="product-price">$<c:out value="${ list_product.price }" /></h4>
                        </div>
                        <input class="hidden" type="number" name="delete" value="<c:out value="${ status.index }" />">
                        <button type="submit" class="delete"><i class="fa fa-close"></i></button>
                    </div>
                </form>
            </c:forEach>
        </div>

        <div class="cart-summary text-center">
            <small><c:out value='${requestScope.total_products}' /> Item(s) selected</small>
            <h5>SUBTOTAL: $<c:out value='${requestScope.total}' /></h5>
        </div>
        <div class="cart-btns text-center">
            <a href="#" style="font-size: 18px">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
        </div>
    </c:if>

    <c:if test="${empty sessionScope.list_products}">
        <h2 class="text-center">Your cart is empty !</h2>
    </c:if>

</div>

<%@ include file="Footer.jsp" %>