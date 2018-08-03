$(document).ready(function(){
	$( "#add_form" ).submit(function( event ) {
		$("span").remove();
		var check=0;
		var username = $("#add_username").val().trim();
		var password = $("#add_password").val().trim();
		
		if(errorUsername(username)){
			check+=1;
			$("#username_div").append($("<span>"+error1+"</span>"));
		 }
		if(errorPass(password)){
			check+=1;
			$("#password_div").append($("<span>"+error2+"</span>"));
		 }
		if(check!=0){
			event.preventDefault();
		}else{
			$("#username").val(username);
			$("#password").val(password);
		}
	});
	
	function errorUsername(username){
		if(username == ""){
			error1 = "Username can't be blank";
			return true;
		}
		if(username.length > 20){
			error1 = "Username can't be over 20 characters!";
			return true;
		}
		return false;
	}
	
	function errorPass(password){
		if(password == ""){
			error2 = "Password can't be blank";
			return true;
		}
		if(password.length > 20){
			error2 = "Password can't be over 20 characters!";
			return true;
		}
		return false;
	}
});