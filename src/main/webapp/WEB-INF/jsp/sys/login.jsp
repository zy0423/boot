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
    <title>Login Page</title>

    <meta name="description" content="login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="/img/favicon.png" type="image/x-icon">

    <!--Basic Styles-->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="login.jsp" rel="stylesheet" />
    <link href="/css/font-awesome.min.css" rel="stylesheet" />

    <!--Fonts-->
    <link href="/css/googleapis.family-1.css" rel="stylesheet" type="text/css">

    <!--Beyond styles-->
    <link id="beyond-link" href="/css/beyond.min.css" rel="stylesheet" />
    <link href="/css/demo.min.css" rel="stylesheet" />
    <link href="/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="login.jsp" rel="stylesheet" type="text/css" />

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="/js/skins.min.js"></script>
</head>
<!--Head Ends-->
<!--Body-->
<body>

    <div class="login-container animated fadeInDown">
        <form action="/login" method="post">
        <div class="loginbox bg-white">
            <div class="loginbox-title">登 录</div>
            <div class="loginbox-social">
                <div class="social-title ">第三方账号</div>
                <div class="social-buttons">
                    <a href="login.jsp" class="button-facebook">
                        <i class="social-icon fa fa-facebook"></i>
                    </a>
                    <a href="login.jsp" class="button-twitter">
                        <i class="social-icon fa fa-twitter"></i>
                    </a>
                    <a href="login.jsp" class="button-google">
                        <i class="social-icon fa fa-google-plus"></i>
                    </a>
                </div>
            </div>
            <div class="loginbox-or">
                <div class="or-line"></div>
                <div class="or">或</div>
            </div>
            <div class="loginbox-textbox">
                <input type="text" name="name" class="form-control" placeholder="邮箱" />
            </div>
            <div class="loginbox-textbox">
                <input type="password" name="password" class="form-control" placeholder="密码" />
            </div>
            <div class="loginbox-forgot">
                <a href="login.jsp">忘记密码?</a>
            </div>
            <div class="loginbox-submit">
                <input type="submit" class="btn btn-primary btn-block" value="登录">
            </div>
            <div class="loginbox-signup">
                <a href="/register">使用邮箱注册</a>
            </div>
        </div>
        </form>
        <div class="logobox">
        </div>
    </div>

    <!--Basic Scripts-->
    <script src="/js/jquery-2.0.3.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/slimscroll/jquery.slimscroll.min.js"></script>

    <!--Beyond Scripts-->
    <script src="/js/beyond.js"></script>
</body>
<!--Body Ends-->
</html>
