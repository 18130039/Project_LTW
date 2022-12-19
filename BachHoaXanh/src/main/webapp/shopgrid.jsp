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
                    <h2>Cửa hàng</h2>

                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Section Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-5">
                <div class="sidebar">
                    <div class="sidebar__item">
                        <h4>Danh mục</h4>
                        <ul>
                            <c:forEach items="${listC}" var="o">
                                <li><a href="category?index=1&cid=${o.cid}">${o.cname}</a></li>
                            </c:forEach>
                        </ul>
                    </div>


                    <div class="sidebar__item">
                        <h4>Khối lượng</h4>
                        <div class="sidebar__item__size">
                            <label for="large">
                                Lớn
                                <input type="radio" id="large">
                            </label>
                        </div>
                        <div class="sidebar__item__size">
                            <label for="medium">
                                Vừa
                                <input type="radio" id="medium">
                            </label>
                        </div>
                        <div class="sidebar__item__size">
                            <label for="small">
                                Nhỏ
                                <input type="radio" id="small">
                            </label>
                        </div>
                        <div class="sidebar__item__size">
                            <label for="tiny">
                                Lẻ
                                <input type="radio" id="tiny">
                            </label>
                        </div>
                    </div>
                    <div class="sidebar__item">
                        <div class="latest-product__text">
                            <h4>Sản phẩm mới</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <a href="#" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="img/product/hotdog.jpg" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>Hot dog</h6>
                                            <span>35.000đ</span>
                                        </div>
                                    </a>
                                    <a href="#" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="img/product/caibe.jpg" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>Cải bẹ xanh</h6>
                                            <span>15.000đ</span>
                                        </div>
                                    </a>
                                    <a href="#" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="img/product/cherry-uc.jpg" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>Cherry Úc</h6>
                                            <span>499.000đ</span>
                                        </div>
                                    </a></div><div class="latest-prdouct__slider__item">
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/product/chuoi.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Chuối tiêu</h6>
                                        <span>75.000đ</span>
                                    </div>
                                </a><a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/cachep.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Cá chép</h6>
                                    <span>199.000đ</span>
                                </div>
                            </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/product/ucga.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Ức gà</h6>
                                        <span>39.000đ</span>
                                    </div>
                                </a>

                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 col-md-7">
                <div class="product__discount">
                    <div class="section-title product__discount__title">
                        <h2>Khuyến mãi</h2>
                    </div>
                    <div class="row">
                        <div class="product__discount__slider owl-carousel">
                            <c:forEach items="${list}" var="o">

                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="${o.img}">
                                        <div class="product__discount__percent">-20%</div>
                                        <ul class="product__item__pic__hover">

                                            <li><a href="addCart?id=${o.id}"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span></span>
                                        <h5><a href="detail?pid=${o.id}">${o.name}</a></h5>
                                        <div class="product__item__price">${o.price} <span>${(o.priceLong-o.priceLong/5)/1000}00đ</span></div>
                                    </div>
                                </div>
                            </div>

                            </c:forEach>

                        </div>
                    </div>
                </div>
                <div class="filter__item">
                    <div class="row">
                        <div class="col-lg-4 col-md-5">

                        </div>
                        <div class="col-lg-4 col-md-4">
                            <div class="filter__found">

                            </div>
                        </div>
                        <div class="col-lg-4 col-md-3">
                            <div class="filter__option">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${listPage}" var="o">
                    <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                        <div class="featured__item">
                            <div class="featured__item__pic set-bg" data-setbg="${o.img}">
                                <ul class="featured__item__pic__hover">

                                    <li><a href="addCart?id=${o.id}"><i class="fa fa-shopping-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="featured__item__text">
                                <h6><a href="detail?pid=${o.id}">${o.name}</a></h6>
                                <h5>${o.price}</h5>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <div class="clearfix" style="width: 100%">
                    <div class="product__pagination">
                        <c:forEach begin="1" end="${endPage}" var="i">
                            <a id="${i}" href="shopGrid?index=${i}">${i}</a>

                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Section End -->

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