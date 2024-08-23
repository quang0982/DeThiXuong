<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, userEmployee-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    '
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</head>
<body>
<a class="btn btn-outline-primary" href="/addStaft"style="float:letf">Thêm</a>
<a type="button" class="btn btn-outline-success" href="/excel" style="float:right">Export Temlplate</a>
<table class="table caption-top">
    <caption>List of staff</caption>
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã Nhân Viên</th>
        <th>Tên Nhân Viên</th>
        <th>Email FPT</th>
        <th>Email FE</th>
        <th>Trạng Thái</th>
        <th colspan="2"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${page}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${p.staffCode}</td>
            <td>${p.name}</td>
            <td>${p.emailFpt}</td>
            <td>${p.emailFe}</td>
            <td>${p.status?"Đang hoạt động":"Ngừng hoạt động"}</td>
            </td>
            <td><a class="btn btn-outline-warning" href="/updateStaff/${p.id}">Sửa</a></td>
            <td><a class="btn btn-outline-success" href="/detailStaff/${p.id}">Chuyên ngành</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>

</html>

