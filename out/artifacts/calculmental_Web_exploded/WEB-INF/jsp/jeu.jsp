<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Jeu</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="row small-5 small-centered">
    <div class="progress" role="progressbar" tabindex="0" aria-valuenow="50" aria-valuemin="1" aria-valuetext="50 percent" aria-valuemax="10">
        <div class="progress-meter" style="width: ${quest}0%">
            <p class="progress-meter-text">${quest}0%</p>
        </div>
    </div>

    <h1 style="font-weight: bold;">${expression.expression}</h1>
    <form method="POST" action="questions">
        <%-- L'attribut step=any nous permet d'accepter les entrées double, int... --%>
        <div class="small-4 columns">
            <input step="any" name="reponse" type="number" required>
        </div>

        <button class="hollow success button" href="questions" type="submit" name="action">Valider</button>
    </form>
</div>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
<script>
    $(document).foundation();
    document.documentElement.setAttribute('data-useragent', navigator.userAgent);
</script>
</body>
</html>