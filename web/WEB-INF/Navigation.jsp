<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active"><a href="Home">Home</a></li>
                <li><a href="#">Hot Deals</a></li>
                <li><a href="All">All</a></li>
                <c:forEach items="${categories}" var="category">
                    <li>
                        <a href="<c:out value='${category.getName()}'/>">
                            <c:out value='${category.getName()}'/>
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->