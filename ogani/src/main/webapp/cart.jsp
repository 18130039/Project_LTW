<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edu.model.Cart" %>
<%@ page import="java.util.Collection" %>
<%@ page import="edu.beans.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <h2>Giỏ hàng</h2>

                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__table">
                    <table>
                        <thead>
                        <tr>
                            <th class="shoping__product">Sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng cộng</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <% Cart c = Cart.getCart(session);
                            Collection<Product> data = c.getData();
                            request.setAttribute("data",data);
                            long total = c.total();
                            request.setAttribute("total",total);
                        %>
                        <c:forEach items="${data}" var="d">
                        <tr>
                            <td class="shoping__cart__item">
                                <img src="${d.img}" style="width: 100px; height: 100px" alt="">
                                <h5>${d.name}</h5>
                            </td>
                            <td class="shoping__cart__price">
                                    ${d.price}
                            </td>
                            <td class="shoping__cart__quantity">
                                <div class="quantity">
                                    <div class="pro-qty">

                                        <a href="desCart?id=${d.id}&quantity=${d.quantity}"><span class="dec qtybtn">-</span></a>
                                        <input name="quantity" type="text" value="${d.quantity}">
                                        <a href="addCart?id=${d.id}"><span class="inc qtybtn">+</span></a>
                                    </div>
                                </div>
                            </td>
                            <td class="shoping__cart__total">
                                    ${d.quantity * d.priceLong /1000}00đ
                            </td>
                            <td class="shoping__cart__item__close">
                                <a href="desCart?id=${d.id}&quantity=0"><span class="icon_close"></span></a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__btns">
                    <a href="home" class="primary-btn cart-btn">Tiếp tục mua hàng</a>
                    <a href="refresh" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                        Cập nhật</a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shoping__continue">
                    <div class="shoping__discount">
                        <h5>Mã giảm giá</h5>
                        <form action="#">
                            <input type="text" placeholder="Nhập mã">
                            <button type="submit" class="site-btn">ÁP DỤNG</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shoping__checkout">
                    <h5>Tổng tiền</h5>
                    <ul>

                        <li>Tạm tính <span class="tongcong">${total/1000}00đ</span></li>
                        <li>Tổng cộng <span class="tongcong">${total/1000}00đ</span></li>
                    </ul>

                    <c:if test="${sessionScope.acc == null}">
                        <a href="login.jsp?from=${pageContext.request.requestURI}" class="primary-btn">THANH TOÁN</a>
                    </c:if>
                    <c:if test="${sessionScope.acc != null}">
                        <a href="checkout" class="primary-btn">THANH TOÁN</a>
                    </c:if>

                    <p style="text-align: center;margin: 10px 0 0;color: red;">${emptyAlert}</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shoping Cart Section End -->

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
<script type="text/javascript">
    'use strict';

    (function ($) {

        /*------------------
            Preloader
        --------------------*/
        $(window).on('load', function () {
            $(".loader").fadeOut();
            $("#preloder").delay(200).fadeOut("slow");

            /*------------------
                Gallery filter
            --------------------*/
            $('.featured__controls li').on('click', function () {
                $('.featured__controls li').removeClass('active');
                $(this).addClass('active');
            });
            if ($('.featured__filter').length > 0) {
                var containerEl = document.querySelector('.featured__filter');
                var mixer = mixitup(containerEl);
            }
        });

        /*------------------
            Background Set
        --------------------*/
        $('.set-bg').each(function () {
            var bg = $(this).data('setbg');
            $(this).css('background-image', 'url(' + bg + ')');
        });

        //Humberger Menu
        $(".humberger__open").on('click', function () {
            $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
            $(".humberger__menu__overlay").addClass("active");
            $("body").addClass("over_hid");
        });

        $(".humberger__menu__overlay").on('click', function () {
            $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
            $(".humberger__menu__overlay").removeClass("active");
            $("body").removeClass("over_hid");
        });

        /*------------------
            Navigation
        --------------------*/
        $(".mobile-menu").slicknav({
            prependTo: '#mobile-menu-wrap',
            allowParentLinks: true
        });

        /*-----------------------
            Categories Slider
        ------------------------*/
        $(".categories__slider").owlCarousel({
            loop: true,
            margin: 0,
            items: 4,
            dots: false,
            nav: true,
            navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
            animateOut: 'fadeOut',
            animateIn: 'fadeIn',
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true,
            responsive: {

                0: {
                    items: 1,
                },

                480: {
                    items: 2,
                },

                768: {
                    items: 3,
                },

                992: {
                    items: 4,
                }
            }
        });


        $('.hero__categories__all').on('click', function(){
            $('.hero__categories ul').slideToggle(400);
        });

        /*--------------------------
            Latest Product Slider
        ----------------------------*/
        $(".latest-product__slider").owlCarousel({
            loop: true,
            margin: 0,
            items: 1,
            dots: false,
            nav: true,
            navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true
        });

        /*-----------------------------
            Product Discount Slider
        -------------------------------*/
        $(".product__discount__slider").owlCarousel({
            loop: true,
            margin: 0,
            items: 3,
            dots: true,
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true,
            responsive: {

                320: {
                    items: 1,
                },

                480: {
                    items: 2,
                },

                768: {
                    items: 2,
                },

                992: {
                    items: 3,
                }
            }
        });

        /*---------------------------------
            Product Details Pic Slider
        ----------------------------------*/
        $(".product__details__pic__slider").owlCarousel({
            loop: true,
            margin: 20,
            items: 4,
            dots: true,
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true
        });

        /*-----------------------
            Price Range Slider
        ------------------------ */
        var rangeSlider = $(".price-range"),
            minamount = $("#minamount"),
            maxamount = $("#maxamount"),
            minPrice = rangeSlider.data('min'),
            maxPrice = rangeSlider.data('max');
        rangeSlider.slider({
            range: true,
            min: minPrice,
            max: maxPrice,
            values: [minPrice, maxPrice],
            slide: function (event, ui) {
                minamount.val('$' + ui.values[0]);
                maxamount.val('$' + ui.values[1]);
            }
        });
        minamount.val('$' + rangeSlider.slider("values", 0));
        maxamount.val('$' + rangeSlider.slider("values", 1));

        /*--------------------------
            Select
        ----------------------------*/
        $("select").niceSelect();

        /*------------------
            Single Product
        --------------------*/
        $('.product__details__pic__slider img').on('click', function () {

            var imgurl = $(this).data('imgbigurl');
            var bigImg = $('.product__details__pic__item--large').attr('src');
            if (imgurl != bigImg) {
                $('.product__details__pic__item--large').attr({
                    src: imgurl
                });
            }
        });

        /*-------------------
            Quantity change
        --------------------- */
        <%--var proQty = $('.pro-qty');--%>
        <%--proQty.prepend('<a href="addCart?id=${d.id}"><span class="dec qtybtn">-</span></a>');--%>
        <%--proQty.append('<a href="addCart?id=${d.id}"><span class="inc qtybtn">+</span></a>');--%>
        <%--proQty.on('click', '.qtybtn', function () {--%>
        <%--    var $button = $(this);--%>
        <%--    var oldValue = $button.parent().find('input').val();--%>
        <%--    if ($button.hasClass('inc')) {--%>
        <%--        var newVal = parseFloat(oldValue) + 1;--%>
        <%--    } else {--%>
        <%--        // Don't allow decrementing below zero--%>
        <%--        if (oldValue > 0) {--%>
        <%--            var newVal = parseFloat(oldValue) - 1;--%>
        <%--        } else {--%>
        <%--            newVal = 0;--%>
        <%--        }--%>
        <%--    }--%>
        <%--    $button.parent().find('input').val(newVal);--%>
        <%--});--%>

    })(jQuery);
</script>

<script type="text/javascript">
    var tien = document.getElementsByClassName("tongcong");

</script>
</body>

</html>
