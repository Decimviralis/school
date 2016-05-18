<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 18.05.16
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
  <s:form namespace="/" action="showpupil" method="POST" theme="simple">
    <div class="form-inline">
      <s:label value="Choose pupil:" cssClass="form-control"/>
    <%--<s:select list=""--%>
    </div>
  </s:form>
</div>