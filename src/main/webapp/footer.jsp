<!-- Footer start -->
<%@ page import="com.mtr.persistence.JokeDao" %>
<%@ page import="com.jokeAPI.Joke" %>
<%
    JokeDao jokeDao = new JokeDao();
    Joke joke = jokeDao.getJoke();
%>
<div class="row p-2 bg-warning fixed-bottom text-black text-center border border-dark">
    <div class="col-md-3"></div>
    <div class="col-md-3">
        <h5>Music Theory Repository</h5>
        <p>&#169; 2022</p>
    </div>
    <div class="col-md-3">
        <h6><%= joke.getSetup() %></h6>
        <h6 style="font-style: italic;"><%= joke.getDelivery() %></h6>
    </div>
    <div class="col-md-3"></div>
</div>
<!-- Bootstrap 5 form validation -->
<script type="text/javascript" src="js/mtr.js"></script>

<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

<!-- Footer end -->