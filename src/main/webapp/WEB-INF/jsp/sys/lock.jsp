<!DOCTYPE html>
<!--
Beyond Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3
Version: 1.0.0
Purchase: http://wrapbootstrap.com
-->

<html xmlns="http://www.w3.org/1999/xhtml">
<!--Head-->
<head>
    <meta charset="utf-8" />
    <title>Lock Screen</title>

    <meta name="description" content="lock screen" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="/img/favicon.png" type="image/x-icon">

    <!--Basic Styles-->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="lock.jsp" rel="stylesheet" />
    <link href="/css/font-awesome.min.css" rel="stylesheet" />

    <!--Fonts-->
    <link href="/css/googleapis.family-1.css" rel="stylesheet" type="text/css">

    <!--Beyond styles-->
    <link id="beyond-link" href="/css/beyond.min.css" rel="stylesheet" />
    <link href="/css/demo.min.css" rel="stylesheet" />
    <link href="/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="lock.jsp" rel="stylesheet" type="text/css" />

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="/js/skins.min.js"></script>
</head>
<!--Head Ends-->
<!--Body-->
<body>
    <div class="lock-container animated fadeInDown">
        <div class="lock-box text-align-center">
            <div class="lock-username">DIVYIA PHILLIPS</div>
            <img src="/img/avatars/divyia.jpg" alt="divyia avatar" />
            <div class="lock-password">
                <form role="form" class="form-inline" action="index.jsp">
                    <div class="form-group">
                        <span class="input-icon icon-right">
                            <input class="form-control" placeholder="Password" type="password">
                            <i class="glyphicon glyphicon-log-in themeprimary"></i>
                        </span>
                    </div>
                </form>
            </div>

        </div>
        <div class="signinbox">
            <span>Sign in as a different user?</span>
            <a href="login.jsp">Sign In Now</a>
        </div>
    </div>

    <!--Basic Scripts-->
    <script src="/js/jquery-2.0.3.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/slimscroll/jquery.slimscroll.min.js"></script>

    <!--Beyond Scripts-->
    <script src="/js/beyond.min.js"></script>
</body>
<!--Body Ends-->
</html>
