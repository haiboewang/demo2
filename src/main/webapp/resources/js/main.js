function test() {
	alert("hi from main.js");
	$.getJSON('http://localhost:9080/web/contactUs/cityStateLookup/84111', function(cityStateZipDto) {
		alert.text(cityStateZipDto.stateCode);
	});
}

