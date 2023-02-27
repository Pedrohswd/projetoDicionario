/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.ordination;

import projetodicionario.tools.Tools;

/**
 *
 * @author pedro
 */
public class Ordenation {

    public String[] selectionSort(String[] palavra) {
         Tools tools = new Tools();
        for (int i = 0; i < palavra.length - 2; i++) {
            int indicador = i;

            for (int p = i + 1; p < palavra.length - 1; p++) {
                String palavraIndicador = palavra[indicador];
                int palavraIndic = tools.characterCounter(palavraIndicador);
                int palavraP = tools.characterCounter(palavra[p]);
                if (palavraP < palavraIndic) {
                    indicador = p;
                }
            }
            String menorPalavra = palavra[indicador];
            palavra[indicador] = palavra[i];
            palavra[i] = menorPalavra;
        }

        return palavra;
    }

    public String[] insertionSort(String[] palavra) {
        return palavra;
    }

    public String[] mergeSort(String[] palavra) {
        return palavra;
    }

    public String[] quickSort(String[] palavra) {
        return palavra;
    }

}
