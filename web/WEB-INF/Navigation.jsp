<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li <c:if test="${ currentPage == 'Home' }">class="active"</c:if>>
                    <a href="Home">Home</a>
                </li>
                <li <c:if test="${ currentPage == 'All' }">class="active"</c:if>>
                    <a href="All">All</a>
                </li>
                <c:forEach items="${categories}" var="category">
                    <li <c:if test="${ currentPage == category.getName() }">class="active"</c:if>>
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