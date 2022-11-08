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

<!-- Product Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6">
                <div class="product__details__pic">
                    <div class="product__details__pic__item">
                        <img class="product__details__pic__item--large"
                             src=${detail.img} alt="">
                    </div>

                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="product__details__text">
                    <h3>${detail.name}</h3>
                    <div class="product__details__rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                        <span>(18 reviews)</span>
                    </div>
                    <div class="product__details__price">${detail.price}</div>
                    <p>GIỐNG VÀ CHỦNG LOẠI CỦA LỰU:<br> Lựu  là loại trái cây nhập khẩu có vỏ màu vàng, trái tương đối lớn (khoảng 2 trái / kg), hạt đỏ thẫm, nhiều nước, đặc biệt ăn rất ngọt và nhiều nước. <br>Xuất xứ: Thái Lan</p>
                    <div class="product__details__quantity">
                        <div class="quantity">
                            <div class="pro-qty">
                                <input type="text" value="1">
                            </div>
                        </div>
                    </div>
                    <a href="addCart?id=${detail.id}" class="primary-btn">THÊM VÀO GIỎ</a>

                    <ul>
                        <li><b>Tình trạng</b> <span>Còn hàng</span></li>
                        <li><b>Giao hàng</b> <span>Trong ngày. <samp> Miễn phí </samp></span></li>

                        <li><b>Chia sẻ</b>
                            <div class="share">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="product__details__tab">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                               aria-selected="true">Mô tả</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                               aria-selected="false">Thông tin giao hàng</a>
                        </li>

                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <div class="product__details__tab__desc">

                                <p>1. GIỐNG VÀ CHỦNG LOẠI CỦA LỰU Lựu  là loại trái cây nhập khẩu có vỏ màu vàng, trái tương đối lớn (khoảng 2 trái / kg), hạt đỏ thẫm, nhiều nước, đặc biệt ăn rất ngọt và nhiều nước. Xuất xứ: Thái Lan <br><br>2. DINH DƯỠNG & LỢI ÍCH SỨC KHỎE Nước quả lựu giàu chất chống ôxy hoá polyphenol, giúp bảo vệ cơ thể khỏi các gốc tự do gây lão hóa, các bệnh tim mạch, bệnh Azheimer và cả ung thư. Nước quả lựu chứa nhiều thành phần Natri, vitamin B2, sinh tố B, niaxin, vitamin C, canxi và photpho, làm giảm quá trình hình thành các mảng bám trong các động mạch. Dầu hạt quả lựu có khả năng ngăn ngừa sự hình thành tế bào ung thư da nhờ khả năng “mau liền” với các thương tổn da. Ngoài ra nước quả lựu còn có vai trò giúp phụ nữ đối phó với các triệu chứng của thời mãn kinh. Lợi ích của uống nước lựu đang được khẳng định trong việc điều trị các bệnh về tim, lão hóa sớm và ung thư. Nước lựu giúp duy trì sức khỏe tim mạch và ngăn ngừa các bệnh tim mạch. <br><br> 3. LƯU Ý BẢO QUẢN LỰU Bảo quản lựu khá đơn giản (không như cherry hay việt quất rất kị hơi tay người) Lựu chỉ cần bảo quản ở nhiệt độ 4*C là có thể để được khoảng 10 ngày. Vận chuyển lựu nhẹ tay, tránh bị dập dẫn đến hỏng những hạt ngay dưới lớp vỏ.</p>
                            </div>
                        </div>
                        <div class="tab-pane" id="tabs-2" role="tabpanel">
                            <div class="product__details__tab__desc">
                                <p>
                                    Đơn hàng từ 199.000 đến dưới 499.000 VNĐ <br>  - Bán kính 1-5 km: Miễn phí; <br> - Bán kính 5-10km: 20.000 VNĐ; <br> - Bán kính dưới 13km: 30.000 VNĐ.
                                </p>
                                <p> Đơn hàng trên 499.000 VNĐ <br> - Bán kính dưới 13km: Miễn phí <br>- Trên 13km, Organicfood.vn sẽ giao đến chành xe hoặc đơn vị vận chuyển được chỉ định bởi khách hàng. Khách hàng thanh toán trước giá trị đơn hàng và chi phí vận chuyển cho Organicfood.Vn</p>
                                <p>Chính sách giao hàng đặc biệt  <br>Đơn hàng từ 1.500.000 VNĐ trở lên: Giao hàng miễn phí trong bán kính 13km. <br> + Giao hàng riêng không ghép đơn hàng khác; <br>+ Thời gian giao hàng nhanh nhất; <br>+ Ưu tiên giao hàng so với các đơn hàng khác.</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="related-product">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/cam-sanh.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="#">Cam Sành Hữu Cơ - 1Kg</a></h6>
                        <h5>65.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/cherry-uc.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="#">Cherry Úc - 0.5Kg</a></h6>
                        <h5>499.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/chuoi.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="#">Chuối tiêu - 1Kg</a></h6>
                        <h5>75.000đ</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                <div class="featured__item">
                    <div class="featured__item__pic set-bg" data-setbg="img/product/kiwi.jpg">
                        <ul class="featured__item__pic__hover">

                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="#">Kiwi vàng - 0.5Kg</a></h6>
                        <h5>165.000đ</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Related Product Section End -->

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
