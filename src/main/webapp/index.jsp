<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home - Music Theory Repository" />
<%@include file="header.jsp"%>

<!-- Page content -->
<form action="viewKeyResults" method="GET">
    <div class="container mt-5 .text-center">
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <p style="margin-left: 3.75em; font-size: 54px; font-weight: bold;">Pick A Key</p>
                <h5>Choose a key to see popular scales, common chords, and a list of songs in your chosen key.</h5>
                <br />
                <div style="margin-left: 17em; padding: 1.1em;">
                    <button type="submit" name="key" value="C" class="btn btn-success btn-lg p-4 fw-bold fs-3 .text-center keyButtons">C</button>
                </div>
                <div style="margin-left: 1em; padding: 1.1em;">
                    <button type="submit" name="key" value="G" class="btn btn-success btn-lg  p-4 fw-bold fs-3 keyButtons">G</button>
                    <button type="submit" name="key" value="D" class="btn btn-success btn-lg  p-4 fw-bold fs-3 keyButtons">D</button>
                    <button type="submit" name="key" value="A" class="btn btn-success btn-lg  p-4 fw-bold fs-3 keyButtons">A</button>
                    <button type="submit" name="key" value="E" class="btn btn-success btn-lg  p-4 fw-bold fs-3 keyButtons">E</button>
                    <button type="submit" name="key" value="B" class="btn btn-success btn-lg  p-4 fw-bold fs-3 keyButtons">B</button>
                    <button type="submit" name="key" value="C#" class="btn btn-success btn-lg  p-4 fw-bold fs-3 keyButtons">C&#9839;</button>
                    <button type="submit" name="key" value="F#" class="btn btn-success btn-lg  p-4 fw-bold fs-3 keyButtons">F&#9839;</button>
                </div>
                <div style="padding: 1.1em;">
                    <button type="submit" name="key" value="Bb" class="btn btn-success btn-lg p-4  fw-bold fs-3 keyButtons">B&#9837;</button>
                    <button type="submit" name="key" value="Eb" class="btn btn-success btn-lg p-4  fw-bold fs-3 keyButtons">E&#9837;</button>
                    <button type="submit" name="key" value="Ab" class="btn btn-success btn-lg p-4  fw-bold fs-3 keyButtons">A&#9837;</button>
                    <button type="submit" name="key" value="Db" class="btn btn-success btn-lg p-4  fw-bold fs-3 keyButtons">D&#9837;</button>
                    <button type="submit" name="key" value="Gb" class="btn btn-success btn-lg p-4  fw-bold fs-3 keyButtons">G&#9837;</button>
                    <button type="submit" name="key" value="Cb" class="btn btn-success btn-lg p-4  fw-bold fs-3 keyButtons">C&#9837;</button>
                    <button type="submit" name="key" value="F" class="btn btn-success btn-lg p-4  fw-bold fs-3 keyButtons">F</button>
                </div>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </div>
</form>

<%@include file="footer.jsp"%>

