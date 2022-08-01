<?php

require "../database.php";
	
$requestMethod = $_SERVER["REQUEST_METHOD"];	
	
if($requestMethod == "GET"){

	if(count($_GET) == 1 && isset($_GET["id"])){
		getPassengerById();
	}
	else{
		getAllPassengers();
	}
	
}
elseif($requestMethod == "POST"){
	insertPassenger();
}	
elseif($requestMethod == "PUT"){
	
}
elseif($requestMethod == "DELETE"){
	
}	

//For Normal GET Request
function getAllPassengers()
{
	$database = new Database();							//contruct db object
	$connection = $database->getConnection();			//get db object's connection
	$sql = "SELECT * FROM Passenger";					//create SQL statement
	$statement = $connection->prepare($sql);			//get ready to execute SQL statement
	$statement->execute();								//executre SQL statement
	$results = array();									//create a results array that will store the results table
	while($row = $statement->fetch(PDO::FETCH_ASSOC)){	//use loop to fetch and copy every record of the results table into the results array
		$results[] = $row;		
	}
	echo(json_encode($results));						//output array as a set of JSON objects
}

//For POST Request 
function insertPassenger(){
	$json = file_get_contents("php://input");	//get JSON out of body
	$data = json_decode($json, true);			//turn JSON into an array
	$database = new Database();					//connnect with database
	$connection = $database->getConnection();
	$sql = "INSERT INTO Passenger (first_name, last_name, passport_number, birthdate, city, state) 
				VALUES (:first_name, :last_name, :passport_number, :birthdate, :city, :state)";
	$statement = $connection->prepare($sql);															//prepare SQL query
	$statement->execute([																				//execute SQL query
		':first_name' => $data['first_name'],
		':last_name' => $data['last_name'],
		':passport_number' => $data['passport_number'],
		':birthdate' => $data['birthdate'],
		':city' => $data['city'],
		':state' => $data['state']
	]);
	echo($connection->lastInsertId());																	//output the new record's id
}	

//For @Query GET Request
function getPassengerById(){
	
	$database = new Database();
	$connection = $database->getConnection();
	$sql = "SELECT * FROM Passenger WHERE id = :id";
	$statement = $connection->prepare($sql);
	$statement->execute([ 
	    ':id' => $_GET['id']
	]);
	$result = $statement->fetch(PDO::FETCH_ASSOC);
	echo(json_encode($result));
	
}

?>