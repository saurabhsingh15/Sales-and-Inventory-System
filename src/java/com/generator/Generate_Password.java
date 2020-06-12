package com.generator;
import java.util.concurrent.ThreadLocalRandom;

public class Generate_Password 
{    
   public int getUserPass()
   {
 	int randomInt = ThreadLocalRandom.current().nextInt(1000,9999);
	System.out.println("Random number generated is : " + randomInt);   
        return randomInt;
   }
}