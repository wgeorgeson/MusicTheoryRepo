<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<head lang="en">
    <!-- The following 3 meta tags *must* come first in the head -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title}</title>

    <!-- The application's custom CSS stylesheet -->
    <link rel="stylesheet" type="text/css" href="css/styles.css" />

    <!-- Latest compiled and minified Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
<!-- Banner -->
<div class="container-fluid p-2 bg-warning text-black text-center border border-dark">
    <div class="row">
        <div class="col">
            <a href="index.jsp"><img src="images/musicImg1.jpeg" alt="Music Image" width="225" height="100"></a>
        </div>
        <div class="col">
            <h1>Music Theory Repository</h1>
            <p style="font-weight: bold; font-style: italic;">Your basic music theory resource</p>
        </div>
        <div class="col"><a href="index.jsp">
            <a href="index.jsp"><img src="images/musicImg1.jpeg" alt="Music Image" width="225" height="100"></a>
        </div>
    </div>
</div>
<!-- Choose which nav menu to display based on if a username exists (if it exists it means user is signed in) -->
<c:choose>
    <c:when test="${empty userName}">
    <nav class="navbar navbar-expand-xl navbar-dark bg-dark fw-bold justify-content-center">
        <div class="container-fluid">
            <a href="index.jsp" class="navbar-brand">MTR</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="addUserScalesChords.jsp" class="nav-link">Add User Scales/Chords</a>
                    </li>
                    <li class="nav-item">
                        <a href="viewUserScalesChords" class="nav-link">View User Scales/Chords</a>
                    </li>
                    <li class="nav-item">
                        <a href="logIn" class="nav-link">Log In or Sign Up</a> <!-- LogIn Servlet for aws cognito -->
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    </c:when>
    <c:otherwise>
    <nav class="navbar navbar-expand-xl navbar-dark bg-dark fw-bold">
        <div class="container-fluid">
            <a href="index.jsp" class="navbar-brand">MTR</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="addUserScalesChords.jsp" class="nav-link">Add User Scales/Chords</a>
                    </li>
                    <li class="nav-item">
                        <a href="viewUserScalesChords" class="nav-link">View User Scales/Chords</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Welcome, ${userName}!</a>
                        <div class="dropdown-menu">
                            <!--
                            <a href="changeUserInfo.jsp" class="dropdown-item">Change Personal Info</a>
                            <div class="dropdown-divider"></div>
                            <a href="changePassword.jsp" class="dropdown-item">Change Password</a>
                            -->
                            <div class="dropdown-divider"></div>
                            <a href="logOut" class="dropdown-item">LogOut</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    </c:otherwise>
</c:choose>
