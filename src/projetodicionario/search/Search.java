/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.search;

/**
 *
 * @author pedro
 */
public class Search {
     public static boolean BuscaSequencial(String[] vetor, String palavraBuscada) {

        int i;
        for (i = 0; i < vetor.length; i++) {
            if (palavraBuscada == vetor[i]) {
                return true;
            }
        }
        return false;
     }
    
}
