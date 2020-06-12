$(document).ready(function(){

  var error_email=false;

    $('#newPassword').focusout(function(){
      email_validate();
    });

        function email_validate() {

          var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
          var email = $('#newPassword').val();
    
            if(email !== '') {
              if(pattern.test(email)) {
              $('#lblPassword').css('color','green');
              $('#heading').css('color','green');  
              $('#newPassword').css('border','2px solid green'); 
              $('#success').css('display','block');
              $('#error').css('display','none');
              $('#span1').css('display','none');
              $('#span2').css('display','none');
              $('#warning').css('display','none');
              }
              else {
              $('#lblPassword').css('color','red');
              $('#heading').css('color','red');  
              $('#newPassword').css('border','2px solid red'); 
              $('#error').css('display','block');
              $('#success').css('display','none');
              $('#span1').css('display','block');
              $('#span2').css('display','none');
              $('#warning').css('display','none');
              error_email=true;
              }
            }
          else {
            $('#span2').css('display','block');
            $('#lblPassword').css('color','orange');
            $('#heading').css('color','orange');
            $('#newPassword').css('border','2px solid orange'); 
            $('#error').css('display','none');
            $('#success').css('display','none');
            $('#warning').css('display','block');
            $('#span1').css('display','none');
            error_email=true;
          }
        }

        $("#registration_form").submit(function()
        {
          error_email=false;

          email_validate();

          if(error_email===false)
          {
            alert("Registration Successfull");
            return true;
          }
          else
          {
             alert("PLEASE FILL THE FORM CORRECTLY");
             return false;
          }
        })
    });