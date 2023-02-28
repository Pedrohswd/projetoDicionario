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
        Tools tools = new Tools();
        for (int i = 1; i < palavra.length; i++) {
            int current = tools.characterCounter(palavra[i]);
            int j = i - 1;
            int palavraJ = tools.characterCounter(palavra[j]);
            while (j > 0 && palavraJ > current) {
                palavra[j + 1] = palavra[j];
                j--;
            }
            palavra[j + 1] = palavra[i];
        }

        return palavra;
    }

    public static String[] mergeSort(String[] palavra, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(palavra, start, middle);
            mergeSort(palavra, middle + 1, end);
            palavra = merge(palavra, start, middle, end);
        }
        return palavra;
    }

    private static String[] merge(String[] palavra, int start, int middle, int end) {
        Tools tools = new Tools();
        int leftLength = middle - start + 1;
        int rightLength = end - middle;

        String[] leftArray = new String[leftLength];
        String[] rightArray = new String[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = palavra[start + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = palavra[middle + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftLength && j < rightLength) {
            int leftArrayI = tools.characterCounter(leftArray[i]);
            int rightArrayJ = tools.characterCounter(rightArray[j]);
            if (leftArrayI <= rightArrayJ) {
                palavra[k] = leftArray[i];
                i++;
            } else {
                palavra[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            palavra[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            palavra[k] = rightArray[j];
            j++;
            k++;
        }
        return palavra;
    }

    public static void quickSort(String[] palavra, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(palavra, left, right);
            quickSort(palavra, left, pivotIndex - 1);
            quickSort(palavra, pivotIndex + 1, right);
        }
    }

    private static int partition(String[] palavra, int left, int right) {
        Tools tools = new Tools();
        int pivot = tools.characterCounter(palavra[right]);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            int palavraJ = tools.characterCounter(palavra[j]);
            if (palavraJ < pivot) {
                i++;
                swap(palavra, i, j);
            }
        }

        swap(palavra, i + 1, right);

        return i + 1;
    }

    private static void swap(String[] palavra, int i, int j) {
        String temp = palavra[i];
        palavra[i] = palavra[j];
        palavra[j] = temp;
    }

}
