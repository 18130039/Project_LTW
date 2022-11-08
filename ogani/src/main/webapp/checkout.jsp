<%@ page import="edu.beans.Product" %>
<%@ page import="edu.model.Cart" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>OganiNLU - Thực phẩm hữu cơ</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');
    </style>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<jsp:include page="menu.jsp"></jsp:include>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Thanh toán</h2>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Checkout Section Begin -->
<section class="checkout spad">
    <div class="container">

        <div class="checkout__form">
            <h4>Thông tin đơn hàng</h4>
            <form action="order" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Họ tên<span>*</span></p>
                                    <input type="text" name="ten" required>
                                </div>
                            </div>
                        </div>
<%--                        <div class="checkout__input">--%>
<%--                            <p style="font-size: 1.4rem; font-weight: bold; margin: 25px 0">Địa chỉ</p>--%>
<%--                        </div>--%>
                        <div class="checkout__input">
                            <p>Địa chỉ giao hàng<span>*</span></p>
                            <input type="text" name="add1" required>
                        </div>

                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Điện thoại<span>*</span></p>
                                    <input type="text" name="phone" required>
                                </div>
                            </div>
                        </div>


                        <div class="checkout__input">
                            <p>Lời nhắn cho người bán</p>
                            <input type="text">
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="checkout__order">
                            <h4>Đơn hàng</h4>
                            <div class="checkout__order__products">Sản phẩm <span>Đơn giá</span></div>
                            <ul>
                                <% Cart c = Cart.getCart(session);
                                    Collection<Product> data = c.getData();
                                    request.setAttribute("data",data);
                                    long total = c.total();
                                    request.setAttribute("total",total);
                                %>
                                <c:forEach items="${data}" var="d">
                                    <li>${d.name} - SL:${d.quantity}<span>${d.price}</span></li>
                                </c:forEach>
                            </ul>

                            <div class="checkout__order__subtotal">Tạm tính <span>${total/1000}00đ</span></div>
                            <div class="checkout__order__total">Giảm giá <span>0đ</span></div>
                            <div class="checkout__order__total">Tổng tiền <span>${total/1000}00đ</span></div>

<%--                            <c:if test="${sessionScope.acc == null}">--%>
<%--                                <a href="login.jsp" style="width: 100%; font-size: 1rem; text-align: center; cursor: pointer" class="site-btn">ĐẶT HÀNG</a>--%>
<%--                            </c:if>--%>
<%--                            <c:if test="${sessionScope.acc != null}">--%>
<%--                                <input style="width: 100%; font-size: 1rem" class="site-btn" type="submit" value="ĐẶT HÀNG" />--%>
<%--                            </c:if>--%>
                            <input style="width: 100%; font-size: 1rem" class="site-btn" type="submit" value="ĐẶT HÀNG" />

                            <div class="vat-p">
                                <span style="float: right; margin: .3rem 0; font-size: .9rem;"><i>(Đã bao gồm VAT nếu có)</i></span>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>


<!-- Checkout Section End -->

<footer class="footer spad">
    <div class="container">
        <div class="row" style="display: flex; justify-content: center;">

            <div class="col-lg-8 col-md-12" style="text-align: center;">
                <div class="footer__widget">
                    <h2>Đăng ký nhận ưu đãi ngay!</h2>
                    <p style="font-size: 1rem">Nhận email về sản phẩm đặc biệt và các ưu đãi hấp dẫn.</p>
                    <form action="#">
                        <input type="text" placeholder="Nhập địa chỉ email">
                        <button type="submit" class="site-btn">Đăng ký</button>
                    </form>
                    <div class="footer__widget__social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</footer>

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>



</body>

</html>