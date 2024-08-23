<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form modelAttribute="Staff" method="post">
    <div class="mb-3">
        <p>Mã Nhân Viên:<form:input path="staffCode" class="form-control"/>
                <form:errors path="staffCode" cssStyle="color: red"/>
        <p style="color: red">${errorMa}</p>
    </div>
    <div class="mb-3">
        <p>Tên Nhân Viên:<form:input path="name" class="form-control"/>
        <div class="invalid-feedback">
            <form:errors path="name" cssStyle="color: red"/>
        </div>
    </div>

    <div class="mb-3">
        <p>Email FPT:<form:input path="emailFpt" class="form-control"/>
                <form:errors path="emailFpt" cssStyle="color: red"/>
        <p style="color: red">${errorMailFPT}</p>
    </div>

    <div class="mb-3">
        <p>Email F:<form:input path="emailFe" class="form-control"/>
                <form:errors path="emailFe" cssStyle="color: red"/>
        <p style="color: red">${errorMailFE}</p>
    </div>
    </div>
    <p>Trạng thái:<form:checkbox path="status" class="form-check-input"/></p>
    <button class="btn btn-outline-primary" formaction="">Lưu</button>
</form:form>
</body>
</html>