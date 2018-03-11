<!DOCTYPE html>
<html>
<#include "include/head.ftl">
<body>
<#include "include/support.ftl">
<#include "include/header.ftl">
<#--<#assign listType = RequestParameters['type']!0>-->
<#assign listTypeString = RequestParameters['type']!0>
<#assign listType = listTypeString?number
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li <#if !listType?? || listType != 1>class="z-sel"</#if> ><a href="/">所有内容</a></li>
                <#if user?? && user.usertype?? && user.usertype == 0>
                    <li <#if listType == 1>class="z-sel"</#if> ><a href="?type=1">未购买的内容</a></li></#if>
            </ul>
        </div>
    </div>
    <#if !CommodityList?? || !CommodityList?has_content>
    <div class="n-result">
        <h3>暂无内容！</h3>
    </div>
    <#else>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
        <#if user?? && user.usertype?? && user.usertype == 0 && listType == 1>
            <#list CommodityList as x>
                <#if !x.buy>
                <li id="p-${x.uid}">
                    <a href="/show?id=${x.uid}" class="link">
                        <div class="img"><img src="${x.image_url}" alt="${x.title}"></div>
                        <h3>${x.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.price}</span></div>
                    </a>
                </li>
                </#if>
            </#list>
        <#else>
            <#list CommodityList as x>
                <li id="p-${x.uid}">
                    <a href="/edit?id=${x.uid}" class="link">
                        <div class="img"><img src="${x.image_url}" alt="${x.title}"></div>
                        <h3>${x.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.price}</span></div>
                        <#if user?? && user.usertype?? && user.usertype==0 && x.buy><span
                                class="had"><b>已购买</b></span></#if>
                        <#if user?? && user.usertype?? && user.usertype==1 && x.sell><span
                                class="had"><b>已售出</b></span></#if>
                    </a>
                    <#if user?? && user.usertype?? && user.usertype==1 && !x.sell><span
                            class="u-btn u-btn-normal u-btn-xs del" data-del="${x.uid}">删除</span></#if>
                </li>
            </#list>
        </#if>
        </ul>
    </div>
    </#if>
</div>
<#include "include/footer.ftl">
<script type="/text/javascript" src="/js/global.js"></script>
<script type="/text/javascript" src="/js/pageIndex.js"></script>
</body>
</html>