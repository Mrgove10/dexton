<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>

<div class="container">
    <h1 class="text-center">Your Cart</h1>

    <div class="cart-list">
        <div class="product-widget">
            <div class="product-img">
                <img src="./img/product01.png" alt="">
            </div>
            <div class="product-body">
                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                <h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
            </div>
            <button class="delete"><i class="fa fa-close"></i></button>
        </div>

        <div class="product-widget">
            <div class="product-img">
                <img src="./img/product02.png" alt="">
            </div>
            <div class="product-body">
                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                <h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
            </div>
            <button class="delete"><i class="fa fa-close"></i></button>
        </div>
    </div>
    <div class="cart-summary">
        <small>3 Item(s) selected</small>
        <h5>SUBTOTAL: $2940.00</h5>
    </div>
    <div class="cart-btns">
        <a href="#">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
    </div>

</div>

<%@ include file="Footer.jsp" %>