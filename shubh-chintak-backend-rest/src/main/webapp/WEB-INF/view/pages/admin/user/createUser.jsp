
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Top content -->
<div class="top-content">

	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<h1>
						<strong>Create New User</strong>
					</h1>
					<div class="description"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3 form-box">

					<div class="form-bottom">
						<form:form method="POST"
							action="${pageContext.request.contextPath}/welcome/admin/user/createUserSubmit"
							modelAttribute="userDTO">

							<div align="center">
								<form:errors path="*"  />
								<div class="form-group">
									<form:label path="username"> Username *:</form:label>
									<form:input path="username" type="text" name="username"
										class="form-control" id="form-username" />
									<form:errors path="username" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="password"> Password *:</form:label>
									<form:input path="password" type="password" name="password"
										class="form-control" />
									<form:errors path="password" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="firstName"> First Name : </form:label>
									<form:input path="firstName" type="text" name="fname"
										class="form-control" />
									<form:errors path="firstName" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="lastName"> Last Name:</form:label>
									<form:input path="lastName" type="text" name="lname"
										class="form-control" />
									<form:errors path="lastName" class="form-control" />

								</div>
								<div class="form-group">
									<form:label path="dob"> Date of Birth :</form:label>
									<form:input path="dob" type="date" name="dob"
										class="form-control" />
									<form:errors path="dob" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="emailId"> Email ID : </form:label>
									<form:input path="emailId" type="text" name="emailid"
										class="form-control" />
									<form:errors path="emailId" cssClass="error" />
								</div>
								<div class="form-group">
									<form:label path="mobileNumber"> Mobile Number : </form:label>
									<form:input path="mobileNumber" type="text" name="mnumber"
										class="form-control" />
									<form:errors path="mobileNumber" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="roles"> Role : </form:label>
									<form:select path="roles" multiple="true" items="${allRoles}"
										class="form-control" />
									<form:errors path="roles" cssClass="error" />
								</div>

								<%-- <div class="form-group">
									<form:label path="uname"> Address : </form:label> <form:input path="uname" type="text" name="add"
										class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="uname"> Post Code :</form:label> <form:input path="uname" type="text" name="ptc"
										class="form-control" />
								</div> --%>

								<div class="form-group">
									<button id="createUser" type="submit" class="btn">Create
										User</button>
								</div>
							</div>
						</form:form>


					</div>
				</div>
			</div>

		</div>
	</div>

</div>
