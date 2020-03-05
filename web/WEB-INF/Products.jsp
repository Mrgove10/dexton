<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<%@ include file="Navigation.jsp" %>

<c:if test="${listNewProducts.isEmpty() == false}">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-title">
                        <h3 class="title">New products</h3>
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div class="tab-pane active">
                            <div class="products-slick" data-nav="#slick-nav-1">
                                <c:forEach items="${listNewProducts}" var="product">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/product01.png" alt="">
                                            <div class="product-label">
                                                    <%--                                        <span class="sale">-30%</span>--%>
                                                <span class="new">NEW</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">
                                                <c:forEach items="${categories}" var="category">
                                                    <c:if test="${category.getId() == product.getCategoryID()}">
                                                        ${category.getName()}
                                                    </c:if>
                                                </c:forEach>
                                            </p>
                                            <h3 class="product-name"><a href="#">${product.getName()}</a></h3>
                                            <h4 class="product-price">
                                                $ ${product.getPrice()}
                                                    <%--                                        <del class="product-old-price">$990.00</del>--%>
                                            </h4>
                                            <div class="product-rating">
                                                <c:forEach begin="1" end="${product.getRating()}" step="1" var="i">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                            </div>
                                            <div class="product-btns">
                                                <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div id="slick-nav-1" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>

        </div>


    </div>
</c:if>
<c:if test="${listProducts.isEmpty() == false}">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-title">
                        <h3 class="title">Products</h3>
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div class="tab-pane active">
                            <div class="products-slick" data-nav="#slick-nav-1">
                                <c:forEach items="${listProducts}" var="product">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/product01.png" alt="">
                                            <div class="product-label">
                                                    <%--                                        <span class="sale">-30%</span>--%>
                                                <c:forEach items="${listNewProducts}" var="newProduct">
                                                    <c:if test="${newProduct == product}">
                                                        <span class="new">NEW</span>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">
                                                <c:forEach items="${categories}" var="category">
                                                    <c:if test="${category.getId() == product.getCategoryID()}">
                                                        ${category.getName()}
                                                    </c:if>
                                                </c:forEach>
                                            </p>
                                            <h3 class="product-name"><a href="#">${product.getName()}</a></h3>
                                            <h4 class="product-price">
                                                $ ${product.getPrice()}
                                                    <%--                                        <del class="product-old-price">$990.00</del>--%>
                                            </h4>
                                            <div class="product-rating">
                                                <c:forEach begin="1" end="${product.getRating()}" step="1" var="i">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                            </div>
                                            <div class="product-btns">
                                                <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>

        </div>


    </div>
</c:if>

<c:if test="${listProducts.isEmpty()}">
    <div class="container">
        <div class="row">
            <div class="col-md-12" style="color: red; font-style: italic; text-align: center; margin-top: 100px; margin-bottom: 100px; font-size: 20px;">
                There is no products in this category
            </div>
        </div>
    </div>
</c:if>

<%@ include file="Footer.jsp" %>