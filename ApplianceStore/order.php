<?php

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
		//echo $phoneNum;
		
		//check if the user is present in the database and check if there are any existing orders that are pending
		try {
			$dbh = new PDO('mysql:host=localhost;port=3307;dbname=applicationstore', $username, $password);
			
			//$stmt1= $dbh->prepare('Select * from customer where phone = ? ;');
			//$stmt1->execute(array($phoneNum));
			//$userExists = $stmt1->rowCount()>0;
			//$stmt1 = null; 
				if($userExists) {
					//check if pending order exists in table 
					
					$stmt2= $dbh->prepare('select * from orders where configuration= ? and aname=? and phone=? and status="pending" ;');
					$stmt2->execute(array($Configuration,$ApplianceName,$phoneNum)); 
					$pendingOrderExists = $stmt2->rowCount()>0;
					if($pendingOrderExists) {
						$stmt3= $dbh->prepare('update orders set quantity=quantity+1,o_time=now(),price=price+? where configuration= ? and aname=? and phone=? and status="pending" ;');
						if($stmt3->execute(array(intval($Price),$Configuration,$ApplianceName,$phoneNum))) {
							//echo "Update successful";
							echo "Successful";
						}
						else {
							//echo "Update Failed";
							echo "Failed";
						}
					} else {
						$stmt5= $dbh->prepare('insert into orders values(?,?,?,now(),1,?,"pending");');
						if($stmt5->execute(array($phoneNum,$ApplianceName,$Configuration,intval($Price)))) {
							//echo "Insertion of order successfull";
							echo "Successful";
						}
						else {
							//echo "Insertion of order unsuccessfull";
							echo "Failed";
						}
					}
					
					
					
					
				}
				else {
					$insertUser= $dbh->prepare('insert into customer values(?,?,?,?);');
					if($insertUser->execute(array($phoneNum,$buildingNum,$street,$apartment))) {
						//echo "Insertion of user successfull.";
						$stmt6= $dbh->prepare('insert into orders values(?,?,?,now(),1,?,"pending");');
						if($stmt6->execute(array($phoneNum,$ApplianceName,$Configuration,intval($Price)))) {
							//echo "Insertion of order successfull";
							echo "Successful";
						}
						else {
							//echo "Insertion of order unsuccessfull";
							echo "Failed";
						}
					}
					else {
						//echo "Insertion of user failed.";
						echo "Failed";
					}
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