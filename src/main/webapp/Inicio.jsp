<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/css/tether.min.css'>
        <link rel="stylesheet" href="Styles/StylesNav.css">
        <link rel="stylesheet" href="Styles/StylesLogin.css">
         <title>LAVAQUITA</title>
    </head>
    <body>
     <div id="wrapper">
        <jsp:include page="/WEB-INF/Paginas/Comunes/Cabecera.jsp"/>
        <div class="index container">
            <div class="container-fluid bg-1 text-center">
                <div class="text-center">
                    <img  width="300" src="Assets/vaquita.png" class="img-responsive" alt="Logo"/>
                    <div class="h-30"></div>
                </div>
                <p>C.Ramon Corona 203, Centro, 47400 Lagos de Moreno, Jal.</p>
            </div>
        </div>
      </div>
            <script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'></script>
            <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js'></script>
            <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js'></script>
            <script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/js/tether.min.js'></script>
            <script src="Js/Nav.js"></script>
    </body>
</html>
