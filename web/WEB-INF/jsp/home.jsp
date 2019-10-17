<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="row small-5 small-centered">
    <h5>TOP 10</h5>
    <table>
        <thead>
        <tr>
            <th>Resultat</th>
            <th>ID Joueur</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="score" items="${ sessionScope.scores }" varStatus="status">
            <tr>
                <td>${score.resultat} / 10</td>
                <td>${score.userId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value="/scores?action=jeu" />" class="button">Nouvelle partie</a>
</div>

<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
<script>
    $(document).foundation();
    document.documentElement.setAttribute('data-useragent', navigator.userAgent);
</script>
</body>
</html>