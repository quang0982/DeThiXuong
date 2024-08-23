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
<form modelAttribute="Staff">
    <p>Mã Nhân Viên: ${Staff.get().staffCode}</p>
    <p>Tên Nhân Viên: ${Staff.get().name}</p>
    <p>Email FPT: ${Staff.get().emailFpt}</p>
    <p>Email FE: ${Staff.get().emailFe}</p>
</form>
<hr>
<button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
        data-bs-target="#exampleModal" data-bs-whatever="" style="float:right">Thêm chuyên ngành
</button>


<form action="" method="post" action="/saveMojor">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Lưu</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form:form modelAtribute="StaffIDReponse">
                        <p>Cơ sở:
                            <select name="facilityId" class="form-select form-select-sm">
                                <c:forEach items="${Facility}" var="f">
                                    <option value="${f.id}">${f.name}</option>
                                </c:forEach>
                                itemValue="id"/>
                            </select>
                        </p>
                        <p>Bộ môn:
                            <select name="departmentId" class="form-select form-select-sm">
                                <c:forEach items="${Department}" var="f">
                                    <option value="${f.id}">${f.name}</option>
                                </c:forEach>
                                itemValue="id"/>
                            </select>
                        </p>
                        <p>Chuyên Ngành:
                            <select name="majorId" class="form-select form-select-sm">
                                <c:forEach items="${Major}" var="f">
                                    <option value="${f.id}">${f.name}</option>
                                </c:forEach>
                            </select>
                        </p>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" formaction="/saveStaffMojor/${Staff.get().id}">Lưu
                    </button>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</form>
<table class="table caption-top">
    <caption>Danh sách bộ môn,chuyên ngành theo cơ sở</caption>
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Cơ sở</th>
        <th scope="col">Bộ môn</th>
        <th scope="col">Chuyên ngành</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="staffResponse" items="${staffResponse}" varStatus="l">
        <tr>
            <td>${l.count}</td>
            <td>${staffResponse.getmajorName()}</td>
            <td>${staffResponse.getfacilityName()}</td>
            <td>${staffResponse.getdepartmentName()}</td>
            <td><a class="btn btn-outline-danger" href="/delete/${staffResponse.getstaffmajorFacilityId()}">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>${TB}</p>

</body>