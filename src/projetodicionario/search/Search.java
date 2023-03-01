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

    public int sequential(String[] vetor, String word) throws Exception {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equalsIgnoreCase(word)) {
                return i;
            }
        }
        return -1;
    }

    public int binary(String[] palavra, String word, int start, int end) throws Exception {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (word.length() == palavra[middle].length()) {
            if (word.equals(palavra[middle])) {
                return middle;
            } else {
                int i = middle;
                while (word.length() == palavra[i].length()) {
                    i++;
                    if (word.equals(palavra[i])) {
                        return i;
                    }
                }
                i = middle;
                while (word.length() == palavra[i].length()) {
                    i--;
                    if (word.equals(palavra[i])) {
                        return i;
                    }
                }
            }
        } else if (word.length() < palavra[middle].length()) {
            return binary(palavra, word, start, (middle - 1));
        } else {
            return binary(palavra, word, (middle + 1), end);
        }

        return -1;
    }
}
