<%@ page language="java"  isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(event) {
  $("#country").change(function() {
 $("#state").find("option").remove();
 $('<option>').val(" ").text("--Select State--").appendTo('#state');
  $("#city").find("option").remove();
  $('<option>').val(" ").text("--Select City--").appendTo('#city');
  var country =  $("#country").val();
  $.ajax({
  url: "getStates?cid="+country,
  type : "GET",
  success : function(data){
  $.each(data,function(key,val){
  $('<option>').val(key).text(val).appendTo('#state');
  });
  }
  });
});

 $("#state").change(function() {
 $("#city").find("option").remove();
 $('<option>').val(" ").text("--Select City--").appendTo('#city');
  var state =  $("#state").val();
  $.ajax({
  url: "getCities?sid="+state,
  type : "GET",
  success : function(data){
  $.each(data,function(key,val){
  $('<option>').val(key).text(val).appendTo('#city');
  });
  }
  });
});  
});
</script>
</head>
<body>
     <h1 style = "text-align:center;color:red">Registration Form</h1>
     <form:form method="POST" action="#" modelAttribute="register">
     <table border="1" align = "center">
     <tr>
     <td>First Name::</td>
     <td><form:input path="firstName"  placeholder = "Enter first Name"/></td>
     </tr>
     <tr>
     <td>Last Name::</td>
     <td><form:input path="lastName" placeholder = "Enter Last Name" /></td>
     </tr>
     <tr>
     <td>Email::</td>
     <td><form:input path="email" placeholder = "Enter Email"/></td>
     </tr>
     <tr>
     <td>PhoneNumber::</td>
     <td><form:input path="phoneNum" placeholder = "Enter PhoneNumber"/></td>
     </tr>
     <tr>
     <td>Gendar::</td>
     <td><form:radiobuttons path="gendar" items="${gendar}"/></td>
     </tr>
      <tr>
     <td>Country::</td>
     <td><form:select path="country" >
     <form:option value="">--Select Country--</form:option>
     <form:options items="${countryMap}" />
     </form:select>
     </td>
     </tr>
      <tr>
     <td>State::</td>
     <td><form:select path="state">
     <form:option value="">--Select State--</form:option>
     </form:select>
     </td>
     </tr>
        <tr>
     <td>City::</td>
     <td><form:select path="city">
     <form:option value="">--Select City--</form:option>
     </form:select>
     </td>
     </tr>
     <tr>
     <td align="center"><input type="submit" value="Register"></td>
      <td align="center"><input type="reset" value="Reset"></td>
     </tr>
     </table>
     </form:form>
</body>
</html>