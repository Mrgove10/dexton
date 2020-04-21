<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Header.jsp" %>
<div class="container">
    <h1>Page d'admininstration</h1>
    <!--Products-->
    <c:if test="${listProducts.isEmpty() == false}">
        <h2>Products</h2>
        <h3>Product list</h3>
        <table style="width:100%">
            <tr>
                <th>Name</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Description</th>
                <th>Rating</th>
                <th>Modify</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listProducts}" var="product">
                <tr>
                    <form style="margin: 100px; margin-top: 50px;" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="update_form" name="update_form">
                        </div>
                        <td>
                            <div class="form-group">
                                <input type="text" class="form-control" id="name" name="name"
                                       placeholder="Name" value="${product.getName()}">
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <input type="text" class="form-control" id="brand" name="brand"
                                       placeholder="Name" value="${product.getBrand()}">
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <input type="number" class="form-control" id="price" name="price"
                                       placeholder="99999" value="${product.getPrice()}">
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <input type="text" class="form-control" id="description" name="description"
                                       placeholder="Description" value="${product.getDescription()}">
                            </div>
                        </td>
                        <td>
                            <p>${product.getRating()}</p>
                        </td>

                        <td>
                            <div class="col-md-6">
                                <button style="width: 100%" type="submit" class="btn btn-primary">Submit</button>
                            </div>
                            <div class="col-md-6">
                                    ${message}
                            </div>
                        </td>
                        <td>
                            <button style="width: 100%" type="submit" class="btn btn-primary">Delete</button>
                        </td>

                    </form>
                </tr>
            </c:forEach>
        </table>
    </c:if><br>

    <!-- Add a product-->
    <h3>Add a product</h3>
    <form style="margin: 100px; margin-top: 50px;" method="post">

        <div class="form-group">
            <input type="hidden" class="form-control" id="add_form" name="add_form">
        </div>
        <div class="form-group">
            <label for="add_name">Name</label>
            <input type="text" class="form-control" id="add_name" name="add_name"
                   placeholder="Name" value="${product.getName()}">
        </div>

        <div class="form-group">
            <label for="add_brand">Brand</label>
            <input type="text" class="form-control" id="add_brand" name="add_brand"
                   placeholder="Brand" value="${product.getBrand()}">
        </div>

        <div class="form-group">
            <label for="add_price">Price</label>
            <input type="number" class="form-control" id="add_price" name="add_price"
                   placeholder="Price" value="${product.getPrice()}">
        </div>

        <div class="form-group">
            <label for="add_description">Description</label>
            <input type="text" class="form-control" id="add_description" name="add_description"
                   placeholder="Description" value="${product.getDescription()}">
        </div>
        <div class="form-group">
            <label for="add_category">Category</label>
            <input type="number" class="form-control" id="add_category" name="add_category"
                   placeholder="Category" value="${product.getCategoryID()}">
        </div>

        <div class="col-md-6">
            <button style="width: 100%" type="submit" class="btn btn-primary">Submit</button>
        </div>
        <div class="col-md-6">
            ${message}
        </div>
    </form>
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
                    <td>${user.getRole().getName()}</td>
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