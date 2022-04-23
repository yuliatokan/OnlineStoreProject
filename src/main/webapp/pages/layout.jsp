<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="edu.store.entity.Cart"%>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
%>
<c:url var="url1" value="https://online-store-tokan.herokuapp.com"></c:url>
<c:url var="url" value="http://localhost:8080"></c:url>
<div style="margin: 20px;">
    <nav class="navbar navbar-expand-md navbar-light bg-light" style="background-color: rgba(248, 186, 202, 0.65) !important;">
        <a href="/" class="navbar-brand">TOKANclothes</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Catalog</a>
                    <div id="types" class="dropdown-menu" style="background: rgb(255,239,246)">

                    </div>
                </li>
                <li class="nav-item">
                    <a href="/campaign" class="nav-link">Campaign</a>
                </li>
                <li class="nav-item">
                    <a href="/about_us" class="nav-link">About Us</a>
                </li>
                <li class="nav-item">
                    <a href="/contacts" class="nav-link">Contacts</a>
                </li>
                <c:if test="${sessionScope.admin =='true'}">
                    <li class="nav-item">
                        <a href="/admin/add" class="nav-link">Add Item</a>
                    </li>
                    <li class="nav-item">
                        <a href="/admin/users" class="nav-link">Users</a>
                    </li>
                    <li class="nav-item">
                        <a href="/orders" class="nav-link">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a href="/admin/products" class="nav-link">Products</a>
                    </li>
                </c:if>
            </ul>
            <div class="col-sm-4 ml-auto">
                <form action="/search" method="POST" class="input-group input-group-sm">
                    <input style="outline: 0 none;" type="text" id="search" name="search" class="form-control" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </form>
            </div>
            <ul class="nav navbar-nav ">
                <li class="nav-item dropdown">

                    <c:if test="${sessionScope.exist_user=='true'}">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            <c:out value="${sessionScope.name}"/>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" style="background: rgb(255,239,246)">
                            <a href="/cart" class="dropdown-item">Cart</a>
                            <c:if test="${sessionScope.admin !='true'}">
                            <a href="/user/edit" class="dropdown-item">Edit</a>
                            </c:if>
                            <div class="dropdown-divider"></div>
                            <a href="/logout" class="dropdown-item">Logout</a>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.exist_user=='false' || sessionScope.exist_user eq null}">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Sign</a>
                        <div class="dropdown-menu dropdown-menu-right" style="background: rgb(255,239,246)">
                            <a href="/sign_in" class="dropdown-item">Sign in</a>
                            <a href="/sign_up" class="dropdown-item">Sign up</a>
                        </div>
                    </c:if>

                </li>
            </ul>
            <a style="color: rgba(0,0,0,0.75)" href="/cart" id="cart">
                <i class="fas fa-shopping-cart"></i>
            </a>
                <label style="margin-left: 4px; margin-top: 3px" id="cart_items" for="cart">(${sessionScope.cart.getCartItems().size()})</label>
        </div>
    </nav>
</div>