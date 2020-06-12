$(document).ready(function(){
    
    var error_username;

  $('#username').focusout(function(){
    email_validate();
  });

      function email_validate() {

        var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        var email = $('#username').val();
  
          if(email !== '') {
            if(pattern.test(email)) 
            {
            $('#username').css('border','2px solid green'); 
            $('#success').css('display','block');
            $('#error').css('display','none');
            $('#span1').css('display','none');
            $('#span2').css('display','none');
            $('#warning').css('display','none');
            error_username=false;
            }
            else
            {
            $('#username').css('border','2px solid red'); 
            $('#error').css('display','block');
            $('#success').css('display','none');
            $('#span1').css('display','block');
            $('#span2').css('display','none');
            $('#warning').css('display','none');
            error_username=true;
            }
          }
        else {
          $('#span2').css('display','block');
          $('#username').css('border','2px solid orange'); 
          $('#error').css('display','none');
          $('#success').css('display','none');
          $('#warning').css('display','block');
          $('#span1').css('display','none');
          error_username=true;
        }
      }
      
      
      $("#registration_form").submit(function()
      {
          error_username=false;
          
          email_validate();
          
       if (error_username === false )
            {
             //  alert("Registration Successfull");
               return true;
            }
            else
            {
               alert("Please Fill the form Correctly");
               return false;
            }
      });  
      
  });


/*
function validate()
{
    var username=document.getElementById("username").value;
    var regx=/^([a-z 0-9\.-]+)@([a-z0-9]+).([a-z]{2,8})(.[a-z]{2,8})?$/;
    
    // var regx=/E00/i;    //=/[abcd]efgh/; =/[a-x A-X]00/; =/[0-5]00/;
    /*
       \d match any digit (equal to [0-9])
       \w match any word character (a-z,A-Z,0-9 & )
       \s match whilespace character(eg-spaces & labs)
       \t match a tab only

       // EMAIL VALIDATION
       var regx=/^([a-z 0-9\.-]+)@([a-z0-9]+).([a-z]{2,8})(.[a-z]{2,8})?$/;
    
    if(regx.test(username))
    {
        alert("Valid Username");
    }
    else
    {
    //  alert("Invalid Username");
      document.getElementById("username").style.border="solid red 3px";
      document.getElementById("lbluser").style.visibility="visible";
    }
}
*/