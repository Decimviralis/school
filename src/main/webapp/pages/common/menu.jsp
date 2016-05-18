<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 18.05.16
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="menubar">
    <li>
        <a href="<s:url action="showpupil" namespace="/"/>">Pupil</a>
    </li>
    <li>
        <a href="<s:url action="showaccountant" namespace="/"/>">Accountant</a>
    </li>
    <li>
        <a href="<s:url action="showact" namespace="/"/>">Act</a>
    </li>
    <li>
        <a href="<s:url action="showreceipt" namespace="/"/>">Receipt</a>
    </li>
</ul>

