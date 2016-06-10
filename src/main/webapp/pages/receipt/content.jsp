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
    <s:iterator value="receipts">
      <s:if test="%{isClosed(key.act,value)}">
        <div style="border: 1px solid green; margin: 15px; padding: 5px">
          <p>Status:closed</p>
      </s:if>
      <s:else>
        <div style="border: 1px solid red; margin: 15px; padding: 5px">
          <p>Status: open</p>
      </s:else>
      <h4><s:property value="key.pupil.name"/> <s:property value="key.pupil.surname"/></h4>
      <p>Act: <s:property value="key.act.description"/>, required: <s:property value="key.act.cost"/> </p>
      <p>Month: <s:property value="%{key.month}"/></p>
      <table class="table">
        <tr>
          <th>Date</th>
          <th>Accountant</th>
          <th>Act</th>
          <th>Sum</th>
          <th>Description</th>
        </tr>
        <s:iterator value="value" var="lst">
          <tr>
            <td><s:date name="date" format="dd-MM-yyyy"/></td>
            <td><s:property value="%{accountant.name + ' ' + accountant.surname}" /></td>
            <td><s:property value="act.description"/></td>
            <td><s:property value="sum" /></td>
            <td><s:property value="description"/></td>
          </tr>
        </s:iterator>
      </table>
      </div>
    </s:iterator>
  </s:if>
  <a href="<s:url action="addreceipt_input" namespace="/"/>" class="btn btn-default">Add Receipt</a>
</div>