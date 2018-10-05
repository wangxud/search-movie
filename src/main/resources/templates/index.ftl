<!DOCTYPE html>
<html data-n-head-ssr data-n-head="">
<head>
    <meta data-n-head="true" charset="utf-8"/>
    <meta data-n-head="true" name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta data-n-head="true" name="google-site-verification" content="QP6oOpStGlOgPiFnFIylY6lwXUM9bb0Gb9LI6CSlAmw"/>
    <meta data-n-head="true" name="apple-mobile-web-app-title" content="SearchMovie"/>
    <meta data-n-head="true" name="apple-mobile-web-app-capable" content="yes"/>
    <meta data-n-head="true" name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta data-n-head="true" name="format-detection" content="telephone=no, email=no"/>
    <meta data-n-head="true" name="renderer" content="webkit"/>
    <meta data-n-head="true" data-hid="description" name="description"
          content="SearchMovie 是一个BT种子、磁力链接、精准高效的为您提供最新最热的bt资源的搜索和下载服务，所有资源均来自互联网，如有侵权，请联系管理员删除。"/>
    <meta data-n-head="true" data-hid="Keywords" name="Keywords"
          content="种子搜索神器,种子搜索,磁力链接,磁力搜索,torrentkitty, 磁力之家"/>
    <title data-n-head="true">SearchMovie</title>
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
                        <form id="form" name="myForm" method="post" action="/list" class="ub ub-f1">
                            <input id="input" type="text" name="q" autocomplete="off" maxlength="40" class="ub-f1">
                            <button  type="button" name="submit1" onclick="check(this.form)">搜 索</button>
                        </form>
                        <script type="text/javascript">
                            function check(form) {
                                var query=form.q.value;
                                if(!$.trim(query)){
                                    form.q.focus();
                                    return false;
                                }
                                document.myForm.submit();
                            }
                        </script>
                    </div>
                </div>
                <!--页脚 start-->
                    <#include "common/footer.ftl">
                <!--页脚 end-->
            </section>
        </div>
    </div>



</body>
</html>
