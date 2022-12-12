<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Key Results" />
<%@include file="header.jsp"%>
<%@include file="navMenu1.jsp"%>

f<div class="container mt-3 mb-1 .text-center my-auto">
    <form style="margin: 0px;" action="viewKeyResults" method="GET">
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <h3 style="margin-left: 150px;">You have picked the key of ${chosenKey}</h3>
                <p style="font-weight:bold; font-size: 1.33em;">Keys:
                    <button type="submit" name="key" value="Ab" class="btn btn-success">A&#9837;</button>
                    <button type="submit" name="key" value="A" class="btn btn-success">A</button>
                    <button type="submit" name="key" value="Bb" class="btn btn-success">B&#9837;</button>
                    <button type="submit" name="key" value="B" class="btn btn-success">B</button>
                    <button type="submit" name="key" value="Cb" class="btn btn-success">C&#9837;</button>
                    <button type="submit" name="key" value="C" class="btn btn-success">C</button>
                    <button type="submit" name="key" value="C#" class="btn btn-success">C&#9839;</button>
                    <button type="submit" name="key" value="Db" class="btn btn-success">D&#9837;</button>
                    <button type="submit" name="key" value="D" class="btn btn-success">D</button>
                    <button type="submit" name="key" value="Eb" class="btn btn-success">E&#9837;</button>
                    <button type="submit" name="key" value="E" class="btn btn-success">E</button>
                    <button type="submit" name="key" value="F" class="btn btn-success">F</button>
                    <button type="submit" name="key" value="F#" class="btn btn-success">F&#9839;</button>
                    <button type="submit" name="key" value="Gb" class="btn btn-success">G&#9837;</button>
                    <button type="submit" name="key" value="G" class="btn btn-success">G</button>
                </p>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </form>
</div>


