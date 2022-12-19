<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>OganiNLU</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    <style>
        img{
            width: 200px;
            height: 120px;
        }
    </style>
</head>
    <body>

    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <h2 style="margin-left: 16px;">Chỉnh sửa thông tin sản phẩm</h2>
            </div>

        </div>
        <form action="edit" method="post">
            <div class="modal-body">
                <div class="form-group">
                    <label>Id</label>
                    <input value="${detail.id}" name="id" type="text" class="form-control" readonly required>
                </div>
                <div class="form-group">
                    <label>Tên</label>
                    <input value="${detail.name}" name="name" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Ảnh</label>
                    <input value="${detail.img}" name="image" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Giá</label>
                    <input value="${detail.price}" name="price" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Nhãn</label>
                    <textarea name="title" class="form-control" required>${detail.priceLong}</textarea>
                </div>
                <div class="form-group">
                    <label>Mô tả</label>
                    <textarea name="description" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label>Loại</label>
                    <select name="category" class="form-select" aria-label="Default select example">
                        <c:forEach items="${listC}" var="o">
                            <option value="${o.cid}">${o.cname}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <div class="modal-footer">

                <input type="submit" class="btn btn-success" value="Lưu thay đổi">
            </div>
        </form>
    </div>
</body>
</html>