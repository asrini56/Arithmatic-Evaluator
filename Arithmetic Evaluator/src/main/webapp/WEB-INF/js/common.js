function sendAjaxRequest(url, successCallBackFn) {
	$.ajax({
		url:url, 
		success: successCallBackFn,
		statusCode: {
		    419: function() {
		    	showPage("");
		    }
		},
		error: function(){
			alert("Unable to process your request.");
		}
	});
}


function checkAndAlertError(message) {
	if(message.includes("fail") || message.includes("error")) {
		alert(message);
	}
}