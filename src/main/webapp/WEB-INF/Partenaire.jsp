<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body{background-color: #f1f1f1;}
        .bslf{
            width: 350px;
            margin: 120px auto;
            padding: 25px 20px;
            background: #3a1975;
            box-shadow: 2px 2px 4px #ab8de0;
            border-radius: 5px;
            color: #fff;
        }
        .bslf h2{
            margin-top: 0px;
            margin-bottom: 15px;
            padding-bottom: 5px;
            border-radius: 10px;
            border: 1px solid #25055f;
        }
        .bslf a{color: #783ce2;}
        .bslf a:hover{
            text-decoration: none;
            color: #03A9F4;
        }
        .bslf .checkbox-inline{padding-top: 7px;}
    </style>
</head>
<body>
<div class="bslf">
    <form action="" method="post">
        <h2 class="text-center">Ajout Partenaire</h2>
        <div class="form-group">
            <input type="text" name="ninea" class="form-control" placeholder="ninea">
        </div>

        <div class="form-group">
            <input type="text" name="prenom" class="form-control" placeholder="Prenom" required="required">
        </div>
        <div class="form-group">
            <input type="text" name="nom" class="form-control" placeholder="Nom" required="required">
        </div>
        <div class="form-group">
            <input type="text" name="email" class="form-control" placeholder="email" required="required">
        </div>
        <div class="form-group">
            <input type="text" name="telephone" class="form-control" placeholder="telephone" required="required">
        </div>
        <div class="form-group">
            <input type="text" name="adresse" class="form-control" placeholder="adresse" required="required">
        </div>
        <div class="form-group">
            <input type="text" name="raisonsociale" class="form-control" placeholder="raisonsociale" required="required">
        </div>
        <div class="form-group">
            <input type="text" name="statut" class="form-control" placeholder="statut" required="required">
        </div>
        <div class="form-group clearfix">
            <button type="submit" class="btn btn-success pull-right">Ajouter</button>
        </div>
    </form>
    ${requestScope.error}
</div>
<div>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Ninea</th>
            <th scope="col">Prenom</th>
            <th scope="col">Nom</th>
            <th scope="col">Email</th>
            <th scope="col">Telephone</th>
            <th scope="col">Adresse</th>
            <th scope="col">RaisonSociale</th>
            <th scope="col">Statut</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${partners}" var="e">
            <tr>
                <td>${e.ninea}</td>
                <td>${e.prenom}</td>
                <td>${e.nom}</td>
                <td>${e.email}</td>
                <td>${e.telephone}</td>
                <td>${e.adresse}</td>
                <td>${e.raisonsociale}</td>
                <td>${e.statut}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>