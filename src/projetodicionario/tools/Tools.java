/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.tools;

/**
 *
 * @author aluno
 */
public class Tools {

    public int characterCounter(String palavra) {
        int tamanho= 0;

        for (int i = 0; i < palavra.length(); i++) {
            if (Character.isLetter(palavra.charAt(i))) {
                tamanho++;
            }
        }

        return tamanho;
    }

}
