<%@page import="edu.beans.Account"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
Account acc = (Account) session.getAttribute("userlogin");
%>
<!-- Header Section Begin -->
<header class="header">

	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="home"><img src="img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="col-lg-7">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="home">Trang chủ</a></li>
						<li><a href="shopGrid?index=1">Cửa hàng</a></li>
						<li><a href="./contact.jsp">Liên hệ</a></li>
						<c:if test="${sessionScope.acc.isSell == 1}">
							<li><a href="manage?index=1">Quản lý sản phẩm</a></li>
						</c:if>
						<c:if test="${sessionScope.acc.isAdmin == 1}">
							<li><a href="#">Quản lý tài khoản</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			<div class="col-lg-2">
				<div class="header__cart">
					<ul>

						<li><a href="cart.jsp"><i class="fa fa-shopping-bag"></i>
						</a></li>
					</ul>

				</div>
			</div>
		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
<!-- Header Section End -->

<!-- Hero Section Begin -->
<section class="hero hero-normal">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>Danh mục</span>
					</div>
					<ul>

						<li><a href="category?index=1&cid=1">Thịt và hải sản</a></li>
						<li><a href="category?index=1&cid=2">Rau quả</a></li>
						<li><a href="category?index=1&cid=3">Trái cây</a></li>
						<li><a href="category?index=1&cid=4">Thức ăn nhanh</a></li>
						<li><a href="category?index=1&cid=5">Trứng</a></li>
						<li><a href="category?index=1&cid=6">Sữa</a></li>

					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">

					<div class="hero__search__form">

						<form action="SearchServlet?index=1" method="POST">
							<div class="hero__search__categories">
								<i class="fa fa-search"></i>
							</div>
							<input type="text" name="txtSearch"
								placeholder="Hôm nay bạn muốn mua gì?" required>
							<button type="submit" class="site-btn">Tìm kiếm</button>
						</form>

					</div>

					<div class="hero__search__phone">
						<div class="header__top__right__auth">
							<%
							if (acc != null) {
							%>
							<div class="header__top__right__auth">
								<i class="fa fa-user"></i> Xin chào,
							</div>
							<%
							out.print(acc.getNameOfCustomer());
							%>
							<div class="header__top__right__auth">
								<a href="login?action=Logout"><i class="fa fa-sign-out"></i>
									Đăng xuất</a>
							</div>
							<%
							}
							%>
							</a>
						</div>
						<%
						if (acc == null) {
						%>
						<div class="header__top__right__auth mt-3 mr-3">
							<a href="signup.jsp"><i class="fa fa-key"></i> Đăng ký</a>
						</div>
						<div class="header__top__right__auth">
							<a href="login.jsp"><i class="fa fa-user"></i> Đăng nhập</a>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Hero Section End -->