<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-sidebar" id="sidebar">
    <!-- Page Sidebar Header-->
    <div class="sidebar-header-wrapper">
        <input type="text" class="searchinput"/>
        <i class="searchicon fa fa-search"></i>
        <div class="searchhelper">Search Reports, Charts, Emails or Notifications</div>
    </div>
    <!-- /Page Sidebar Header -->
    <!-- Sidebar Menu -->
    <ul class="nav sidebar-menu">
        <!--Dashboard-->
        <li>
            <a href="/home">
                <i class="menu-icon glyphicon glyphicon-home"></i>
                <span class="menu-text"> Dashboard </span>
            </a>
        </li>
        <!--Databoxes-->
        <li>
            <a href="databoxes.jsp">
                <i class="menu-icon glyphicon glyphicon-tasks"></i>
                <span class="menu-text"> Data Boxes </span>
            </a>
        </li>
        <!--Widgets-->
        <li>
            <a href="widgets.jsp">
                <i class="menu-icon fa fa-th"></i>
                <span class="menu-text"> Widgets </span>
            </a>
        </li>
        <!--UI Elements-->
        <li>
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon fa fa-desktop"></i>
                <span class="menu-text"> Elements </span>

                <i class="menu-expand"></i>
            </a>

            <ul class="submenu">
                <li>
                    <a href="elements.jsp">
                        <span class="menu-text">Basic Elements</span>
                    </a>
                </li>
                <li>
                    <a href="blank.jsp#" class="menu-dropdown">
                                    <span class="menu-text">
                                        Icons
                                    </span>
                        <i class="menu-expand"></i>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="font-awesome.jsp">
                                <i class="menu-icon fa fa-rocket"></i>
                                <span class="menu-text">Font Awesome</span>
                            </a>
                        </li>
                        <li>
                            <a href="glyph-icons.jsp">
                                <i class="menu-icon glyphicon glyphicon-stats"></i>
                                <span class="menu-text">Glyph Icons</span>
                            </a>
                        </li>
                        <li>
                            <a href="typicon.jsp">
                                <i class="menu-icon typcn typcn-location-outline"></i>
                                <span class="menu-text"> Typicons</span>
                            </a>
                        </li>
                        <li>
                            <a href="weather-icons.jsp">
                                <i class="menu-icon wi wi-hot"></i>
                                <span class="menu-text">Weather Icons</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="tabs.jsp">
                        <span class="menu-text">Tabs & Accordions</span>
                    </a>
                </li>
                <li>
                    <a href="alerts.jsp">
                        <span class="menu-text">Alerts & Tooltips</span>
                    </a>
                </li>
                <li>
                    <a href="modals.jsp">
                        <span class="menu-text">Modals & Wells</span>
                    </a>
                </li>
                <li>
                    <a href="buttons.jsp">
                        <span class="menu-text">Buttons</span>
                    </a>
                </li>
                <li>
                    <a href="nestable-list.jsp">
                        <span class="menu-text"> Nestable List</span>
                    </a>
                </li>
                <li>
                    <a href="treeview.jsp">
                        <span class="menu-text">Treeview</span>
                    </a>
                </li>
            </ul>
        </li>
        <!--Tables-->
        <li>
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon fa fa-table"></i>
                <span class="menu-text"> Tables </span>

                <i class="menu-expand"></i>
            </a>

            <ul class="submenu">
                <li>
                    <a href="tables-simple.jsp">
                        <span class="menu-text">Simple & Responsive</span>
                    </a>
                </li>
                <li>
                    <a href="tables-data.jsp">
                        <span class="menu-text">Data Tables</span>
                    </a>
                </li>
            </ul>
        </li>
        <!--Forms-->
        <li>
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> Forms </span>

                <i class="menu-expand"></i>
            </a>

            <ul class="submenu">
                <li>
                    <a href="form-layouts.jsp">
                        <span class="menu-text">Form Layouts</span>
                    </a>
                </li>

                <li>
                    <a href="form-inputs.jsp">
                        <span class="menu-text">Form Inputs</span>
                    </a>
                </li>

                <li>
                    <a href="form-pickers.jsp">
                        <span class="menu-text">Data Pickers</span>
                    </a>
                </li>
                <li>
                    <a href="form-wizard.jsp">
                        <span class="menu-text">Wizard</span>
                    </a>
                </li>
                <li>
                    <a href="form-validation.jsp">
                        <span class="menu-text">Validation</span>
                    </a>
                </li>
                <li>
                    <a href="form-editors.jsp">
                        <span class="menu-text">Editors</span>
                    </a>
                </li>
            </ul>
        </li>
        <!--Charts-->
        <li>
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon fa fa-bar-chart-o"></i>
                <span class="menu-text"> Charts </span>

                <i class="menu-expand"></i>
            </a>

            <ul class="submenu">
                <li>
                    <a href="flot.jsp">
                        <span class="menu-text">Flot Charts</span>
                    </a>
                </li>

                <li>
                    <a href="morris.jsp">
                        <span class="menu-text"> Morris Charts</span>
                    </a>
                </li>
                <li>
                    <a href="sparkline.jsp">
                        <span class="menu-text">Sparkline Charts</span>
                    </a>
                </li>
                <li>
                    <a href="easypiecharts.jsp">
                        <span class="menu-text">Easy Pie Charts</span>
                    </a>
                </li>
                <li>
                    <a href="chartjs.jsp">
                        <span class="menu-text"> ChartJS</span>
                    </a>
                </li>
            </ul>
        </li>
        <!--Profile-->
        <li>
            <a href="profile.jsp">
                <i class="menu-icon fa fa-picture-o"></i>
                <span class="menu-text">Profile</span>
            </a>
        </li>
        <!--Mail-->
        <li>
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon fa fa-envelope-o"></i>
                <span class="menu-text"> Mail </span>

                <i class="menu-expand"></i>
            </a>

            <ul class="submenu">
                <li>
                    <a href="inbox.jsp">
                        <span class="menu-text">Inbox</span>
                    </a>
                </li>

                <li>
                    <a href="message-view.jsp">
                        <span class="menu-text">View Message</span>
                    </a>
                </li>
                <li>
                    <a href="message-compose.jsp">
                        <span class="menu-text">Compose Message</span>
                    </a>
                </li>
            </ul>
        </li>
        <!--Calendar-->
        <li>
            <a href="calendar.jsp">
                <i class="menu-icon fa fa-calendar"></i>
                            <span class="menu-text">
                                Calendar
                            </span>
            </a>
        </li>
        <!--Pages-->
        <li>
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon glyphicon glyphicon-paperclip"></i>
                <span class="menu-text"> Pages </span>

                <i class="menu-expand"></i>
            </a>
            <ul class="submenu">
                <li>
                    <a href="timeline.jsp">
                        <span class="menu-text">Timeline</span>
                    </a>
                </li>
                <li>
                    <a href="pricing.jsp">
                        <span class="menu-text">Pricing Tables</span>
                    </a>
                </li>

                <li>
                    <a href="invoice.jsp">
                        <span class="menu-text">Invoice</span>
                    </a>
                </li>

                <li>
                    <a href="login.jsp">
                        <span class="menu-text">Login</span>
                    </a>
                </li>
                <li>
                    <a href="register.jsp">
                        <span class="menu-text">Register</span>
                    </a>
                </li>
                <li>
                    <a href="lock.jsp">
                        <span class="menu-text">Lock Screen</span>
                    </a>
                </li>
                <li>
                    <a href="typography.jsp">
                        <span class="menu-text"> Typography </span>
                    </a>
                </li>
            </ul>
        </li>
        <!--More Pages-->
        <li class="active open">
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon glyphicon glyphicon-link"></i>

                            <span class="menu-text">
                                More Pages
                            </span>

                <i class="menu-expand"></i>
            </a>

            <ul class="submenu">
                <li>
                    <a href="error-404.jsp">
                        <span class="menu-text">Error 404</span>
                    </a>
                </li>

                <li>
                    <a href="error-500.jsp">
                        <span class="menu-text"> Error 500</span>
                    </a>
                </li>
                <li class="active">
                    <a href="blank.jsp">
                        <span class="menu-text">Blank Page</span>
                    </a>
                </li>
                <li>
                    <a href="/home/grid">
                        <span class="menu-text"> Grid</span>
                    </a>
                </li>
                <li>
                    <a href="blank.jsp#" class="menu-dropdown">
                                    <span class="menu-text">
                                        Multi Level Menu
                                    </span>
                        <i class="menu-expand"></i>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="blank.jsp#">
                                <i class="menu-icon fa fa-camera"></i>
                                <span class="menu-text">Level 3</span>
                            </a>
                        </li>

                        <li>
                            <a href="blank.jsp#" class="menu-dropdown">
                                <i class="menu-icon fa fa-asterisk"></i>

                                            <span class="menu-text">
                                                Level 4
                                            </span>
                                <i class="menu-expand"></i>
                            </a>

                            <ul class="submenu">
                                <li>
                                    <a href="blank.jsp#">
                                        <i class="menu-icon fa fa-bolt"></i>
                                        <span class="menu-text">Some Item</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="blank.jsp#">
                                        <i class="menu-icon fa fa-bug"></i>
                                        <span class="menu-text">Another Item</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <!--Right to Left-->
        <li>
            <a href="blank.jsp#" class="menu-dropdown">
                <i class="menu-icon fa fa-align-right"></i>
                <span class="menu-text"> Right to Left </span>

                <i class="menu-expand"></i>
            </a>
            <ul class="submenu">
                <li>
                    <a>
                        <span class="menu-text">RTL</span>
                        <label class="pull-right margin-top-10">
                            <input id="rtl-changer" class="checkbox-slider slider-icon colored-primary" type="checkbox">
                            <span class="text"></span>
                        </label>
                    </a>
                </li>
                <li>
                    <a href="index-rtl-ar.jsp">
                        <span class="menu-text">Arabic Layout</span>
                    </a>
                </li>

                <li>
                    <a href="index-rtl-fa.jsp">
                        <span class="menu-text">Persian Layout</span>
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="versions.jsp">
                <i class="menu-icon glyphicon glyphicon-fire themesecondary"></i>
                            <span class="menu-text">
                                BeyondAdmin Versions
                            </span>
            </a>
        </li>
    </ul>
    <!-- /Sidebar Menu -->
</div>
<script type="application/javascript">

</script>