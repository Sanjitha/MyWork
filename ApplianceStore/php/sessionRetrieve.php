<?php
	session_start();
	if (isset($_SESSION['phoneNum']))
		{
		$phoneNum = $_SESSION['phoneNum'];
		destroy_session_and_data();
		echo $phoneNum;
	}
	else 
		echo null;
?>