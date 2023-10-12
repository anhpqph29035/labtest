<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Title</title>
</head>
<body>
<div class="container">
    <%--@elvariable id="s" type=""--%>
    <form:form action="/phong/add" modelAttribute="s">
        <div class="form-group">
            <h3>Mã</h3>
            <form:input path="ma" type="text" class="form-control" value="${s.ma}"/>
            <p style="color: red">${LoiMa}</p>
        </div>
        <div class="form-group">
            <h3>Tên</h3>
            <form:input path="ten" type="text" class="form-control" value="${s.ten}"/>
            <p style="color: red">${LoiTen}</p>
        </div>
        <div class="form-group">
            <h3>Loại</h3>
            <form:select path="loaiPhong.id" class="form-control">
                <c:forEach var="l" items="${LISTLOAI}">
                    <form:option value="${l.id}">${l.ten}</form:option>
                </c:forEach>
            </form:select>

        </div>
        <div class="form-group">
            <h3>Số lượng</h3>
            <form:input path="soLuong" type="number" class="form-control" value="${s.soLuong}"/>

        </div>
        <div class="form-group">
            <h3>Ghi chú</h3>
            <form:input path="ghiChu" type="text" class="form-control" value="${s.ghiChu}"/>

        </div>
        <button class="btn btn-primary">Thêm</button>
    </form:form>
</div>
<div class="container">
    <table class="table table-stripped">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Loại phòng</th>
        <th>Số lượng</th>
        <th>Ghi chú</th>
        <th>Action</th>
        </thead>
        <c:forEach var="o" items="${LIST.content}">
            <tr>
                <td>${o.id}</td>
                <td>${o.ma}</td>
                <td>${o.ten}</td>
                <td>${o.loaiPhong.ten}</td>
                <td>${o.soLuong}</td>
                <td>${o.ghiChu}</td>
                <td>
                    <a href="/phong/detail/${o.id}" class="btn btn-success">Detail</a>
                    <a href="/phong/delete/${o.id}" onclick="return confirm('Bạn có muốn xóa không?')" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${LIST.totalPages -1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/phong/hien-thi?page=${loop.index}">
                            ${loop.index +1 }
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</div>
<c:if test="${not empty ThongBao}">
    <script>
        alert("${ThongBao}")
    </script>
</c:if>
</body>
</html>