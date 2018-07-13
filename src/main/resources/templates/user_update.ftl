<#include "header.ftl">
<div style="width: 100%">
<div class="regi-wrap">
	<div>
    <input id="userid" class="filter" type="text" placeholder="User ID">
	<input type="button" id = "searchh" value="Search">
	</div>

	<div class="login-html">
		<input id="tab-2" type="radio" name="tab" class="sign-up" checked><label for="tab-2" class="tab">Update User Form</label>
		<div class="login-form">
			<div class="sign-up-htm">
				<div class="group">
					<input id="name" type="text" class="input" placeholder="First Name">
					<span class ="valid-msg-ok" id="name-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Excellent</span>
					<span class ="valid-msg-error" id="name-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">  Insert your name</span>		
				</div>
				<div class="group">
					<input id="dob" type="text" class="input" placeholder="Date of Birth">
					<span class ="valid-msg-ok" id="dob-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Excellent</span>
					<span class ="valid-msg-error" id="dob-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">  Insert your date of birth</span>
				</div>
				<div class="group">
					<input id="mobile" type="text" class="input" placeholder="Mobile No">
					<span class ="valid-msg-ok" id="mobile-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Excellent</span>
					<span class ="valid-msg-error" id="mobile-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">Please use your valid mobile number</span>
				</div>
				<div class="group">
					<input id="password" type="password" class="input" placeholder="Type Your Password">
					<span class ="valid-msg-ok" id="password-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Excellent</span>
					<span class ="valid-msg-error" id="password-length-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">Password length should be more than 5</span>
					<span class ="valid-msg-error" id="password-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">Please type your password</span>
				</div>
				<div class="group">
					<input id="retype_password" type="password" class="input" placeholder="Retype Your Password">
					<span class ="valid-msg-ok" id="re-password-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Password match perfectly</span>
					<span class ="valid-msg-error" id="re-password-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">Password not matching</span>
				</div>
				<div class="group">
					<select class="form-control" id="bld-group">
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
				    <span class ="valid-msg-ok" id="group-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Excellent</span>
					<span class ="valid-msg-error" id="group-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">Please select your blood group</span>
				</div>
				<div class="group">
					<input id="ldd" type="text" class="input" placeholder="Last Blood Donation Date">
					<span class ="valid-msg-ok" id="ldd-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Excellent</span>
					<span class ="valid-msg-error" id="ldd-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">  Insert your last blood donation date</span>
				</div>
				<div class="group">
					<input id="position" type="text" class="input" data-location="dummy" placeholder="Location (Please Choose From Map)" disabled>
					<span class ="valid-msg-ok" id="position-ok"><img src="/img/tick.png" alt="Okay" height="10px" width="10px"> Excellent</span>
					<span class ="valid-msg-error" id="position-error"><img src="/img/cross.png" alt="Error" height="10px" width="10px">Please select your location from map</span>
				</div>
				<div class="group">
					<input type="submit" class="button" id="submit" value="Update User">
				</div>
			</div>
		</div>
</div>
<div id="gmap"></div>
</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datepicker/0.6.4/datepicker.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAUp5JapQeoA-T8IeRhwNWfKsEVduzLSw4">
</script>
<script src="/js/registration.js"></script>

<#include "footer.ftl">