<%@ page import="com.javarush.panova.quest.entities.Question" %>
<%@ page import="com.javarush.panova.quest.entities.NegativeAnswer" %>
<%@ page import="com.javarush.panova.quest.entities.Game" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Game</title>
    <link href="../css/game.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>

<body style="background-image: url(../img/kosmos.jpg); background-size: cover">
        <div class="container" >
            <%

                Question question = (Question) session.getAttribute("currentQuestion");
                int countGames = (Integer) session.getAttribute("countGames");
                String userName = (String) session.getAttribute("userName");

            %>
            <br><br><br>
            <h2 style="text-align: center" class="card-title">
                <%= question.getQuestionText()%>
            </h2>
            <br><br><br>

             <div class="row">
                    <div class="col-md-auto" style="padding-left: 20%" >
                        <form action="game-servlet" method="post">
                            <button name="positiveAnswer" type="submit" class="btn btn-dark " value="yes">
                                <%= question.getAnswers().get(0).getAnswerText()%>
                            </button>
                        </form>
                    </div>
                    <div class="col-md-auto offset-md-4">
                        <form action="loss-servlet" method="post">
                            <%
                                NegativeAnswer negativeAnswer = (NegativeAnswer) question.getAnswers().get(1);
                             %>
                            <button name="negativeAnswer" type="submit" class="btn btn-warning " value="no">
                                 <%= negativeAnswer.getAnswerText()%>
                            </button>
                        </form>
                    </div>
             </div>
            <br><br><br><br><br><br><br><br><br>

        </div>


    <div class="d-inline-flex p-2 bd-highlight" style="background: #7c7b7b; margin-left: 3%">
        <div class="d-flex justify-content-around" >
            INFO:<br>
            Player's name: <%= userName%>  <br>
            Count games: <%= countGames%>  <br>
        </div>
    </div>



</body>
</html>
