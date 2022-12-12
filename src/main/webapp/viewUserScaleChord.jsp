<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="View User Scales/Chords" />
<%@include file="header.jsp"%>
<%@include file="navMenu2.jsp"%>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <h2>${username}'s Scales and Chords</h2>
            <form action="removeUserScalesChords" method="post"></form>
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-4 text-center">
                        <fieldset>
                            <legend>Scales</legend>
                                <table>
                                    <c:choose>
                                        <c:when test="${userScales.isEmpty()}">
                                            <tr>
                                                <td style="font-weight: bold; color: #820e0e;">
                                                    There are no scales to display for this user.
                                                </td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tbody>
                                                <c:forEach var="userScale" items="${userScales}">
                                                    <tr>
                                                        <td>
                                                            <p style="font-weight: bold; margin-bottom: 3px;">${userScale.scaleName}</p>
                                                            <p style="font-weight: bold; margin-top: 0px;">${userScale.scaleData}</p>
                                                        </td>
                                                        <td>
                                                            <button type="button" name="deleteBtn" value="scale_${userScale.scaleName}"
                                                                    class="btn btn-danger ml-1 fw-bold border border-dark" >
                                                                Delete
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </c:otherwise>
                                    </c:choose>
                                </table>
                            </fieldset>
                        </div>
                        <div class="col-md-4 text-center">
                            <fieldset>
                                <legend>Chords</legend>
                                    <table>
                                        <c:choose>
                                            <c:when test="${userChords.isEmpty()}">
                                                <tr>
                                                    <td style="font-weight: bold; color: #820e0e;">
                                                        There are no chords to display for this user.
                                                    </td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tbody>
                                                <c:forEach var="userChord" items="${userChords}">
                                                    <tr>
                                                        <td>
                                                            <p style="font-weight: bold; margin-bottom: 3px;">${userChord.chordName}</p>
                                                            <p style="font-weight: bold; margin-top: 0px;">${userChord.chordData}</p>
                                                        </td>
                                                        <td>
                                                            <button type="button" name="deleteBtn" value="scale_${userChord.chordName}"
                                                                    class="btn btn-danger ml-1 fw-bold border border-dark" >
                                                                Delete
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </c:otherwise>
                                        </c:choose>
                                    </table>
                            </fieldset>
                        /div>
                    <div class="col-md-2"></div>
                </div>
            </div>
        <div class="col-md-2"></div>
    </div>
</div>

<div class="row">
    <div class="col-md-12 text-danger fw-bold text-center">
        <h3>${userConfirmDeletion}</h3>
        <c:set var="userConfirmDeletion" value="" scope="request" />
    </div>
</div>

<%@include file="footer.jsp"%>
