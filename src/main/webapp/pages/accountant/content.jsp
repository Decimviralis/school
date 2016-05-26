<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 18.05.16
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:actionerror/>
<div>
  <s:form namespace="/" action="showaccountant" method="POST" theme="simple">
    <div class="form-inline">
      <s:label value="Choose Accountant:" for="chosen.id"/>
      <s:select list="accountants" name="chosenId" cssClass="form-control"
                listKey="id" listValue="%{name + ' ' + surname}" headerKey="-1" headerValue="All"/>
      <s:submit type="button" value="submit" cssClass="btn btn-default"/>
    </div>
  </s:form>
  <s:if test="chosen!=null">
    <table class="table">
      <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone</th>
        <th>Salary</th>
      </tr>
      <tr>
        <td><s:property value="chosen.name"/></td>
        <td><s:property value="chosen.surname"/></td>
        <td><s:property value="chosen.phone"/></td>
        <td><s:property value="chosen.salary"/></td>
      </tr>
    </table>
  </s:if>
  <s:else>
    <table class="table">
      <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone</th>
        <th>Salary</th>
        <th>Delete</th>
      </tr>
      <s:iterator value="accountants">
        <tr>
          <td><s:property value="name"/></td>
          <td><s:property value="surname"/></td>
          <td><s:property value="phone"/></td>
          <td><s:property value="salary"/></td>
          <td><a class="btn btn-danger" href="<s:url action="removeaccountant" namespace="/">
                                    <s:param name="accountantId" value="id" />
                                 </s:url> ">Delete</a></td>
        </tr>
      </s:iterator>
    </table>
  </s:else>
  <a href="<s:url action="addaccountant_input" namespace="/"/>" class="btn btn-default">Add Accountant</a>
</div>
