<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Win</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
<%
    String userName = (String) session.getAttribute("userName");
    int countGames = (int) session.getAttribute("countGames");

%>
<div class="container" style="background-color: #b1acac">

    <div class="row">
        <h2 style="text-align: center"></h2>



        <div class="col-md-4 col-md-push-4">
            <div class="alert alert-danger" style="text-align: center">Ты выиграл, поздравляю!</div>
            <img class="img-responsive img-circle" src="../img/victory.jpg" alt="victory">
        </div>


    </div>
    <br>
    <br>
    <br>
    <div style="text-align: center">
        <form action="restart" method="post">
        <button type="submit" class="btn  btn-danger btn-lg" >Новая игра</button>
        </form>
    </div>
    <br>
    <br>


    <div class="d-inline-flex p-2 bd-highlight" style="background: #7c7b7b; margin-left: 3%">
        <div class="d-flex justify-content-around" >
            INFO:<br>
            Player's name: <%= userName%>  <br>

            Count games: <%= countGames%>  <br>
        </div>

    </div>
    <br>
    <br>

</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//static/jquery-3.6.0.min.js"/>"></script>


</body>
</html>