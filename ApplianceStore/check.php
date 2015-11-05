<?php

$servername = 'localhost';
$username = 'root';
$password = '';

session_start();
if (isset($_SESSION['phoneNum']))
	{
		$phoneNum = $_SESSION['phoneNum'];
		//echo $phoneNum;
		
		//check if the user is present in the database and check if there are any existing orders that are pending
		try {
			$dbh = new PDO('mysql:host=localhost;port=3307;dbname=applicationstore', $username, $password);
			
			$stmt1= $dbh->prepare('Select * from customer where phone = ? ;');
			$stmt1->execute(array($phoneNum));
			$userExists = $stmt1->rowCount()>0;
			$stmt1 = null; 
				if($userExists) {
					echo "Existing user";					
				}
				else {
					echo "New User";
				}
			
			$dbh = null;
		} catch (PDOException $e) {
			echo "Error!: " . $e->getMessage() . "<br/>";
			die();
		}
		
	}
else 
	echo "Invalid user";


?>