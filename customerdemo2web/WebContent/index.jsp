<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.openv.mybatis.customerdemo2web.paged.PageResult" %>
<%@page import="com.openv.mybatis.customerdemo2web.bean.Customer" %>
<%@page import="java.util.List" %>
<%
PageResult<Customer> pr = (PageResult<Customer>)request.getAttribute("pr");
Customer  customer = (Customer)request.getAttribute("customer");
String firstName = "",lastName="",email="";
if(customer!=null){
	firstName = customer.getFirstName();
	lastName = customer.getLastName();
	email = customer.getEmail();
}

if("null".equals(firstName)|| firstName ==null){
	firstName="";
}
if("null".equals(lastName) || lastName == null){
	lastName="";
}
if("null".equals(email) || email == null){
	email="";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Manage</title>
</head>
<body>
<table border="0" align="center" width="80%">
<tr><td><h3>Customer Manage</h3></td></tr>
</table>
<form action="<%=request.getContextPath()%>/customer.do" method="post"  name="form">
<input type="hidden" name="pageIndex" >
<table border="0" align="center" width="80%">
<tr bordercolor="#FFFFFF">
<td>first_name：</td><td ><input type="text" name="firstName" value="<%=firstName%>"></td> <td>last_name：</td>
<td><input type="text" name="lastName"  value="<%=lastName%>"></td><td>email：</td><td><input type="text" name="email" value="<%=email%>"></td>
<td><input type="submit" value="Query">&nbsp;</td><td>&nbsp;<input type="button" value="Reset" onclick="resetform()"></td>
</tr>
</table>
<table border="1" bordercolor="#000000" cellpadding="1" cellspacing="1" align="center" width="80%">
<tr style="font-style: italic;">
<td>customer_id</td><td>store_id</td><td>first_name</td><td>last_name</td>
<td>email</td><td>address_id</td><td>active</td><td>create_date</td><td>last_update</td>
</tr>
<% 
	if(pr!=null && pr.getData()!=null){
		List<Customer> data = pr.getData();
		for(Customer c : data){
%>
	<tr>
	<td><%=c.getCustomerId() %></td><td><%=c.getStoreId() %></td><td><%=c.getFirstName() %></td><td><%=c.getLastName() %></td>
	<td><%=c.getEmail() %></td><td><%=c.getAddressId() %></td><td><%=c.getActive() %></td><td><%=c.getCreateDate() %></td><td><%=c.getLastUpdate() %></td>
	</tr>
	<%
		}
} %>

<tr><td colspan="9">
<% if(pr!=null && pr.getData()!=null){
	
	int previousPage = pr.getPageIndex()-1;
	int nextPage = pr.getPageIndex()+1;
	if(previousPage<=0) previousPage = 1;
	if(nextPage>pr.getTotalPage()) nextPage = pr.getTotalPage();
	
	 %>  Total Page：<%=pr.getTotalPage() %> &nbsp;&nbsp;Current Page：<%=pr.getPageIndex() %>&nbsp;&nbsp;
	 <a href="javascript:changePage(<%=previousPage%>)" >Previous Page</a>&nbsp;&nbsp;	
	 <a href="javascript:changePage(pageIndex=<%=nextPage%>)">Next Page</a>&nbsp;&nbsp;	<%
}
%>
</td></tr>
</table>
</form>
</body>
<script>
	function resetform(){
		form.firstName.value='';
		form.lastName.value='';
		form.email.value='';
	}
	
	function changePage(pageIndex){
		form.pageIndex.value=pageIndex;
		form.submit();
	}
</script>
</html>