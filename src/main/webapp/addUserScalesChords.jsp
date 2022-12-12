<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Add Scales and Chords" />
<%@include file="header.jsp"%>
<%@include file="navMenu2.jsp"%>

<div class="container mt-5">
    <div class="row">
        <div class="col-sm-3"></div>

        <div class="col-sm-6">
            <form action="addUserScalesChords" method="post" class="needs-validation" novalidate>
                <div class="row">
                    <h2>Add Your Own Scale or Chord</h2>
                </div>
                <div class="row mt-5 mb-3">
                    <div class="col">
                        <div class="form-check fw-bold">
                            <input type="radio" class="form-check-input" id="addScale" name="addType" value="scale" size="25" maxlength="25" checked>Scale
                            <label class="form-check-label" for="addScale"></label>
                        </div>
                    </div>
                    <div class="col ml-1 mr-1">
                        <h4>OR</h4>
                    </div>
                    <div class="col">
                        <div class="form-check fw-bold">
                            <input type="radio" class="form-check-input" id="addChord" name="addType" value="chord" size="15" maxlength="15">Chord
                            <label class="form-check-label" for="addChord"></label>
                        </div>
                    </div>
                </div>
                <div class="row mt-5 form-group">
                    <div class="col">
                        <div class="mb-3 mr-1 fw-bold">
                            <label for="name" class="form-label">Scale/Chord Name</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-5">
                                <input type="text" class="form-control" id="name" name="addName" pattern="[A-Ga-g]{1}[\sA-Za-z\d♭♯b#+]*" required>
                                <div class="invalid-feedback">Please add a valid scale or chord name.</div>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col">
                        <div class="mb-3 mr-1 fw-bold">
                            <label for="notes" class="form-label">Scale/Chord Notes</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-5">
                            <input type="text" class="form-control" id="notes" name="addNotes" pattern="[A-Ga-g]{1}[\sA-Za-z♭♯b#,-]*" required>
                            <div class="invalid-feedback">Please include valid notes for your scale/chord.</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <button type="submit" name="searchType" value="View All Users" class="btn btn-success p-4 fw-bold">Submit</button>
                    </div>
                    <div class="col text-danger fw-bold">
                        <h3>${userConfirmAddition}</h3>
                        <c:set var="userConfirmAddition" value="" scope="session" />
                    </div>
                </div>
            </form>
        </div>

        <div class="col-sm-3"></div>
    </div>
</div>

<%@include file="footer.jsp"%>

