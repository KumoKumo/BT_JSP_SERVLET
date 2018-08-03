$(document).ready(function(){
	$( "#loginForm" ).submit(function( event ) {
		$("span").remove();
		var check=0;
		var username = $("#username").val().trim();
		var password = $("#password").val().trim();
		if(errorUsername(username)){
			check+=1;
			$("#username_div").append($("<span>"+error+"</span>"));
		 }
		if(password == "" ){
			check+=1;
			$("#password_div").append($("<span>Password can't be blank!</span>"));
		 }
		if(check!=0){
			event.preventDefault();
		}
	});
	
	function errorUsername(username){
		if(username == ""){
			error = "Username can't be blank";
			return true;
		}
		if(username.length > 20){
			error = "Username can't be over 20 characters!";
			return true;
		}
		return false;
	}
});