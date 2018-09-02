<!DOCTYPE html>
<html data-n-head-ssr data-n-head="">
<#include "common/listheader.ftl">
<body data-n-head="">
<div data-server-rendered="true" id="__nuxt">
    <!---->
    <div id="__layout">
        <div id="app" class="ub flex-column">
            <div class="ub-f1">
                <div class="header ub align-items ">
                    <div class="header-brand">
                        <a href="/" title="SearchMovie">SearchMovie</a></div>
                    <div class="header-search ub-f1">
                        <form id="form" method="GET" action="/list" class="ub">
                            <input id="input" type="text" name="q" maxlength="40" autocomplete="off" value="${q}" class="ub-f1">
                            <button type="submit">搜 索</button></form>
                    </div>
                    <div class="header-right ub">
                        <a href="/message" title="SearchMovie 留言">留言</a>
                        <a href="/https://github.com/wangxud" title="SearchMovie 我的github">我的github</a></div>
                </div>
                <div class="list-container">
                    <p class="list-info"></p>
                    <div class="ub">
                        <div class="list-main ub-f1">
                            <ul class="list">
                                <!---->
                                <div class="no-data box">
                                    <p>没有找到您要搜索的资源，请使用英文名称搜索重试！！！</p>
                                </div>
                            </ul>
                            <div class="page">
                                <!----></div>
                        </div>
                        <div class="list-sidebar">
                            <div class="list-declare box">
                                <strong style="color: red;font-weight: 700">磁力搜索</strong>是一个磁力链接搜索引擎，可以从DHT网络获取到当前的活跃资源，用于DHT网络的学习，分析和研究。内容是本站根据您的指令自动搜索的结果，不代表本站赞成资源的内容或立场，资源的版权归种子制作者所有。
                            </div></div>
                    </div>
                </div>
            </div>
        <#include "common/listfooter.ftl">
        </div>
    </div>
</div>
</body>

</html>