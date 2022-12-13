<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Please Sign In" />
<%@include file="header.jsp"%>

<div class="container-fluid m-5 p-5"></div>
    <div class="col-md-12 text-center">
        <h3 style="color: crimson; font-weight: bold;">${unregisteredAdd}</h3><br />
        <p><a href="logIn">Go to Log In/Register page</a></p>
    </div>
</div>

<%@include file="footer.jsp"%>