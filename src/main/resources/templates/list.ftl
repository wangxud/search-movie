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
                        <a href="https://github.com/wangxud" title="SearchMovie 我的github">我的github</a></div>
                </div>
                <div class="list-container">
                    <p class="list-info"></p>
                    <div class="ub">
                        <div class="list-main ub-f1">
                            <ul class="list">
                            <#list listPage.getContent() as listPages>
                                <li>
                                    <a href="/list/${listPages.id}" title="${listPages.title}" class="ub">
                                        <div class="ub-f1">
                                            <p class="name">${listPages.title}</p></div>
                                        <div class="info ub space-between">
                                            <div>年代：
                                                <strong>${listPages.year}</strong></div>
                                        </div>
                                    </a>
                                </li>
                            </#list>
                                <!---->
                                <!----></ul>
                            <div class="col-md-12 column">
                                <ul class="pagination">
                                <#if currentPage lte 1>
                                    <li class="disabled"><a >上一页</a></li>
                                <#else>
                                    <li class="active"><a  href="/list?q=${q}&page=${currentPage - 1}">上一页</a></li>
                                </#if>

                                <#if listPage.getTotalPages() lte 10 >
                                    <#list 1..listPage.getTotalPages() as index>
                                        <#if currentPage == index>
                                            <li class="disabled"><a  href="/list?q=${q}&page=${index}">${index}</a></li>
                                        <#else>
                                            <li class="active"><a  href="/list?q=${q}&page=${index}">${index}</a></li>
                                        </#if>
                                    </#list>
                                </#if>

                                <#if listPage.getTotalPages() gt 10 >
                                    <#list 1..5 as index>
                                        <#if currentPage == index>
                                            <li class="disabled"><a href="/list?q=${q}&page=${index}">${index}</a></li>
                                        <#else>
                                            <li class="active"><a href="/list?q=${q}&page=${index}">${index}</a></li>
                                        </#if>
                                    </#list>

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
                        </div>
                        <div class="list-sidebar">

                            <div class="list-declare box">
                                <strong style="color: red;font-weight: 700">SearchMovie</strong>是一个爬虫引擎，用于爬虫的学习，分析和研究。内容是本站根据您的指令自动搜索的结果，不代表本站赞成资源的内容或立场，资源的版权归种子制作者所有。
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
