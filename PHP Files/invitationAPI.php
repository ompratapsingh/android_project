<?php
	include('config.php');
		
	    $json = file_get_contents('php://input');
        $obj = json_decode($json);
	    $ActionId=$obj->actionId;
	  
		switch($ActionId) {
			case 1: 
				$name = $obj->Name;
				$mobile = $obj->mobile;
				$merriageId = $obj->merriageId;
                $deviceId=$obj->deviceId;   
				$insert=mysqli_query($con,"insert into signup(name,mobileNumber,merriageId,deviceId) values('$name','$mobile','$merriageId','$deviceId')"); 
				$result = array();
				if($insert){
					$sql="SELECT LAST_INSERT_ID()";
					$data=mysqli_query($con,$sql);
					$res = mysqli_fetch_array($data);
					array_push($result,array(
					"user_id"=>$res['LAST_INSERT_ID()'],
					"status"=>1));	
				} else {
					array_push($result,array(
					"status"=>0));
				}
				echo json_encode(array("result"=>$result));
			break;
			case 2: //save wishesh
				
				$user_id = $obj->user_id;
				$message = $obj->message;
				$merriageId = $obj->merriageId;
				$insert=mysqli_query($con,"insert into userWishes(user_id,message,marriage_id) values($user_id,'$message',$merriageId)");
				$data = "insert into userWishes values('$user_id','$message','$merriageId')";
				$result = array();
				if($insert){
					array_push($result,array(
					"status"=>1));
				} else {
					array_push($result,array(
					"status"=>0));
				}
				echo json_encode($result);
			break;
			case 3: //get all wishesh
			$query="SELECT * FROM userWishes ORDER BY w_id DESC";
 			$resultQ = mysqli_query($con,$query);
			$wisheshArray = array();
			while($row =mysqli_fetch_assoc($resultQ))
			{
				$wisheshArray[] = $row;
			}
			echo json_encode($wisheshArray);
			break;
			case 4: // save acception 
				$user_id = $obj->user_id;
				$isAcception = $obj->isAcception;
				$insert=mysqli_query($con,"insert into acception(user_id,isAccept) values($user_id,$isAcception)");
				$result = array();
				if($insert){
					array_push($result,array(
					"status"=>1));	
				} else {
					array_push($result,array(
					"status"=>0));
				}
				echo json_encode($result);	
			break;
			default: // default case
				echo "default";
			break;
		}
		
			
		//echo json_encode($data);
	
?>

