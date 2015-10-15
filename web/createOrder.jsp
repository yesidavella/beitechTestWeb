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
        <script type="text/javascript" src="js/createOrderJS.js"></script>
    </head>

    <body  onload="setupProductUSDPrice()">

        <div id="divBody">

            <html:form action="/createOrder">

                <div id="divBody_header" class="body_header">

                    <div id="h2Wrapper" class="wrapperDiv">
                        <h2><bean:message key="order.title.page"/></h2>
                    </div>

                </div>
                <div id="divBody_content">

                    <div class="wrapperDiv wrapperTable">

                        <table border="1" cellpadding="1">
                            <thead>
                                <tr>
                                    <th colspan="5"><bean:message key="title.available.products"/></th>
                                </tr>
                                <tr>
                                    <th><bean:message key="product.id"/></th>
                                    <th><bean:message key="product.name"/></th>
                                    <th><bean:message key="product.price_eu"/></th>
                                    <th><bean:message key="product.price_usd"/></th>
                                    <th><bean:message key="product.amount"/></th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate indexId="idx" name="available_products" id="available_product">
                                    <tr>
                                        <td>
                                            <html:text styleId="prodId_${idx}" name="available_product" property="id" readonly="true" indexed="true"/>
                                        </td>
                                        <td>
                                            <html:text styleId="prodName_${idx}" name="available_product" property="name" readonly="true" indexed="true"/>
                                        </td>
                                        <td>
                                            <html:text styleId="prodEUPrice_${idx}" name="available_product" property="priceEU" readonly="true" indexed="true"/>
                                        </td>
                                        <td>
                                            <html:text styleId="prodUSDPrice_${idx}" name="available_product" property="priceUSD" readonly="true" indexed="true"/>
                                        </td>
                                        <td>
                                            <input type="number" name="available_product[${idx}].amount" min="0" value="0" id="amount_${idx}" onchange="setOrder()"/>
                                        </td>
                                    </tr>
                                </logic:iterate>
                            </tbody>
                        </table>

                        <table border="1" width="1" cellspacing="1" cellpadding="3" style="width: 100%;margin-top: 10px;">

                            <thead>
                                <tr>
                                    <th colspan="4"><bean:message key="order.title.data"/></th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td><bean:message key="order.deliveryAddress"/></td>
                                    <td colspan="4">
                                        <html:text  property="deliveryAddress" style="width: 100%;" value=""/>
                                        <!--<input type="text" id="delivery_address" name="delivery_address" value="" />-->
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <bean:message key="order.totalPrice_eu"/>
                                    </td>
                                    <td>
                                        <html:text  styleId="totalPrice_eu" property="euTotalPrice" value="0" style="width: 100%" readonly="true"/>
                                        <!--<input type="text" id="totalPrice_eu" name="totalPrice_eu" size="12" value="0" readonly="readonly" />-->
                                    </td>

                                    <td>
                                        <bean:message key="order.totalPrice_usd"/>
                                    </td>
                                    <td>
                                        <html:text styleId="totalPrice_usd" property="usdTotalPrice" value="0" style="width: 100%" readonly="true"/>
                                        <!--<input type="text" id="totalPrice_usd" name="totalPrice_usd" size="12" value="0" readonly="readonly" />-->
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <bean:message key="order.currencyRate"/>
                                    </td>
                                    <td colspan="3">
                                        <html:text styleId="currencyRate" name="reference" property="rate" size="10" readonly="true" style="width: 38%;"/>
                                        <html:hidden property="currencyRate" value="${reference.rate}"/>
                                        <!--<input type="text" id="currencyRate" name="currencyRate" value="2" size="7" readonly="readonly" />-->
                                    </td>
                                </tr>

                            </tbody>
                        </table>

                    </div>
                </div>
                <div id="divBody_footer">
                    <div class="wrapperDiv">                 

                        <html:submit styleId="submitBtn" disabled="true">
                            <bean:message key="order.save"/>
                        </html:submit>
                        <html:button property="" onclick="window.location='listCustomers.do'">
                            <bean:message key="order.backward"/>
                        </html:button>

                        <html:hidden property="idCustomer"/>

                    </div>
                </div>
            </html:form>

        </div>

    </body>
</html:html>
