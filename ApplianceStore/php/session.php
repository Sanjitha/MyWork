<?php

		// Insert the path where you unpacked log4php
		include('..\apache-log4php-2.3.0\src\main\php\Logger.php');

		// Tell log4php to use our configuration file.
		Logger::configure('..\config.xml');

		// Fetch a logger, it will inherit settings from the root logger
		$log = Logger::getLogger('ApplianceStoreLogger');

		session_start();
		$_SESSION['phoneNum'] = $phoneNum;
		$log->info("Starting the user session.");

?>
