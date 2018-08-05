<!DOCTYPE html>
<html data-n-head-ssr data-n-head="">
<head>
    <meta data-n-head="true" charset="utf-8"/>
    <meta data-n-head="true" name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta data-n-head="true" name="google-site-verification" content="QP6oOpStGlOgPiFnFIylY6lwXUM9bb0Gb9LI6CSlAmw"/>
    <meta data-n-head="true" name="apple-mobile-web-app-title" content="傻逼吧"/>
    <meta data-n-head="true" name="apple-mobile-web-app-capable" content="yes"/>
    <meta data-n-head="true" name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta data-n-head="true" name="format-detection" content="telephone=no, email=no"/>
    <meta data-n-head="true" name="renderer" content="webkit"/>
    <meta data-n-head="true" data-hid="description" name="description"
          content="searchmovie 是一个BT种子、磁力链接、精准高效的为您提供最新最热的bt资源的搜索和下载服务，所有资源均来自互联网，如有侵权，请联系管理员删除。"/>
    <meta data-n-head="true" data-hid="Keywords" name="Keywords"
          content="种子搜索神器,种子搜索,磁力链接,磁力搜索,torrentkitty, 磁力之家"/>
    <title data-n-head="true">磁力链接搜索</title>
    <!---->
    <!--<link data-n-head="true" rel="icon" type="image/x-icon" href="/favicon.ico"/>
    <link data-n-head="true" rel="apple-touch-startup-image" href="/favicon.ico"/>
    <link data-n-head="true" rel="apple-touch-icon" href="/favicon.ico"/>-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>
<body data-n-head="">

<div data-server-rendered="true" id="__nuxt"><!---->
    <div id="__layout">
        <div id="app" class="ub flex-column">
            <section >
                <div class="index-bg"></div>
                <!--header头 start-->
                    <#include "common/header.ftl">
                <!--header头 end-->
                <!--动画start-->
                <div class="grid"></div>
                <script src="/js/common/jquery.js"></script>
                <script src="/js/common/jquery.easing.min.js"></script>
                <script src="/js/index.js"></script>
                <script src="/js/common/common.js"></script>
                <!--动画end-->
                <div class="index-main">
                    <div class="index-search  justify-content align-items ub">
                        <form id="form" method="GET" action="/list" class="ub ub-f1">
                            <input id="input" type="text" name="q" autocomplete="off" maxlength="40" class="ub-f1">
                            <button type="submit">搜 索</button>
                        </form>
                    </div>
                </div>
                <!--页脚 start-->
                    <#include "common/footer.ftl">
                <!--页脚 end-->
            </section>
            <!--<div class="footer">
                <p><a href="javascript:;" data-lang="cn" class="J_Lang">中文（简体）</a><a href="javascript:;" data-lang="tw" class="J_Lang">中文（繁體）</a><a href="javascript:;" data-lang="en" class="J_Lang">English</a></p>
                <p>Copyright &copy; 2018 FindCl.co</p>
            </div>-->
        </div>
    </div>



</body>
</html>
