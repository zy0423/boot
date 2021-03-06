﻿<!DOCTYPE html>
<!--
Beyond Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3
Version: 1.0.0
Purchase: http://wrapbootstrap.com
-->

<html xmlns="http://www.w3.org/1999/xhtml">
<!--Head-->
<head>
    <meta charset="utf-8" />
    <title>Register Page</title>

    <meta name="description" content="register page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="/img/favicon.png" type="image/x-icon">

    <!--Basic Styles-->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="register.jsp" rel="stylesheet" />
    <link href="/css/font-awesome.min.css" rel="stylesheet" />

    <!--Fonts-->
    <link href="/css/googleapis.family-1.css" rel="stylesheet" type="text/css">

    <!--Beyond styles-->
    <link id="beyond-link" href="/css/beyond.min.css" rel="stylesheet" />
    <link href="/css/demo.min.css" rel="stylesheet" />
    <link href="/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="register.jsp" rel="stylesheet" type="text/css" />

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="/js/skins.min.js"></script>
</head>
<!--Head Ends-->
<!--Body-->
<body>
    <div class="register-container animated fadeInDown">
        <form action="/register" method="post">
        <div class="registerbox bg-white">
            <div class="registerbox-title">注册</div>

            <div class="registerbox-caption ">请填写您的信息</div>
            <div class="registerbox-textbox">
                <input type="text" class="form-control" placeholder="用户名" />
            </div>
            <div class="registerbox-textbox">
                <input type="password" class="form-control" placeholder="密码" />
            </div>
            <div class="registerbox-textbox">
                <input type="password" class="form-control" placeholder="再次输入密码" />
            </div>
            <div class="registerbox-textbox">
                <input type="text" class="form-control" placeholder="联系电话" />
            </div>
            <div class="registerbox-textbox">
                <input type="email" class="form-control" placeholder="邮箱" />
            </div>
            <hr class="wide" />
            <div class="registerbox-textbox">
                <input type="text" class="form-control" placeholder="名" />
            </div>
            <div class="registerbox-textbox">
                <input type="text" class="form-control" placeholder="姓" />
            </div>
            <div class="registerbox-textbox">
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-xs-6 padding-right-10">
                        <input type="text" class="form-control" placeholder="月" />
                    </div>
                    <div class="col-lg-3 col-sm-3 col-xs-3 no-padding padding-right-10">
                        <input type="text" class="form-control" placeholder="日" />
                    </div>
                    <div class="col-lg-3 col-sm-3 col-xs-3 no-padding-left">
                        <input type="text" class="form-control" placeholder="年" />
                    </div>
                </div>
            </div>
            <div class="registerbox-textbox no-padding-bottom">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" class="colored-primary" checked="checked">
                        <span class="text darkgray">我同意该公司 <a class="themeprimary">服务条款</a>和隐私政策</span>
                    </label>
                </div>
            </div>
            <div class="registerbox-submit">
                <input type="button" class="btn btn-primary pull-right" value="保存">
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
    <script src="/js/beyond.min.js"></script>
</body>
<!--Body Ends-->
</html>
