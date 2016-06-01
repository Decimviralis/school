<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 01.06.16
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
  <s:actionerror/>
  <h3>Add Receipt</h3>
  <s:form action="addreceipt" namespace="/" method="POST" theme="simple">
    <div class="form-group">
      <s:label for="pupilId" value="Pupil"/>
      <s:select list="pupils" name="pupilId" listKey="id" listValueKey="%{name + ' ' + surname}" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="accountantId" value="Accountant"/>
      <s:select list="accountants" name="accountantId" listKey="id" listValueKey="%{name + ' ' + surname}" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="actId" value="Act"/>
      <s:select list="acts" name="actId" listKey="id" listValueKey="description" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="description" value="Description"/>
      <s:textarea name="description" cssClass="form-control"/>
    </div>
    <s:submit type="button" value="Submit" cssClass="btn btn-success"/>
  </s:form>
</div>