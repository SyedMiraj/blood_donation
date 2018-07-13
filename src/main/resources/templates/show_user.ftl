
<div class="sign-up-htm">
<div class="login-form">
				<div class="group">
					<input id="userid" type="hidden" class="userid" value="${user.id?if_exists}">	
				</div>
				<div class="group">
					<input id="name" type="text" class="input" value="${user.name?if_exists}" placeholder="First Name">	
				</div>
				<div class="group">
					<input id="dob" type="text" class="input" value="${user.dateOfBith?if_exists}" placeholder="Date of Birth">
				</div>
				<div class="group">
					<input id="mobile" type="text" class="input" value="${user.mobileNumber?if_exists}" placeholder="Mobile No">
				</div>				
				<div class="group">
					<select class="form-control" id="bld-group" value="${user.bloodGroup?if_exists}">
					   <option value="null">Select your blood group</option>
				       <option value="1">A+ (A positive)</option>
				       <option value="2">A- (A minus)</option>
				       <option value="3">B+ (B positive)</option>
				       <option value="4">B- (B minus)</option>
				       <option value="5">O+ (O positive)</option>
				       <option value="6">O- (O minus)</option>				       
				       <option value="7">AB+ (AB positive)</option>
				       <option value="8">AB- (AB minus)</option>
				    </select>
				</div>
				<div class="group">
					<input id="ldd" type="text" class="input" value="${user.lastBloodDonate?if_exists}" placeholder="Last Blood Donation Date">
				</div>
				<div class="group">
					<input id="position" type="text" class="input" data-location="dummy" placeholder="Location (Please Choose From Map)" disabled>
				</div>
				<div class="group">
					<input type="submit" class="button" id="updateuser" value="Update User">
				</div>
			</div>
			</div>
			
<script src="/js/registration.js"></script>