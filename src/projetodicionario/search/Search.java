/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.search;

import projetodicionario.tools.Tools;

/**
 *
 * @author pedro
 */
public class Search {

    Tools tool = new Tools();

    public int sequential(String[] vetor, String palavraBuscada) throws Exception {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equalsIgnoreCase(palavraBuscada)) {
                return i;
            }
        }
        return -1;
    }

    public int binary(String[] palavra, String palavraBuscada, int inicio, int fim) throws Exception {
        if (inicio > fim) {
            return -1;
        }

        int meio = (inicio + fim) / 2;
        if (palavraBuscada.length() == palavra[meio].length()) {
            if (palavraBuscada.equals(palavra[meio])) {
                return meio;
            } else {
                int i = meio;
                while (palavraBuscada.length() == palavra[i].length()) {
                    i++;
                    if (palavraBuscada.equals(palavra[i])) {
                        return i;
                    }
                }
                i = meio;
                while (palavraBuscada.length() == palavra[i].length()) {
                    i--;
                    if (palavraBuscada.equals(palavra[i])) {
                        return i;
                    }
                }
            }
        } else if (palavraBuscada.length() < palavra[meio].length()) {
            return binary(palavra, palavraBuscada, inicio, (meio - 1));
        } else {
            return binary(palavra, palavraBuscada, (meio + 1), fim);
        }

        return -1;
    }
}
