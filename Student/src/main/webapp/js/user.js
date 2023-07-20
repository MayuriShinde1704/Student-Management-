function validateUserDetails()
{

   let x = document.forms["myForm"]["name"].value;
   let y = document.forms["myForm"]["email"].value;
   let z = document.forms["myForm"]["marks"].value;
   let b=document.forms["myForm"]["birthdate"].value;
   let s=document.forms["myForm"]["state"].value;
   let c=document.forms["myForm"]["city"].value;
   
  if (x == "") {
   
    alert("Name must be filled out");
     return false;
   
     }
   else if (y == "") {
   
    alert("Email must be filled out");
     return false;
   
     }
    else if (z == "") {
   
    alert("Please Enter your Marks, must be filled out");
     return false;
   
     }
     
      else if (b == "") {
    alert("Please enter your Birth Date");
     return false;
     }
     
      else if (s == 0) {
    alert("Please select your State");
     return false;
     }
     
       else if (c == 0) {
    alert("Please select your City");
     return false;
     }
     
     else
      {
	       alert("Data Saved Successfully!!!!!!!!!!!!");
      }
     
   
	
}