<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="zxx" xmlns:jsp="http://java.sun.com/jsf/facelets">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>OganiNLU - Thực phẩm hữu cơ</title>

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

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');
    </style>

</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

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

                        <li><a href="cart.jsp"><i class="fa fa-shopping-bag"></i> </a></li>
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
<section class="hero">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fa fa-bars"></i>
                        <span>Danh mục</span>
                    </div>
                    <ul>
                        <c:forEach items="${listC}" var="o">
                            <li><a href="category?index=1&cid=${o.cid}">${o.cname}</a></li>
                        </c:forEach>
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
                            <input type="text" name="txtSearch" placeholder="Hôm nay bạn muốn mua gì?" required>
                            <button type="submit" class="site-btn">Tìm kiếm</button>
                        </form>

                    </div>
                    <div class="hero__search__phone">
                        <c:if test="${sessionScope.acc == null}">
                            <div class="header__top__right__auth mt-3 mr-3">
                                <a href="signup.jsp"><i class="fa fa-key"></i> Đăng ký</a>
                            </div>
                            <div class="header__top__right__auth">
                                <a href="login.jsp"><i class="fa fa-user"></i> Đăng nhập</a>
                            </div>
                        </c:if>

                        <c:if test="${sessionScope.acc != null}">
                            <div class="header__top__right__auth mt-3 mr-3">
                                <a href="#"><i class="fa fa-user"></i> ${sessionScope.acc.user}</a>
                            </div>
                            <div class="header__top__right__auth">
                                <a href="logout"><i class="fa fa-sign-out"></i> Đăng xuất</a>
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="hero__item set-bg" data-setbg="img/hero/banner.jpg">
                    <div class="hero__text">
                        <span>RAU QUẢ TƯƠI</span>
                        <h2>Rau Quả <br />100% Hữu Cơ</h2>
                        <p>Giao hàng miễn phí tận nơi</p>
                        <a href="shopGrid?index=1" class="primary-btn">MUA NGAY</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

    <!-- Categories Section Begin -->
<section class="categories">
    <div class="container">
        <div class="row">
            <div class="categories__slider owl-carousel">
                <div class="col-lg-3">
                    <div class="categories__item set-bg" data-setbg="img/categories/cat-1.jpg">
                        <h5><a>Trái cây tươi</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg" data-setbg="img/categories/cat-2.jpg">
                        <h5><a>Trái cây sấy</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg" data-setbg="img/categories/cat-3.jpg">
                        <h5><a>Rau củ</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg" data-setbg="img/categories/cat-4.png">
                        <h5><a>Thịt tươi</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg" data-setbg="img/categories/cat-5.jpg">
                        <h5><a>Cá</a></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Categories Section End -->

<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>Nổi bật</h2>
                </div>
                <div class="featured__controls">
                    <ul>
                        <li class="active" data-filter="*">Tất cả</li>
                        <li data-filter=".oranges">Trái cây</li>
                        <li data-filter=".fresh-meat">Thịt tươi</li>
                        <li data-filter=".vegetables">Rau củ</li>
                        <li data-filter=".fastfood">Thức ăn nhanh</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row featured__filter">

            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/cam-sanh.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=23"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=23">Cam Sành Hữu Cơ - 1Kg</a></h6>
                        <h5>65.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/otchuong.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=24"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=24">Ớt chuông xanh 1kg</a></h6>
                        <h5>65.000đ</h5>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/cherry-uc.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=26"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=26">Cherry Úc - 0.5Kg</a></h6>
                        <h5>499.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/hanhtay.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=27"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=27">Hành tây Đà Lạt 500g</a></h6>
                        <h5>40.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/chuoi.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=28"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=28">Chuối tiêu - 1Kg</a></h6>
                        <h5>75.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/luu.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=29"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=29">Lựu đỏ - 0.5Kg</a></h6>
                        <h5>239.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/kiwi.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=30"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=30">Kiwi vàng - 0.5Kg</a></h6>
                        <h5>165.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/caibe.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=31"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=31">Cải bẹ xanh 400g</a></h6>
                        <h5>15.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/product-5.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=32"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=32">Hamburger</a></h6>
                        <h5>45.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/thitbo.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=1"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=1">Gầu bò Mỹ - 300g</a></h6>
                        <h5>149.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/hotdog.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=33"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=33">Hot dog</a></h6>
                        <h5>35.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/rauden.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=34"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=34">Rau dền 400g</a></h6>
                        <h5>15.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/botai.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=2"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=2">Bò tái Úc - 250g</a></h6>
                        <h5>109.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/heocp.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=3"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=3">Sườn non heo C.P khay 500g</a></h6>
                        <h5>209.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/caithia.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=35"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=35">Cải thìa 400g</a></h6>
                        <h5>20.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/cachep.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=4"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=4">Cá chép khay 800g</a></h6>
                        <h5>199.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/raumuong.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=36"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=36">Rau muống 400g</a></h6>
                        <h5>15.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/tom.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=5"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=5">Tôm thẻ khay 300g</a></h6>
                        <h5>89.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/ucga.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="addCart?id=6"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="detail?pid=6">Ức gà phi lê 300g</a></h6>
                        <h5>39.000đ</h5>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- Featured Section End -->


<!-- Latest Product Section Begin -->
<section class="latest-product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
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
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Được đánh giá cao</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/tom.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Tôm thẻ</h6>
                                    <span>89.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/raumuong.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Rau muống</h6>
                                    <span>15.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/product-5.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Hamburger</h6>
                                    <span>45.000đ</span>
                                </div>
                            </a>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/hanhtay.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Hành tây</h6>
                                    <span>40.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/otchuong.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Ớt chuông</h6>
                                    <span>65.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/rauden.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Rau dền</h6>
                                    <span>15.000đ</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Thường được xem</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/luu.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Lựu đỏ</h6>
                                    <span>239.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/kiwi.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Kiwi vàng</h6>
                                    <span>165.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/cam-sanh.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Cam sành</h6>
                                    <span>65.000đ</span>
                                </div>
                            </a>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/botai.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Bò Úc</h6>
                                    <span>109.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/product/heocp.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Sườn non heo</h6>
                                    <span>209.000đ</span>
                                </div>
                            </a>
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/latest-product/lp-3.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>Đùi gà rán</h6>
                                    <span>35.000đ</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Latest Product Section End -->


<!-- Footer Section Begin -->
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
<!-- Footer Section End -->

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