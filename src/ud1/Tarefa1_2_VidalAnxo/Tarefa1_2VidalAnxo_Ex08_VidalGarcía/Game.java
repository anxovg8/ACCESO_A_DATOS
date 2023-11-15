/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2VidalAnxo_Ex08_VidalGarcía;

import java.io.Serializable;

/**
 *
 * @author node
 */
public class Game implements Serializable{
    private static final int LIMITE_ERRORES=6;
    private static String state;
    private static int errors;
    private static String[] secretWord;
    private static String[] letrasDichas;
    
    
    public static void compararLetras(String letra){
        if(secretWord.equals(letra)){
            for(int i=0;secretWord.length<i;i++){
                secretWord[i] += letra;
                letrasDichas[i]=letra;
            }
        }
    }
    
        
    
    
    
    
}
