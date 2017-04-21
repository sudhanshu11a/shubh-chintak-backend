
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Top content -->

<c:if test="${userDetails==null}">
	No user Found 
</c:if>

<c:if test="${userDetails!=null}" >
	<div class="form-bottom">
		
		<div class="form-group">
			<label> Username : </label> <label> ${userDetails.username}</label>
		</div>
		<div class="form-group">
			<label> First Name : </label> <label> ${userDetails.firstName}</label>
		</div>

		<div class="form-group">
			<label> Last Name : </label> <label> ${userDetails.lastName}</label>
		</div>

		<div class="form-group">
			<label> Date of birth : </label> <label> ${userDetails.dob}</label>
		</div>

		<div class="form-group">
			<label> Emial Id : </label> <label> ${userDetails.emailId}</label>
		</div>

		<div class="form-group">
			<label> Mobile Number : </label> <label> ${userDetails.mobileNumber}</label>
		</div>

	</div>
</c:if>

