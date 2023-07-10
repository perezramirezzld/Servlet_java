<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>LAVAQUITA</title>

        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/css/tether.min.css'>
        <link rel="stylesheet" href="Styles/StylesLogin.css">
    </head>

    <body>
        <div class="vaq">
            <img width="450" src="Assets/Vaq.png" class="img-responsive" alt="Logo"/>
        </div>
        <div class="login-box">
            <form action="${pageContext.request.contextPath}/Servletlogin" method="POST">
                <h2>La Vaquita</h2>
                
                <div class="user-box">
                    <input type="text" name="usuario" required="">
                    <label>Usuario</label>
                </div>
                 <h4>${Error}</h4>
                <div class="user-box">
                    <input type="password" name="contraseña" required="">
                    <label>Contraseña</label>
                </div>
                 <h4>${Error1}</h4>
                <div class="col-md-12 text-center ">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <button type="submit" class="btn bg-transparent"> 
                    
                     Iniciar sesión</button>
                </a>
                </div>
            </form>
        </div>
        <script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/js/tether.min.js'></script>
        <script src="./Nav.js"></script>

    </body>

</html>
