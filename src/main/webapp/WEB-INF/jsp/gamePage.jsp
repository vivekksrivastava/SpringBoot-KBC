<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1); 
%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<title>
Kaun Banega Crorepati
</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<style>
.divrow {
    font-size: 17px !important;
    font-weight: bold;
     border-style: solid;
    border-width: 1px;
    border-color: black;
    border-radius: 25px;
}
.divcol {
    font-size: 17px !important;
    border-style: solid;
    border-width: 1px;
    border-color: black;
    border-radius: 35px;
}
.divcolAmount {
    font-size: 17px !important;
    border-style: solid;
    border-width: 1px;
    border-color: black;
    border-radius: 35px;
    text-align : center;
}
.divcol:hover{
background-color : yellow;
}
.count{
padding: 3px; 
border: 1px solid black; 
margin-top: 100px;
padding: 20px;
border-radius: 35px;
text-align: center;
}
/* Standard syntax */
@keyframes failure {
    0%   {background-color: red;}
    25%  {background-color: yellow;}
    50%  {background-color: red;}
    100% {background-color: yellow;}
}
@keyframes success {
    0%   {background-color: green;}
    25%  {background-color: yellow;}
    50%  {background-color: green;}
    100% {background-color: yellow;}
}
.animationFailure{
 	-webkit-animation-duration: 1s;
	-webkit-animation-name : failure;
	 animation-duration : 1s;
}
.animationSuccess{
 	-webkit-animation-duration: 1s;
	-webkit-animation-name : success;
	 animation-duration : 1s;
}
.backgroundGreen{
background-color:#1aff1a;
color : white;
}

</style>
<u><h1><center>KAUN BANEGA CROREPATI</center></h1></u>
<div class="container" ng-app="myApp" ng-controller="myCtrl">
<div class="col-sm-2">
<div ng-repeat="x in amount | orderBy: reverse:true">
<div class="row">
<div class="col-sm-9 divcolAmount" id='id{{x}}'>{{x}}</div>
</div>
</div>

</div>
<div class="col-sm-10">

<div class="" style="margin-top: 50px">
<div class=""> 

<div class="row">
  <div class="col-sm-12 divrow">Question {{Qid}}: {{Question}}</div>
</div>
<br/>
<div class="row">
  <div id="OptionA" class="col-sm-5 btn-default divcol" ng-click="validate(OptionA,'OptionA')" >A. {{OptionA}}</div>
  <div class="col-sm-2"></div>
  <div id="OptionB" class="col-sm-5 btn-default divcol"  ng-click="validate(OptionB,'OptionB')" >B. {{OptionB}}</div>
</div>
<div class="row" style="padding:3px"></div>
<div class="row">
  <div id="OptionC" class="col-sm-5 btn-default divcol"  ng-click="validate(OptionC,'OptionC')" >C. {{OptionC}}</div>
  <div class="col-sm-2"></div>
  <div id="OptionD" class="col-sm-5 btn-default divcol"  ng-click="validate(OptionD,'OptionD')" >D. {{OptionD}}</div>
</div>


<div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-4 count"><b>Current Amount : Rs. {{score}}</b> </div>
  <div class="col-sm-4"></div>
</div>

</div>
</div>
</div>

<script>

function redirect(x){
	console.log("inside redirect function");
	window.location.href = "http://localhost:8080/showFinalScore?score="+x;
}

var app = angular.module('myApp', []);


app.controller('myCtrl', function($scope, $http, $timeout) {
	
	$scope.amount=[5000, 10000, 20000, 40000, 80000, 160000, 320000, 640000, 1250000, 2500000, 5000000, 10000000];
	
	
  $http.get("http://localhost:8080/retrieveQuestion")
  .then(function(response) {
	  $scope.Qid = response.data.id;
      $scope.Question = response.data.questionString;
      if($scope.Qid == "")
    	  {
      $scope.OptionA = "";
      $scope.OptionB = "";
      $scope.OptionC = "";
      $scope.OptionD = "";
      $scope.correctAnswer = "";
    	  }
      else
    	  {
    	  $scope.OptionA = response.data.options[0];
          $scope.OptionB = response.data.options[1];
          $scope.OptionC = response.data.options[2];
          $scope.OptionD = response.data.options[3];
          $scope.correctAnswer = response.data.correctAnswer;
    	  }
  });
  
  $scope.score = 5000;
  
  $scope.validate = function(x,y){
	  
	  
	  if( $scope.correctAnswer == x)
		  {
		  angular.element(document.querySelector("#"+y)).addClass("animationSuccess");
		  $timeout(function () {
			  angular.element(document.querySelector("#"+y)).removeClass("animationSuccess");
		    }, 1000);
		  
		  angular.element(document.querySelector("#id"+$scope.amount[$scope.Qid-1])).addClass("backgroundGreen");
		  
		  $scope.score = $scope.amount[$scope.Qid];
		  if($scope.Qid < 12)
			$http.get("http://localhost:8080/retrieveQuestion")
		  .then(function(response) {
			  $scope.Qid = response.data.id;
		      $scope.Question = response.data.questionString;
		      if($scope.Qid == null || $scope.Qid == "")
		    	  {
		      $scope.OptionA = "";
		      $scope.OptionB = "";
		      $scope.OptionC = "";
		      $scope.OptionD = "";
		      $scope.correctAnswer = "";
		    	  }
		      else
		    	  {
		    	  $scope.OptionA = response.data.options[0];
		          $scope.OptionB = response.data.options[1];
		          $scope.OptionC = response.data.options[2];
		          $scope.OptionD = response.data.options[3];
		          $scope.correctAnswer = response.data.correctAnswer;
		    	  }
		  });
		  else
			  redirect($scope.amount[$scope.Qid-1]);
		  
		  }
	  else{
	  angular.element(document.querySelector("#"+y)).addClass("animationFailure");
	  $timeout(function () {
		  angular.element(document.querySelector("#"+y)).removeClass("animationFailure");
	    }, 1000);
	  if($scope.Qid-1 == 0)
		  redirect(0);
	  else
	  redirect($scope.amount[$scope.Qid-2]);
	  }
  };
});

</script>
</body>
</html>

