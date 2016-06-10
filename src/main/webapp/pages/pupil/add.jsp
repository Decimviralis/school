<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 25.05.16
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
  <s:actionerror/>
  <h3>Add Pupil</h3>
  <s:form action="addpupil" namespace="/" method="POST" theme="simple">
    <div class="form-group">
      <s:label for="pupil.name" value="Name"/>
      <s:textfield name="pupil.name" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="pupil.surname" value="Surname"/>
      <s:textfield name="pupil.surname" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="pupil.phone" value="Phone"/>
      <s:textfield name="pupil.phone" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="pupil.age" value="Age"/>
      <s:textfield name="pupil.age" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label for="pupil.grade" value="Grade"/>
      <s:textfield name="pupil.grade" cssClass="form-control"/>
    </div>
    <s:submit type="button" value="Submit" cssClass="btn btn-success"/>
  </s:form>
</div>