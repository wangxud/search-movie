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
    <title data-n-head="true">${q}_磁力搜索</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>
<body data-n-head="">
<div data-server-rendered="true" id="__nuxt"><!---->
    <div id="__layout">
        <div id="app" class="ub flex-column">
            <section>
                <div class=""></div>
                <!--header头 start-->
            <#include "common/header.ftl">
                <!--header头 end-->
                <div style="text-align:left;clear:both;margin-top:60px;margin-left:5%">
                    <div class="flex-container0">
                    <#list listPage.getContent() as listPages>
                        <div class="flex-container">
                            <div class="flex-item"><img src="${listPages.imgUrl}"></div>
                            <div class="flex-item">
                                <ul class="list">
                                    <li><h5>片名：${listPages.title}</h5></li>
                                    <li><h5>年代：${listPages.year}</h5></li>
                                    <li><h5>产地：${listPages.country}</h5></li>
                                    <li><h5>语言：${listPages.lan}</h5></li>
                                    <li><h5>主演：${listPages.mainActor}</h5></li>
                                    <li><h5>简介：${listPages.introduce}</h5></li>
                                    <br>
                                    <li><h5>下载地址：</h5> <button >点击复制下载地址</button>
                                        <code>${listPages.downloadUrl}
                                        </code>

                                    </li>
                                </ul>
                            </div>
                        </div>
                    </#list>
                    </div>
                </div>
            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination">
                    <#if currentPage lte 1>
                        <li class="disabled"><a >上一页</a></li>
                    <#else>
                        <li class="active"><a  href="/list?q=${q}&page=${currentPage - 1}">上一页</a></li>
                    </#if>

                    <#--小于等于10页全部显示-->
                    <#if listPage.getTotalPages() lte 10 >
                        <#list 1..listPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a  href="/list?q=${q}&page=${index}">${index}</a></li>
                            <#else>
                                <li class="active"><a  href="/list?q=${q}&page=${index}">${index}</a></li>
                            </#if>
                        </#list>
                    </#if>

                    <#--大于10页：显示前5页，最后3页，中间用 ...-->
                    <#if listPage.getTotalPages() gt 10 >
                    <#--显示前5页-->
                        <#list 1..5 as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="/list?q=${q}&page=${index}">${index}</a></li>
                            <#else>
                                <li class="active"><a href="/list?q=${q}&page=${index}">${index}</a></li>
                            </#if>
                        </#list>

                    <#--中间部分的显示 ...  number: currentPage, 区间逻辑的判断-->
                        <#if currentPage == 6>
                            <li class="disabled"><a  href="/list?q=${q}&page=${currentPage}">${currentPage}</a></li>
                            <li class="active"><a >..</a></li>

                        <#elseif currentPage == listPage.getTotalPages()-3 >
                            <li class="active"><a >..</a></li>
                            <li class="disabled"><a  href="/list?q=${q}&page=${currentPage}">${currentPage}</a></li>

                        <#elseif currentPage gt 6 &&  currentPage lt listPage.getTotalPages()-3>
                            <li class="active"><a >..</a></li>
                            <li class="disabled"><a  href="/list?q=${q}&page=${currentPage}">${currentPage}</a></li>
                            <li class="active"><a >..</a></li>

                        <#else>
                            <li class="active"><a >..</a></li>
                        </#if>

                    <#--显示最后3页-->
                        <#list listPage.getTotalPages()-2..listPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a  href="/list?q=${q}&page=${index}">${index}</a></li>
                            <#else >
                                <li class="active"><a  href="/list?q=${q}&page=${index}">${index}</a></li>
                            </#if>
                        </#list >
                    </#if>

                    <#if currentPage == listPage.getTotalPages()>
                        <li class="disabled"><a >下一页</a></li>
                    <#else>
                        <li class="active"><a   href="/list?q=${q}&page=${currentPage + 1}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </section>
            <div class="footer">
                <p><a href="javascript:;" data-lang="cn" class="J_Lang">中文（简体）</a><a href="javascript:;" data-lang="tw"
                                                                                     class="J_Lang">中文（繁體）</a><a
                        href="javascript:;" data-lang="en" class="J_Lang">English</a></p>
                <p>
                    <a href="http://www.miitbeian.gov.cn/" target="_blank">渝ICP备18010196号</a>
                </p>
            </div>
        </div>
    </div>
    <script src="/js/common/jquery.js"></script>
    <script src="/js/common/common.js"></script>
</body>
</html>
