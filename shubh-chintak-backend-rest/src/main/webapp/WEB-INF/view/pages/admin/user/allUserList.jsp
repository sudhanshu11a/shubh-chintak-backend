
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Top content -->
<div class="top-content">
	<script type="text/javascript">
	$(document).ready(function() {
		   
		  $('#searchUserButton').submit(function(event) {
		      alert("Called");
		      var producer = $('#producer').val();
		      var model = $('#model').val();
		      var price = $('#price').val();
		      var json = { "producer" : producer, "model" : model, "price": price};
		       
		    $.ajax({
		        url: $("#newSmartphoneForm").attr( "action"),
		        data: JSON.stringify(json),
		        type: "POST",
		         
		        beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        },
		        success: function(smartphone) {
		            var respContent = "";
		             
		            respContent += "<span class='success'>Smartphone was created: [";
		            respContent += smartphone.producer + " : ";
		            respContent += smartphone.model + " : " ;
		            respContent += smartphone.price + "]</span>";
		             
		            $("#sPhoneFromResponse").html(respContent);         
		        }
		    });
		      
		    event.preventDefault();
		  });
		    
		});
	
	
	
		/* $(document).ready(function() {
			$('#searchUserButton').click(function(event) {
				var username = $("#username option:selected").val();
				var path = $('#contextPath').text();
				var urlValue = path + "/welcome/admin/allUsers";
				alert(urlValue);
				$.ajax({
					type : "GET",
					url : urlValue, //this is my servlet 
					cotentType : "application/json",
					data : {
						"username" : username
					},
					success : function(msg) {
						alert("success");
						if (msg != null) {
							//event.preventDefault();
							//event.stopPropagation();
							alert("h " + msg.username);
							$("#show_user").show();
							$("#user_name").text(msg.username);

						} else {
							$('#no_user').show();

						}
					}
				});
			});
		}); */
	</script>

	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<h1>
						<strong>All Users List </strong>
					</h1>
					<div class="description"></div>
				</div>
			</div>
			<div id="contextPath" style="display: none;">${pageContext.request.contextPath}</div>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3 form-box">

					<form:form method="GET" modelAttribute="userDTO">
						User : 
						<form:select path="username" items="${allUserList}" />
						<button id="searchUserButton" class="btn" type="button">Search
							User</button>
					</form:form>


					<form:form id="user_selection_form"
						action="${pageContext.request.contextPath}/welcome/admin/allUsers1"
						commandName="userDTO">
						<table>
							<tbody>
								<tr>
									<td>Producer:</td>
									<td>User : <form:select path="username">
											<form:options items="${allUserList}" />
										</form:select>
										
									</td>
								</tr>
								<tr>
									<td><input type="submit" value="Search" /></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</form:form>


					<div id="no_user" style="display: none">
						<h3>No user found</h3>
					</div>
					<div id="show_user" style="display: none">
						<div class="form-bottom">

							<div class="form-group">
								<label> Username : </label>
								<div id="user_name"></div>
							</div>
							<div class="form-group">
								<label> First Name : </label> <label>
									${userDetails.firstName}</label>
							</div>

							<div class="form-group">
								<label> Last Name : </label> <label>
									${userDetails.lastName}</label>
							</div>

							<div class="form-group">
								<label> Date of birth : </label> <label>
									${userDetails.dob}</label>
							</div>

							<div class="form-group">
								<label> Emial Id : </label> <label>
									${userDetails.emailId}</label>
							</div>

							<div class="form-group">
								<label> Mobile Number : </label> <label>
									${userDetails.mobileNumber}</label>
							</div>

						</div>
					</div>


				</div>
			</div>

		</div>
	</div>

</div>
