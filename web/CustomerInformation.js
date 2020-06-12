$(document).ready(function()
{
    $('#productname_text').hide();
    $('#productbrand_text').hide();
    $('#barcode_text').hide();
    $('#cp_text').hide();
    $('#sellingprice_text').hide();
    $('#minimumprice_text').hide();
    $('#maximumprice_text').hide();
    $('#productquantity_text').hide();
    $('#qualityrating_text').hide();
    $('#manufacturingdate_text').hide();
    $('#expiredate_text').hide();

    var firstname=false;
    var mobile=false;
    var barcode=false;
    var cp=false;
    var sellingprice=false;
    var minimumprice=false;
    var maximumprice=false;
    var productquantity=false;
    var qualityrating=false;
    var manufacturing=false;
    var expriredate=false;

    $('#firstname').focusout(function()
    {
        validate_firstname();
    });

    $('#mobile').focusout(function()
    {
        validate_mobile();
    });

    $('#email').focusout(function()
    {
        validate_email();
    });

    $('#dateofbirth').focusout(function()
    {
        validate_dateofbirth();
    });

    $('#state').focusout(function()
    {
        validate_state();
    });

    $('#country').focusout(function()
    {
       validate_country();
    });

    $('#pincode').focusout(function()
    {
        validate_pincode();
    });

    // 1 - PRODUCT NAME
    function validate_firstname()
    {
        var product=$("#firstname").val();

        if(product !== '')
        {
           $("#firstname").css('border','2px solid green');
           $('#span1').css('display','block');
           $('#span2').css('display','none');
        }
        else
        {
           $("#firstname").css('border','2px solid red');
           $('#span1').css('display','none');
           $('#span2').css('display','block');
        }
    }

    //  2 - PRODUCT BRAND
    function validate_mobile()
    {
        var product=$("#mobile").val();

        if(product !== '')
        {
           $("#mobile").css('border','2px solid green');
           $('#span3').css('display','block');
           $('#span4').css('display','none');
        }
        else
        {
           $("#mobile").css('border','2px solid red');
           $('#span3').css('display','none');
           $('#span4').css('display','block');
        }
    }

    //  3 - BARCODE
    function validate_email()
    {
        var product=$("#email").val();

        if(product !== '')
        {
           $("#email").css('border','2px solid green');
           $('#span5').css('display','block');
           $('#span6').css('display','none');
        }
        else
        {
           $("#email").css('border','2px solid red');
           $('#span5').css('display','none');
           $('#span6').css('display','block');
        }
    }

    //   4 - COST PRICE  
    function validate_dateofbirth()
    {
        var product=$("#dateofbirth").val();

        if(product !== '')
        {
           $("#dateofbirth").css('border','2px solid green');
           $('#span7').css('display','block');
           $('#span8').css('display','none');
        }
        else
        {
           $("#dateofbirth").css('border','2px solid red');
           $('#span7').css('display','none');
           $('#span8').css('display','block');
        }
    }
    
    //  5 - SELLING PRICE
    function validate_state()
    {
        var product=$("#state").val();

        if(product !== '')
        {
           $("#state").css('border','2px solid green');
           $('#span9').css('display','block');
           $('#span10').css('display','none');
        }
        else
        {
           $("#state").css('border','2px solid red');
           $('#span9').css('display','none');
           $('#span10').css('display','block');
        }
    }
    
    //  6 - MINIMUM PRICE
    function validate_country()
    {
        var product=$("#country").val();

        if(product !== '')
        {
           $("#country").css('border','2px solid green');
           $('#span11').css('display','block');
           $('#span12').css('display','none');
        }
        else
        {
           $("#country").css('border','2px solid red');
           $('#span11').css('display','none');
           $('#span12').css('display','block');
        }
    }
    
    //  7 - MAXIMUM PRICE
    function validate_pincode()
    {
        var product=$("#pincode").val();

        if(product !== '')
        {
           $("#pincode").css('border','2px solid green');
           $('#span13').css('display','block');
           $('#span14').css('display','none');
        }
        else
        {
           $("#pincode").css('border','2px solid red');
           $('#span13').css('display','none');
           $('#span14').css('display','block');
        }
    }
    

});