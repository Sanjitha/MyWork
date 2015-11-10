

function fetchData() {
	//var xhttp = new XMLHttpRequest();	
	keyword=document.getElementById("name").value;
	phoneNum=document.getElementById("phoneNum").value;
	/*var params = "phoneNum="+phoneNum+"&keyword="+keyword;
	xhttp.open("POST", "process.php", true);
	xhttp.onreadystatechange = function() {
		alert(xhttp.readyState);
		alert(xhttp.statusText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			alert("hello");
			alert(xhttp.responseText);
			//document.getElementById("demo").innerHTML = xhttp.responseText;
		}
	}
	xhttp.send(params);*/
	
	alert("hello");
	$.get( "process.php",function( data ) {
		alert(data);	
	},json)	
	.fail(function() {
		alert( "error" );
	});
}