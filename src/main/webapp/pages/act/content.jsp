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
  <s:form namespace="/" action="showact" method="POST" theme="simple">
    <div class="form-inline">
      <s:label value="Choose Act:" for="chosenId"/>
      <s:select list="acts" name="chosenId" cssClass="form-control"
                listKey="id" listValue="%{description}" headerKey="null" headerValue="All"/>
      <s:submit type="button" value="submit" cssClass="btn btn-default"/>
    </div>
  </s:form>
  <s:if test="chosen!=null">
    <table class="table">
      <tr>
        <th>Description</th>
        <th>Adoption date</th>
      </tr>
      <tr>
        <td><s:property value="chosen.description"/></td>
        <td><s:property value="chosen.adoptionDate"/></td>
      </tr>
    </table>
  </s:if>
  <s:else>
    <table class="table">
      <tr>
        <th>Description</th>
        <th>Adoption date</th>
        <th>Delete</th>
      </tr>
      <s:iterator value="acts">
        <tr>
          <td><s:property value="description"/></td>
          <td><s:date name="adoptionDate" format="dd-MM-yyyy"/></td>
          <td>
            <a class="btn btn-danger" href="<s:url action="removeact" namespace="/">
                                    <s:param name="actId" value="id" />
                                 </s:url> ">Delete
            </a>
          </td>
        </tr>
      </s:iterator>
    </table>
  </s:else>
  <a href="<s:url action="addact_input" namespace="/"/>" class="btn btn-default">Add Act</a>
</div>
