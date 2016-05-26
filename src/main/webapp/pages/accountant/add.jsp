<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 26.05.16
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
  <s:actionerror/>
  <h3>Add Accountant</h3>
  <s:form action="addaccountant" namespace="/" method="POST" theme="simple">
    <div class="form-group">
      <s:label for="accountant.name" value="Name"/>
      <s:textfield name="accountant.name" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="accountant.surname" value="Surname"/>
      <s:textfield name="accountant.surname" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="accountant.phone" value="Phone"/>
      <s:textfield name="accountant.phone" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="accountant.salary" value="Salary"/>
      <s:textfield name="accountant.salary" cssClass="form-control"/>
    </div>
    <s:submit type="button" value="Submit" cssClass="btn btn-success"/>
  </s:form>
</div>