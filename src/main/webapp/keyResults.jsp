<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Key Results" />
<%@include file="header.jsp"%>
<%@include file="navMenu1.jsp"%>

<!-- Page content -->
<form action="viewKeyResults" method="GET">
    <div class="container mt-5 .text-center">
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <h3 style="padding-left: 24px;">You have picked the key of ${chosenKey}</h3>
                <p style="font-weight:bold; font-size: 1.33em;">Keys:
                    <button type="submit" name="key" value="Ab" class="btn btn-success">A&#9837;</button>
                    <button type="submit" name="key" value="A" class="btn btn-success">A</button>
                    <button type="submit" name="key" value="Bb" class="btn btn-success">B&#9837;</button>
                    <button type="submit" name="key" value="B" class="btn btn-success">B</button>
                    <button type="submit" name="key" value="Cb" class="btn btn-success">C&#9837;</button>
                    <button type="submit" name="key" value="C" class="btn btn-success">C</button>
                    <button type="submit" name="key" value="C#" class="btn btn-success">C#</button>
                    <button type="submit" name="key" value="Db" class="btn btn-success">D&#9837;</button>
                    <button type="submit" name="key" value="D" class="btn btn-success">D</button>
                    <button type="submit" name="key" value="Eb" class="btn btn-success">E&#9837;</button>
                    <button type="submit" name="key" value="E" class="btn btn-success">E</button>
                    <button type="submit" name="key" value="F" class="btn btn-success">F</button>
                    <button type="submit" name="key" value="F#" class="btn btn-success">F#</button>
                    <button type="submit" name="key" value="Gb" class="btn btn-success">G&#9837;</button>
                    <button type="submit" name="key" value="G" class="btn btn-success">G</button>
                </p>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </div>
</form>

<form action="addUserScalesChords" method="GET">
    <div class="container mt-5 .text-center">
        <div class="row">
            <div class="col-sm-4">
                <c:forEach var="scale" items="${results.entrySet()}">

                        ${result.getKey()}
                        ${result.getValue()*100)/100}

                </c:forEach>
            </div>
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h5 class="underline">Songs in the key of ${chosenKey}</h5>
                <h5>Is there a scale or chord you're not seeing that you would like to add?</h5>
                <p>
                    <button type="submit" class="btn btn-info">Yes, I would like to add my own scales and chords</button>
                </p>
                <p style="font-size: 12px;">As a registered user, only you will see your added scales and chords</p>
            </div>
        </div>
    </div>
</form>

<%@include file="footer.jsp"%>

