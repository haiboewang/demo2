<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	a.noUnderLine:link {
		text-decoration:none;
	} 
</style>
<script type="text/javascript">
	var currentPageNumber = <c:out value="${cityStateZipAdminDto.pageNumber}" />;
	var pageCount = <c:out value="${cityStateZipAdminDto.pageCount}" />;
	
	function formSubmit() {
		document.getElementById("frm1").submit();
	}
	
	function navigate(navigateAction) {
		if("firstPage" == navigateAction) {
			setPageNumber(0);		
		} else if("previousPage" == navigateAction) {
			setPageNumber(currentPageNumber - 1);		
		} else if("nextPage" == navigateAction) {
			setPageNumber(currentPageNumber + 1);		
		} else if("lastPage" == navigateAction) {
			setPageNumber(pageCount);		
		}
		formSubmit();
	}
	
	function setPageNumber(pageNumber) {
		if(pageNumber < 1) {
			pageNumber = 1;
		} else if(pageNumber > pageCount) {
			pageNumber = pageCount;
		}
		setFieldValue("pageNumber", pageNumber);	
	}
	
	function submitEdit(action, id) {
		setFieldValue("action", action);
		setFieldValue("id", id);
		formSubmit();
	}
	
	function setFieldValue(fieldName, value) {
		document.getElementById(fieldName).value = value;
		//alert(document.getElementById(fieldName).value);
	}

</script>
<form:form id="frm1" name="frm1" method="post" action="cityStateZipAdmin" commandName="cityStateZipAdminDto" >
	<form:hidden id="pageNumber" path="pageNumber"/>
	<form:hidden id="id" path="id"/>
	<form:hidden id="action" path="action"/>
	<BR><BR><BR>
	<div align="center">
		<c:if test="${not empty cityStateZipAdminDto.message}">
			<span style="color:blue; font-weight:bold"><c:out value="${cityStateZipAdminDto.message}" /></span>
			<BR><BR>
		</c:if>
		<div>
			Zip Code: <form:input path="zip" />
	        <BR><input type="button" value="Search" onclick="formSubmit()">    
	    </div>
	    <div><BR>
	    	<a class="noUnderLine" href="javascript:navigate('firstPage')">&lt;&lt;</a>&nbsp;&nbsp;
	    	<a class="noUnderLine" href="javascript:navigate('previousPage')">&lt;</a>&nbsp;&nbsp;
	    	<c:out value="${cityStateZipAdminDto.pageNumber}" />&nbsp; of &nbsp;<c:out value="${cityStateZipAdminDto.pageCount}" />&nbsp;&nbsp;
	    	<a class="noUnderLine" href="javascript:navigate('nextPage')">&gt;</a>&nbsp;&nbsp;
	    	<a class="noUnderLine" href="javascript:navigate('lastPage')">&gt;&gt;</a>
	    	<BR>Page size: 
	    	<form:select path="pageSize" onchange="formSubmit()">
	    		<form:option value="10"/>
	    		<form:option value="25"/>
	    		<form:option value="50"/>
	    	</form:select>
	    </div>   
	    <div><BR>
	       	<table border="1" >
	        <tr><th width="300px">City</th><th width="50px">State</th><th width="100px">Zip Code</th><th width="150px">Options</th></tr>
	        <c:forEach var="dto" items="${cityStateZipAdminDto.cityStateZipList}">
	        	<tr>
	        		<td><c:out value="${dto.city}" /></td>
	        		<td align="center"><c:out value="${dto.state}" /></td>
	        		<td align="center"><c:out value="${dto.zip}" /></td>
	        		<td align="center"><a href="javascript:submitEdit('edit', ${dto.id})">Edit</a>
	        		&nbsp;&nbsp;|&nbsp;&nbsp;
	        		<a href="javascript:submitEdit('delete', ${dto.id})">Delete</a></td></tr>
	        </c:forEach>
	        </table>
	    </div>
	</div>    
</form:form>

