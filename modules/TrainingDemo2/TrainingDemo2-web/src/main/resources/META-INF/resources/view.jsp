<%@ include file="/init.jsp" %>
<%@page import="training.demo.service.StudentLocalServiceUtil" %>
<%@page import="training.demo.model.Student" %>
<%@page import="java.util.List" %>

<center>
<h3>Student Details</h3>

</center>

<% 
 List<Student> studentlist=StudentLocalServiceUtil.getStudents(-1,-1);


%>
<portlet:renderURL var="addStudent">
<portlet:param name="mvcPath" value="/addStudent.jsp"/>
</portlet:renderURL>>

<a href="<%=addStudent %>>" class="btn btn-primary btn-default">Add Student</a> 
