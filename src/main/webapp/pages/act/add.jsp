<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 27.05.16
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript">
  $(function () {
    $('#datetimepicker').datetimepicker({
      pickTime: false,
      format: "DD-MM-YYYY",
      language: 'ru'
    });
  });
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
  <s:actionerror/>
  <h3>Add Act</h3>
  <s:form action="addact" namespace="/" method="POST" theme="simple">
    <div class="form-group">
      <s:label for="description" value="Description" cssClass="control-label"/>
      <s:textarea name="description" cssClass="form-control"/>
    </div>
    <div class="form-group">
      <s:label value="Date" for="datetimepicker" class="control-label"/>
      <div class="input-group date" id="datetimepicker">
        <s:textfield name="date" class="form-control"/>
                        <span class="input-group-addon">
                            <span class="glyphicon-calendar glyphicon"></span>
                        </span>
      </div>
    </div>
    <div class="form-group">
      <s:label for="cost" value="Cost" cssClass="control-label"/>
      <s:textfield name="cost" cssClass="form-control"/>
    </div>
    <s:submit type="button" value="Submit" cssClass="btn btn-success"/>
  </s:form>
</div>
