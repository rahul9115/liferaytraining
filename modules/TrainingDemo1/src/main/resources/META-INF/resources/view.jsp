<%@ include file="/init.jsp" %>
<portlet:actionURL var="submitformurl" name="submitform">

</portlet:actionURL>
<portlet:renderURL var="redirectURL">
<portlet:param name="mvcPath" value="/demo.jsp"/>
</portlet:renderURL>>


<div class="container">
<p>
	<b><liferay-ui:message key="trainingdemo1.caption"/></b>
</p>
<a href="<%= redirectURL%>">Redirect to demo.jsp</a>
<liferay-ui:success key="success" message="form submitted successfully!!"/>
<liferay-ui:error key="email" message="Only lnt mails accepted"/>
<liferay-ui:error key="mobile" message="Only 10 digit mobile number accepted"/>
<liferay-ui:error key="password" message="Password does not meet the criteria"/>
<div class="jumbotron">

<form action="<%= submitformurl %>" method="post">
<div class="form-group">
<label>Name</label>
<input class="form-control" type="text" name="<portlet:namespace/>fname" placeholder="Enter first name" required></input>
</div>
<div class="form-group">
<label>Middle name</label>
<input class="form-control" type="text" name="<portlet:namespace/>mname" placeholder="Enter middle name" required></input>
</div>
<div class="form-group">
<label>Last name</label>
<input class="form-control" type="text" name="<portlet:namespace/>lname" placeholder="Enter last name" required></input>
</div>
<div class="form-group">
<label>Email</label>
<input class="form-control" type="email" name="<portlet:namespace/>email" placeholder="Enter email" required></input>
</div>
<div class="form-group">
<label>Password</label>
<input class="form-control" type="password" name="<portlet:namespace/>password" placeholder="Enter password" required></input>
</div>
<div class="form-group">
<label>Date</label>
<input class="form-control" type="date" name="<portlet:namespace/>date" placeholder="Enter date" required></input>
</div>
<div class="form-group">
<label>Mobile Number</label>
<input class="form-control" type="number" name="<portlet:namespace/>mobileno" placeholder="Enter number" required></input>
</div>
<div class="form-group">
<label>Hobbies</label>
<input class="form-control" type="text" name="<portlet:namespace/>Hobbies"  placeholder="Enter Hobbies" required></input>
</div>

<button class="btn btn-primary" type="submit">Submit Test</button>
</form>
</div>
</div>

