/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.application.ultil;

/**
 *
 * @author Ruan
 */
public class Validation {
    
    public static void  assertNotEmpty(Object obj){
        if (obj instanceof String) {
            String s = (String) obj;
            if(StringUltil.isEmpty(s)){
                throw new ValidationException("O texto nao pode ser nulo");
            }
        }
        if(obj==null){
            throw new ValidationException("Valor nao pode ser nulo");
        }
        
        
    }
    
    
}
