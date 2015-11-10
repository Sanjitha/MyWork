<?php

// Insert the path where you unpacked log4php
include('..\apache-log4php-2.3.0\src\main\php\Logger.php');

// Tell log4php to use our configuration file.
Logger::configure('..\config.xml');

// Fetch a logger, it will inherit settings from the root logger
$log = Logger::getLogger('ApplianceStoreLogger');

$keyword = $_GET["keyword"]; //pulls value of radio button
$phoneNum = $_GET["phoneNum"]; //pulls value of radio button

$servername = 'localhost';
$username = 'root';
$password = '';

session_start();
$_SESSION['phoneNum'] = $phoneNum;
$log->info("Storing the session variable 'phoneNum' ");

try {
    $dbh = new PDO('mysql:host=localhost;port=3307;dbname=applicationstore', $username, $password);
	$log->info("Connection is established with the database.");
	$stmt= $dbh->prepare('Select T2.aname as ApplianceName , T2.description as Description,T1.config as Configuration ,T1.price as Price from catalog as T1 natural join (SELECT * FROM appliance where description like ? ) as T2');
	$data = array();
	$columns = array('ApplianceName','Description','Configuration','Price');
	$stmt->execute(array("%$keyword%"));
	$log->info("Fetched the appliance details from the database.");
	$isNotEmpty = $stmt->rowCount()>0;

	if($isNotEmpty) {
		$results = $stmt->fetchAll();
		foreach ($results as $row ) {
			 $tmp = array();
			 foreach($columns as $column ) {
				$tmp[$column] = $row[$column];
			 }
			 $data[]=$tmp;
		}
		echo json_encode($data);
	}
	else {
		$log->info("No such appliance.");
		echo "No such Appliance.";
	}
	$stmt = null; // doing this is mandatory for connection to get closed
    $dbh = null;
} catch (PDOException $e) {
    echo "Error!: " . $e->getMessage() . "<br/>";
	$log->error("Error!: " . $e->getMessage() . "<br/>");
}
?>
