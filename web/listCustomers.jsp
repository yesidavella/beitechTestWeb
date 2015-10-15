<%@page import="com.beitech.model.CustomerForm"%>
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
    </head>
    <body >

        <div id="divBody">
            <div id="divBody_header" class="body_header">
                <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
                    <div  style="color: red">
                        ERROR:  Application resources not loaded -- check servlet container
                        logs for error messages.
                    </div>
                </logic:notPresent>

                <div id="h2Wrapper" class="wrapperDiv">
                    <h2><bean:message key="title.listCustomers"/></h2>
                </div>
            </div>
            <div id="divBody_content">

                <div class="wrapperDiv wrapperTable">
                    <table border="1" cellpadding="1" >
                        <thead>
                            <tr>
                                <th><bean:message key="customer.id"/></th>
                                <th><bean:message key="customer.name"/></th>
                                <!--<th><bean:message key="customer.suscription"/></th>-->
                                <th><bean:message key="customer.email"/></th>
                                <th colspan="2"><bean:message key="customer.order"/></th>
                                <th ><bean:message key="customer.title.configProducts"/></th>
                            </tr>
                        </thead>
                        <tbody>

                            <logic:iterate name="customers" id="customer">

                                <tr>
                                    <td><bean:write name="customer" property="id"/></td>
                                    <td><bean:write name="customer" property="name"/></td>
                                    <!--<td><bean:write name="customer" property="idSubscription"/></td>-->
                                    <td><bean:write name="customer" property="email"/></td>
                                    <td>
                                        <a href='customerOrders.do?id_customer=<bean:write name="customer" property="id"/>' >    
                                            <bean:message key="customer.req_orders"/>
                                        </a>
                                    </td>
                                    <td>
                                        <a href='createOrder.do?id_customer=<bean:write name="customer" property="id"/>' >    
                                            <bean:message key="customer.create_order"/>
                                        </a>
                                    </td>
                                    <td>
                                        <a href='configureProducts.do?id_customer=<bean:write name="customer" property="id"/>' >    
                                            <bean:message key="customer.title.products"/>
                                        </a>
                                    </td>
                                </tr>

                            </logic:iterate>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="divBody_footer">
                <div class="wrapperDiv">
                    <bean:message key="customer.title.footer"/>
                </div>
            </div>
        </div>
    </body>
</html:html>