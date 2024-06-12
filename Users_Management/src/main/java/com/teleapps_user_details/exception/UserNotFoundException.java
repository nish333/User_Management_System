package com.teleapps_user_details.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException 
{
     public UserNotFoundException(String message) 
     {
         super(message);
     }
}
