<!DOCTYPE html>
<html data-n-head-ssr data-n-head="">

<#include "common/listheader.ftl">

<body data-n-head="">
<div data-server-rendered="true" id="__nuxt">
    <!---->
    <div id="__layout">
        <div id="app" class="ub flex-column">
            <div class="ub-f1" data-v-325fe1c2>
                <div class="header ub align-items " data-v-325fe1c2>
                    <div class="header-brand" data-v-325fe1c2>
                        <a href="/" data-v-325fe1c2>SearchMovie</a></div>
                    <div class="header-search ub-f1" data-v-325fe1c2>
                        <form id="form" method="GET" action="/list" class="ub" data-v-325fe1c2>
                            <input id="input" type="text" name="q" maxlength="40" autocomplete="off" class="ub-f1" data-v-325fe1c2>
                            <button type="submit" data-v-325fe1c2>搜 索</button></form>
                    </div>
                    <div class="header-right ub" data-v-325fe1c2>
                        <a href="/message" title="SearchMovie 留言">留言</a>
                        <a href="/https://github.com/wangxud" title="SearchMovie 我的github">我的github</a></div>
                </div>
                <div class="list-container des ub" data-v-325fe1c2>
                    <div class="list-main ub-f1" data-v-325fe1c2>
                        <div class="content" data-v-325fe1c2>
                            <div class="ub con-tit align-items" data-v-325fe1c2>
                                <h3 class="ub-f1" data-v-325fe1c2>基础信息</h3>
                                </div>
                            <div class="content-body base-info" data-v-325fe1c2>
                                <div class="ub item" data-v-325fe1c2>
                                    <div class="tit" data-v-325fe1c2>资源名称</div>
                                    <div class="info ub-f1" data-v-325fe1c2>${vo.title}</div></div>
                                <div class="ub item" data-v-325fe1c2>
                                    <div class="tit" data-v-325fe1c2>国家</div>
                                    <div class="info ub-f1" data-v-325fe1c2>${vo.country}</div></div>
                                <div class="ub item" data-v-325fe1c2>
                                    <div class="tit" data-v-325fe1c2>语言</div>
                                    <div class="info ub-f1" data-v-325fe1c2>${vo.lan}</div></div>
                                <div class="ub item" data-v-325fe1c2>
                                    <div class="tit" data-v-325fe1c2>简介</div>
                                    <div class="info ub-f1" data-v-325fe1c2>${vo.introduce}</div></div>
                                <div class="ub item" data-v-325fe1c2>
                                    <div class="tit" data-v-325fe1c2>主演</div>
                                    <div class="info ub-f1" data-v-325fe1c2>${vo.mainActor}</div></div>
                            </div>
                        </div>
                        <div class="content" data-v-325fe1c2>
                            <div class="ub con-tit align-items" data-v-325fe1c2>
                                <h3 class="ub-f1" data-v-325fe1c2>磁力链接</h3>
                                <div data-clipboard-text="magnet:?xt=urn:btih:ad88c29b5fe78b38187ebfc5f466cb8a4c5243c0" class="code-btn" data-v-325fe1c2>[复制]</div></div>
                            <div class="content-body" data-v-325fe1c2>
                                <code class="break-word" data-v-325fe1c2>${vo.downloadUrl}</code></div>
                        </div>
                        <div class="content" data-v-325fe1c2>
                            <div class="ub con-tit align-items" data-v-325fe1c2>
                                <h3 class="ub-f1" data-v-325fe1c2>图片</h3></div>
                            <div class="content-body" data-v-325fe1c2>
                                <div class="ub file-info" data-v-325fe1c2>
                                    <div class="ub-f1 name break-word" data-v-325fe1c2></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <#include "common/listfooter.ftl">
        </div>
    </div>
</div>
<s
</body>

</html>