<form style="margin-top: 0px;" action="addUserScalesChords" method="GET">
    <div class="container mt-2 .text-center">
        <div class="row">

            <!-- Scales -->
            <div class="col-sm-2">
                <div><h5>${chosenKey} Scales</h5></div>
                <c:forEach var="scale" items="${scales}">
                    <div style="font-size: 12px;">
                        <p style="font-weight: bold;  margin-bottom: 2px;">${scale.getScaleName()}</p>
                        <p>${scale.getScaleData()}</p>
                    </div>
                </c:forEach>
            </div>

            <!--Chords -->
            <div class="col-sm-6">
                <table>
                    <tr>
                        <td colspan="4" ><h5>${chosenKey} Triads</h5></td>
                    </tr>
                    <tr>
                        <c:forEach var="chord" items="${chords}">
                            <c:if test="${chord.getCategory().equals('Triads')}" >
                                <td>
                                    <div style="font-size: 12px;">
                                        <p style="font-weight: bold; margin-bottom: 2px;">${chord.getChordName()}</p>
                                        <p>${chord.getChordData()}</p>
                                        <br/>
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>

                    <tr>
                        <td colspan="3" style="margin-bottom: 2px;"><h5>${chosenKey} Common Chords</h5></td>
                    </tr>
                    <tr>
                        <c:forEach var="chord" items="${chords}">
                            <c:if test="${chord.getCategory().equals('Common')}" >
                                <td style="padding: 9px;">
                                    <div style="font-size: 12px;">
                                        <p style="font-weight: bold; margin-bottom: 2px;">${chord.getChordName()}</p>
                                        <p>${chord.getChordData()}</p>
                                        <br/>
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                    <tr>
                        <td colspan="7" style="margin-bottom: 2px;"><h5>Chords in the key of ${chosenKey} Major</h5></td>
                    </tr>
                    <tr>
                        <c:forEach var="chord" items="${chords}">
                            <c:if test="${chord.getCategory().equals('Major')}" >
                                <td style="padding: 9px;">
                                    <div style="font-size: 12px;">
                                        <p style="font-weight: bold; margin-bottom: 2px;">${chord.getChordName()}</p>
                                        <p>${chord.getChordData()}</p>
                                        <br/>
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                    <tr>
                        <td colspan="7" style="margin-bottom: 2px;"><h5>Chords in the key of ${chosenKey} Minor</h5></td>
                    </tr>
                    <tr>
                        <c:forEach var="chord" items="${chords}">
                            <c:if test="${chord.getCategory().equals('Minor')}" >
                                <td style="padding: 9px;">
                                    <div style="font-size: 12px;">
                                        <p style="font-weight: bold; margin-bottom: 2px;">${chord.getChordName()}</p>
                                        <p>${chord.getChordData()}</p>
                                        <br/>
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                    <tr>
                        <td colspan="7" style="margin-bottom: 2px;"><h5>7th Chords in the key of ${chosenKey} Major</h5></td>
                    </tr>
                    <tr>
                        <c:forEach var="chord" items="${chords}">
                            <c:if test="${chord.getCategory().equals('Seventh')}" >
                                <td style="padding: 9px;">
                                    <div style="font-size: 12px;">
                                        <p style="font-weight: bold; margin-bottom: 2px;">${chord.getChordName()}</p>
                                        <p>${chord.getChordData()}</p>
                                        <br/>
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </table>
            </div>

            <!-- Songs -->
            <div class="col-sm-4">
                <h5 class="underline">Songs in the key of ${chosenKey}</h5>
                <table style="margin-top: 0px; font-size: 12px;">
                    <tr>
                        <td style="padding: 9px;">
                            <p style="margin-bottom: 3px;">
                                <span style="font-weight: bold; ">
                                    Song:
                                </span>
                                <span>
                                    ${songs.get(0).getSongName()}
                                </span>
                            </p>
                            <p style="margin-top: 0px;">
                                <span style="font-weight: bold; ">
                                    Artist:
                                </span>
                                <span>
                                    ${songs.get(0).getSongArtist()}
                                </span>
                            </p>
                        </td>
                        <td><iframe style="border-radius:12px" src="https://open.spotify.com/embed/track/${songs.get(0).getSongSpotifyId()}?utm_source=generator" width="100%" height="352" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture" loading="lazy"></iframe></td>
                    </tr>
                    <tr>
                        <td style="padding: 9px;">
                            <p style="margin-bottom: 3px;">
                                <span style="font-weight: bold; ">
                                    Song:
                                </span>
                                <span>
                                    ${songs.get(1).getSongName()}
                                </span>
                            </p>
                            <p>
                                <span style="font-weight: bold; ">
                                    Artist:
                                </span>
                                <span>
                                    ${songs.get(1).getSongArtist()}
                                </span>
                            </p>
                        </td>
                        <td style="padding: 9px;">
                            <p style="margin-bottom: 3px;">
                                <span style="font-weight: bold; ">
                                    Song:
                                </span>
                                <span>
                                    ${songs.get(2).getSongName()}
                                </span>
                            </p>
                            <p>
                                <span style="font-weight: bold; ">
                                    Artist:
                                </span>
                                <span>
                                    ${songs.get(2).getSongArtist()}
                                </span>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding: 9px;">
                            <p style="margin-bottom: 3px;">
                                <span style="font-weight: bold; ">
                                    Song:
                                </span>
                                <span>
                                    ${songs.get(3).getSongName()}
                                </span>
                            </p>
                            <p>
                                <span style="font-weight: bold; ">
                                    Artist:
                                </span>
                                <span>
                                    ${songs.get(3).getSongArtist()}
                                </span>
                            </p>
                        </td>
                        <td></td>
                    </tr>
                </table>
                <h5 style="margin-top: 16px;">Is there a scale or chord you're not seeing that you would like to add?</h5>
                <p>
                    <a href="addUserScalesChords.jsp" class="button">Yes, I would like to add my own scales and chords</a>
                </p>
                <p style="font-size: 12px;">As a registered user, only you will see your added scales and chords</p>
            </div>
        </div>
    </div>
</form>

<%@include file="footer.jsp"%>

