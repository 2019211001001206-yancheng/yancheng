<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/20
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/WEB-INF/views/header.jsp" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!--寮曠敤鐧惧害鍦板浘API-->
<style type="text/css">
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<div id="contact-page" class="container">
    <!-- <div class="bg">
        <div class="row">
            <div class="col-sm-12">
                <h2 class="title text-center">Contact <strong>Us</strong></h2>
                鐧惧害鍦板浘瀹瑰櫒

                </div>

            </div>
        </div>     -->
    <div class="row">
        <div class="col-sm-8">
            <div  class="contact-map" id="dituContent"></div>
            <!-- <div class="contact-form">
                <h2 class="title text-center">Get In Touch</h2>
                <div class="status alert alert-success" style="display: none"></div>
                <form id="main-contact-form" class="contact-form row" name="contact-form" action="EmailSendingServlet" method="post">
                    <div class="form-group col-md-6">
                        <input type="text" name="name" class="form-control" required="required" placeholder="Name">
                    </div>
                    <div class="form-group col-md-6">
                        <input type="email" name="recipient" class="form-control" required="required" placeholder="Email">
                    </div>
                    <div class="form-group col-md-12">
                        <input type="text" name="subject" class="form-control" required="required" placeholder="Subject">
                    </div>
                    <div class="form-group col-md-12">
                        <textarea name="content" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"></textarea>
                    </div>
                    <div class="form-group col-md-12">
                        <input type="submit" name="submit" class="btn btn-primary pull-right" value="Submit">
                    </div>
                </form>
            </div>
 -->		</div>
        <div class="col-sm-4">
            <div class="contact-info">
                <h2 class="title text-center">Contact Info</h2>
                <address>
                    <p>ECJTU</p>
                    <p> 808, Shuanggang East Street</p>
                    <p>Economic and Technological Development Zone</p>
                    <p>Nanchang City, Jiangxi Province</p>
                    <p>Fax: 1-714-252-0026</p>
                    <p>Email: info@e-shopper.com</p>
                </address>
                <div class="social-networks">
                    <h2 class="title text-center">Social Networking</h2>
                    <ul>
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-google-plus"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-youtube"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</div><!--/#contact-page-->
<script type="text/javascript">
    //鍒涘缓鍜屽垵濮嬪寲鍦板浘鍑芥暟锛?
    function initMap(){
        createMap();//鍒涘缓鍦板浘
        setMapEvent();//璁剧疆鍦板浘浜嬩欢
        addMapControl();//鍚戝湴鍥炬坊鍔犳帶浠?
        addMarker();//鍚戝湴鍥句腑娣诲姞marker
    }