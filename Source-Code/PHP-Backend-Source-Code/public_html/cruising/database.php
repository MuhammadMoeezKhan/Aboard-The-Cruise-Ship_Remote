<?php
class Database{
	
	private $host = "alucard.csc.depauw.edu";
	private $db_name = "CruiseDBmkhan24";
	private $username = "mkhan24";
	private $password = "TeR8G6";
	private $connection;
	
	
	public function getConnection(){
		
		$this->connection = null;
		
		try{
			$connString = "mysql:host=$this->host;dbname=$this->db_name;port=3306;";
			$this->connection = new PDO($connString, $this->username, $this->password);
		}
		catch(PDOException $exception){
			echo($exception->getMessage());
		}
		return $this->connection;
		
	}
}	
?>