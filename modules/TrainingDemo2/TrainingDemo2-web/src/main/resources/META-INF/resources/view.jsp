<%@ include file="/init.jsp" %>
<%@page import="training.demo.service.StudentLocalServiceUtil" %>
<%@page import="training.demo.model.Student" %>
<%@page import="java.util.List" %>
<div class="container">
<center>
<h3>Student Details</h3>

</center>

<% 
 List<Student> studentlist=StudentLocalServiceUtil.getStudents(-1,-1);


%>
<portlet:renderURL var="addStudent">
<portlet:param name="mvcPath" value="/addStudent.jsp"/>
</portlet:renderURL>


<a href="<%=addStudent %>" class="btn btn-primary btn-default">Add Student</a> 
<br>
<table class="table table-striped">
<tr>
<th>Student ID</th>
<th>Name</th>
<th>Email</th>
<th>Phone no</th>
</tr>
<%

for(Student student : studentlist){
	
	

%>
<tr>
<td><%=student.getStudentId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getEmail() %></td>
<td><%=student.getMobileNo() %></td>
</tr>
<%} %>
</table>
</div>