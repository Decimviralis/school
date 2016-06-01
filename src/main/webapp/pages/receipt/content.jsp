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
<h3>Receipts</h3>
<div>
  <s:if test="receipts.size()!=0">
    <table class="table">
      <tr>
        <th>Pupil</th>
        <th>Accountant</th>
        <th>Act</th>
        <th>Description</th>
      </tr>
      <s:iterator value="receipts">
        <tr>
          <td><s:property value="%{pupil.name + ' ' + pupil.surname}" /></td>
          <td><s:property value="%{accountant.name + ' ' + accountant.surname}" /></td>
          <td><s:property value="act.description"/></td>
          <td><s:property value="description"/></td>
        </tr>
      </s:iterator>
    </table>
  </s:if>
  <a href="<s:url action="addreceipt_input" namespace="/"/>" class="btn btn-default">Add Receipt</a>
</div>