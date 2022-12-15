<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="View User Scales/Chords" />
<%@include file="header.jsp"%>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8 text-center">
            <h1>${userName}'s Scales and Chords</h1><br />
            <form action="removeUserScalesChords" method="post">
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-4 text-center mr-5">
                        <table>
                            <c:choose>
                                <c:when test="${userScales.isEmpty()}">
                                    <tr>
                                        <td style="font-weight: bold; color: #820e0e;">
                                            Sorry, we have no scales on record.
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tbody>
                                        <tr>
                                            <td><h3 style="margin: 10px; font-weight: bold;">Scales</h3></td>
                                        </tr>
                                        <c:forEach var="userScale" items="${userScales}">
                                            <tr>
                                                <td style="text-align: left; padding: 20px;">
                                                    <p style="font-weight: bold; margin-bottom: 3px;">${userScale.scaleName}</p>
                                                    <p style="margin-top: 0px;">${userScale.scaleData}</p>
                                                </td>
                                                <td>
                                                    <button type="submit" onclick="return confirm('Are you sure you want to delete this item?')"
                                                            name="deleteBtn" value="scale_${userScale.scaleName}"
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
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-4 text-center ml-5">
                        <table>
                            <c:choose>
                                <c:when test="${userChords.isEmpty()}">
                                    <tr>
                                        <td style="font-weight: bold; color: #820e0e;">
                                            Sorry, we have no chords on record.
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tbody>
                                    <tr>
                                        <td><h3 style="margin: 10px; font-weight: bold;">Chords</h3></td>
                                    </tr>
                                        <c:forEach var="userChord" items="${userChords}">
                                            <tr>
                                                <td style="text-align: left; padding: 20px;">
                                                    <p style="font-weight: bold; margin-bottom: 3px;">${userChord.chordName}</p>
                                                    <p style="margin-top: 0px;">${userChord.chordData}</p>
                                                </td>
                                                <td>
                                                    <button type="submit" onclick="return confirm('Are you sure you want to delete this item?')"
                                                            name="deleteBtn" value="chord_${userChord.chordName}"
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
                    <div class="col-md-1"></div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-success fw-bold text-center">
                        <h4>${userConfirmDeletion}</h4>
                        <c:set var="userConfirmDeletion" value="" scope="session" />
                    </div>
                </div>
            </form>
        <div class="col-md-2"></div>
    </div>
</div>



<%@include file="footer.jsp"%>
