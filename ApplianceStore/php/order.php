<?php
// Insert the path where you unpacked log4php
include('..\apache-log4php-2.3.0\src\main\php\Logger.php');

// Tell log4php to use our configuration file.
Logger::configure('config.xml');

// Fetch a logger, it will inherit settings from the root logger
$log = Logger::getLogger('ApplianceStoreLogger');

$selected=array();
$selected = $_POST["selected"]; //pulls value of radio button
$columns = array('ApplianceName','Description','Configuration','Price');
if(array_key_exists("userDetails",$_POST)) {
	$userExists = false;
	$buildingNum=$_POST["userDetails"]["buildingNum"];
	$street=$_POST["userDetails"]["street"];
	$apartment=$_POST["userDetails"]["apartment"];
}
else {
	$userExists = true;
}
foreach($columns as $column) {
	$$column = $selected[$column];
}
$servername = 'localhost';
$username = 'root';
$password = '';

session_start();
if (isset($_SESSION['phoneNum']))
	{
		$phoneNum = $_SESSION['phoneNum'];
		$log->info("Extracting the user session info.");

		try {
			$dbh = new PDO('mysql:host=localhost;port=3307;dbname=applicationstore', $username, $password);
			$log->info("Connection is established with the database.");
				$log->info("Checking if the user is present in the database.");
				if($userExists) {
					$log->info("Checking if any pending order exists with the chosen appliance.");
					$stmt2= $dbh->prepare('select * from orders where configuration= ? and aname=? and phone=? and status="pending" ;');
					$stmt2->execute(array($Configuration,$ApplianceName,$phoneNum));
					$pendingOrderExists = $stmt2->rowCount()>0;
					if($pendingOrderExists) {
						$stmt3= $dbh->prepare('update orders set quantity=quantity+1,o_time=now(),price=price+? where configuration= ? and aname=? and phone=? and status="pending" ;');
						if($stmt3->execute(array(intval($Price),$Configuration,$ApplianceName,$phoneNum))) {
							$log->info("Update to the orders table with the existing user successful");
							echo "Successful";
						}
						else {
							$log->error("Update to the orders table with the existing user failed");
							echo "Failed";
						}
					} else {
						$stmt5= $dbh->prepare('insert into orders values(?,?,?,now(),1,?,"pending");');
						if($stmt5->execute(array($phoneNum,$ApplianceName,$Configuration,intval($Price)))) {
							$log->info("Insertion to the orders table with the existing user successful");
							echo "Successful";
						}
						else {
							$log->error("Insertion to the orders table with the existing user unsuccessful");
							echo "Failed";
						}
					}




				}
				else {
					$insertUser= $dbh->prepare('insert into customer values(?,?,?,?);');
					if($insertUser->execute(array($phoneNum,$buildingNum,$street,$apartment))) {
						$log->info("Insertion of the user to the customers table successful");
						$stmt6= $dbh->prepare('insert into orders values(?,?,?,now(),1,?,"pending");');
						if($stmt6->execute(array($phoneNum,$ApplianceName,$Configuration,intval($Price)))) {
							$log->info("Insertion of the order into the orders table of the new user successful");
							echo "Successful";
						}
						else {
							$log->error("Insertion of the order into the orders table of the new user unsuccessful");
							echo "Failed";
						}
					}
					else {
						$log->error("Insertion of the user to the customers table unsuccessful");
						echo "Failed";
					}
				}

			$dbh = null;
		} catch (PDOException $e) {
			$log->error("Error!: " . $e->getMessage());
			echo "Error!: " . $e->getMessage() . "<br/>";
			die();
		}

	}
else
	echo "Invalid user";
	$log->error("User session not set.");


?>
