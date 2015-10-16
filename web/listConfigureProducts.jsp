<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
        <link href="css/general_styles.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="js/configureProductsJS.js"></script>
    </head>
    <body>

        <div id="divBody">

            <div id="divBody_header" class="body_header">
                <div id="h2Wrapper" class="wrapperDiv">
                    <h2> <bean:message key="customer.title.configProducts"/> </h2>
                </div>

            </div>
            <div id="divBody_content">

                <div class="wrapperDiv wrapperTable">
                    <!--<form id="formConfig" method="POST">-->

                    <table border="1" cellpadding="1">
                        <thead>
                            <tr>
                                <th><bean:message key="product.id"/></th>
                                <th><bean:message key="product.name"/></th>
                                <th><bean:message key="product.price_usd"/></th>
                                <th><bean:message key="product.price_eu"/></th>
                                <th><bean:message key="product.activate"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:iterate name="all_products" id="product" indexId="idProduct">

                                <tr>
                                    <td><bean:write name="product" property="id"/></td>
                                    <td><bean:write name="product" property="name"/></td>
                                    <td><bean:write name="product" property="priceEU"/></td>
                                    <td><bean:write name="product" property="priceUSD"/></td>
                                    <td>

                                        <%boolean a = false;%>

                                        <logic:iterate name="active_products" id="activeProduct" indexId="idActProduct">

                                            <logic:equal name="activeProduct" property="id" value="${product.id}">
                                                <input type="checkbox" value='<bean:write name="product" property="id"/>' checked="true" onclick="modifySubscription(this)"/>
                                                <% a = true;%>
                                            </logic:equal>
                                        </logic:iterate>


                                        <%
                                            if (a == false) {
                                        %>
                                        <input type="checkbox" value='<bean:write name="product" property="id"/>' onclick="modifySubscription(this)"/>
                                        <%
                                            }
                                        %>
                                    </td>
                                </tr>
                            </logic:iterate>
                        </tbody>
                    </table>
                    <input type="hidden" id="id_customer" value="${param.id_customer}"/>
                </div>
            </div>

            <div id="divBody_footer">
                <div class="wrapperDiv">
                    <html:button property="" onclick="window.location='listCustomers.do'">
                        <bean:message key="order.backward"/>
                    </html:button>
                    <bean:message key="customer.title.footer"/>
                </div>
            </div>

        </div>
    </body>
</html:html>