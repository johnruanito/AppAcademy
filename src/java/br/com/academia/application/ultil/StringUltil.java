/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.application.ultil;

import java.util.Calendar;

/**
 *
 * @author Ruan
 */
public class StringUltil {
    
    public static boolean isEmpty(String s){
        
        if (s==null) {
            return true;
        }
        
        return s.trim().length()==0;
        
    }
   
    public static String leftYear(int day){
        
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + Integer.toString(Calendar.getInstance().get(Calendar.MONTH)+1)+ day;
        
    }
     
    public static String leftZeroes(int value, int finalSize) {
		return String.format("%0" + finalSize + "d", value);
	}
	
	public static void main(String[] args) {
		String str = "  a   ";
		
		boolean b = StringUltil.isEmpty(str);
		System.out.println(b);
		
		int v = 12345;
		System.out.println(StringUltil.leftZeroes(v, 8));
	}
            
    }
   
    

