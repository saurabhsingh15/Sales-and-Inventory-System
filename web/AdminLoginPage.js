$(document).ready(function(){

  var error_username=false;
  var errror_password=false;

  $('#username').focusout(function(){
    email_validate();
  });

  $('#psd').focusout(function()
  {
    Psd_validate();
  });

      function email_validate() {

       
        var email = $('#username').val();
  
          if(email !== '') 
          {
           
            $('#username').css('border','2px solid green'); 
            $('#success').css('display','block');
            $('#error').css('display','none');
            $('#span1').css('display','none');
            $('#span2').css('display','none');
            $('#warning').css('display','none');
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

      function psd_validate()
      {
        var psd=$('#psd').val();

        if(psd!=='')
        {

        }
        else
        {
           error_password=true;
        }
      }

      $('#registration_form').submit(function()
      {
        error_username=false;
        error_password=false;

        email_validate();
        psd_validate();

       if(error_username===false && error_password===false)
       {
           // alert(" LOGIN SUCCESSFULL");
            return true;
       }
       else
       {
           alert("PLEASE FILL THE FORM CORRECTLY");
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