<#import "parts/common.ftl" as c>

<@c.page>
    <main role="main" class="container">
    <div class="my-3 p-3 bg-white rounded shadow-sm">
    <h6 class="border-bottom border-gray pb-2 mb-0">Входящие сообщения:</h6>
    <#list mails as mail>
        <div class="media text-muted pt-3">
            <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg"
                 preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#007bff"/>
                <text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text>
            </svg>
            <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                <strong class="d-block text-black link-like" data-toggle="collapse"
                        href="#mail-${mail.id}" aria-expanded="false"
                        aria-controls="#mail-${mail.id}">${mail.from}</strong>
                <strong class="d-block text-gray-dark">${mail.subject}</strong>
            </p>
        </div>
        <div class="collapse" id="mail-${mail.id}">
            <div class="card card-body">
                <pre>${mail.text}</pre>
            </div>
        </div>
    <#--    <#else>-->
    <#--        No messages-->
    </#list>

</@c.page>