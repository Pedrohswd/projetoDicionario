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

    public int binary(String[] array, String word, int start, int end) throws Exception {
        if (start > end) {
            throw new Exception("Element not found!");
        }

        int middle = (start + end) / 2;
        if (word.length() == array[middle].length()) {
            if (word.equals(array[middle])) {
                return middle;
            } else {
                int i = middle;
                while (word.length() == array[i].length()) {
                    i++;
                    if (word.equals(array[i])) {
                        return i;
                    }
                }
                i = middle;
                while (word.length() == array[i].length()) {
                    i--;
                    if (word.equals(array[i])) {
                        return i;
                    }
                }
            }
        } else if (word.length() < array[middle].length()) {
            return binary(array, word, start, (middle - 1));
        } else {
            return binary(array, word, (middle + 1), end);
        }

        return -1;
    }
}
