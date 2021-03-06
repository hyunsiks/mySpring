<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="http://code.highcharts.com/maps/highmaps.js"></script>
<script src="http://code.highcharts.com/maps/modules/drilldown.js"></script>
<script src="./chart.js"></script>
<script type="text/javascript">
var highMap = new highMaps();
highMap.init();
</script>
<link rel="stylesheet" href="./style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons|Material+Icons+Two+Tone|Material+Icons+Sharp" rel="stylesheet">

</head>
<body>
    <section>
        <div class="backgroundImg"></div>
        <div class="container">
            <nav class="navbar">
                <div class="logo">Travel<span style="color: orangered;">ers</span></div>
                <div class="menuBar">
                    <div class="topMenu">
                        <div></div>
                        <div class="icons">
                            <div class="flipedInfo">
                                <span class="material-icons-two-tone" style="font-size: 2.5vw;">
                                    event
                                </span>
                            </div>
                            <div class="flipedInfo">
                                <span class="material-icons-two-tone" style="font-size: 2.5vw;">
                                    location_on
                                </span>
                            </div>
                            <div class="flipedInfo">
                                <span class="material-icons-two-tone" style="font-size: 2.5vw;">
                                    phone_iphone
                                </span>
                            </div>
                            <div class="flipedInfo">
                                <span class="material-icons-two-tone" style="font-size: 2.5vw;" id="login_Btn">
                                    perm_identity
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="bottomMenu">
                        <span>??????</span>
                        <span><a href="https://www.mangoplate.com/">??????</a></span>
                        <span><a href="https://www.starbucks.co.kr/index.do">?????????</a></span>
                        <span><a href="https://www.everland.com/web/intro.html">??????</a></span>
                        <span><a href="https://gil.seoul.go.kr/walk/main.jsp">??????</a></span>
                        <span><a href="http://ticket.interpark.com/Contents/Ranking?smid1=s_menu&smid2=performance">??????</a></span>
                    </div>
                </div>
            </nav>


            <div class="mainBar">
                <div id="content">
                    <div class="travel">
                        Travel<span style="color: orangered;">ers</span>
                    </div>
                    <div class="writing">
                        <div>?????? ??????, ??????, ?????? ?????? ?????????
                            ???????????? ????????? ???????????? ????????????
                            ?????? ????????? ?????? ?????? ?????????</div>
                        <div class="start">????????????</div>
                    </div>
                </div>
                <div id="map"></div>
                <div></div>
            </div>
            <div class="footer"></div>
        </div>
    </section>

    <script src="./app.js"></script>
</body>
</html>