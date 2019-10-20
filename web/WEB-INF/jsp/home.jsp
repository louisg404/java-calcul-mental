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

<div style="margin-top: 5%;" class="row">
    <div class="small-3 columns">
        <h1 style="font-weight: bold;">Accueil</h1>
        <a class="hollow success button" href="questions">Commencer la partie</a>
    </div>
    <div class="small-9 columns">
        <span class="label warning">Fonctionnalite 'meilleurs resultats' non-developpee.</span><br><br>
        <table>
            <thead>
            <tr>
                <th>Joueur</th>
                <th>Best</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Louis</td>
                <td>7</td>
            </tr>
            <tr>
                <td>Antoine</td>
                <td>4</td>
            </tr>
            <tr>
                <td>Louis</td>
                <td>7</td>
            </tr>
            <tr>
                <td>Antoine</td>
                <td>4</td>
            </tr>
            <tr>
                <td>Louis</td>
                <td>7</td>
            </tr>
            <tr>
                <td>Antoine</td>
                <td>4</td>
            </tr>
            <tr>
                <td>Louis</td>
                <td>7</td>
            </tr>
            <tr>
                <td>Antoine</td>
                <td>4</td>
            </tr>
            <tr>
                <td>Louis</td>
                <td>7</td>
            </tr>
            <tr>
                <td>Antoine</td>
                <td>4</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
<script>
    $(document).foundation();
    document.documentElement.setAttribute('data-useragent', navigator.userAgent);
</script>
</body>
</html>