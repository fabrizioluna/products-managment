package com.products.management.utils;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime; 

public class CurrentDate {    
    public static String now() {    
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
     LocalDateTime current = LocalDateTime.now();  
     return dtf.format(current);  
    }

    public static Date nowDate() {      
     return new Date();  
    }    
  }   
