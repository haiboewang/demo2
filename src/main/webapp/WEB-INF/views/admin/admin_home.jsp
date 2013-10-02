<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="cityStateZipAdmin" method="post" action="cityStateZipAdmin" commandName="cityStateZipAdmin" >
	<table>
		<tr>
			<td>Zip Code</td>
            <td><form:input path="zip"/>
            </td>
		<tr>
             <td></td>
             <td><input type="submit" name="submit" class="button" value="Search" /></td>
        </tr>
      </table>
</form:form>

