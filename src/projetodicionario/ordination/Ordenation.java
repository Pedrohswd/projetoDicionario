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
        for (int i = 0; i < palavra.length; i++) {
            String aux = palavra[i];
            int j = i;
            while (j > 0 && palavra[j - 1].length() > aux.length()) {
                palavra[j] = palavra[j - 1];
                j -= 1;
            }
            palavra[j] = aux;
        }

        return palavra;
    }

    public String[] mergeSort(String[] palavra, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(palavra, inicio, meio);
            mergeSort(palavra, meio + 1, fim);
            palavra = merge(palavra, inicio, meio, fim);
        }
        return palavra;
    }

    private String[] merge(String[] palavra, int inicio, int meio, int fim) {
        Tools tools = new Tools();
        int leftLength = meio - inicio + 1;
        int rightLength = fim - meio;

        String[] leftArray = new String[leftLength];
        String[] rightArray = new String[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = palavra[inicio + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = palavra[meio + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

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

    private void swap(String[] palavra, int i, int j) {
        String temp = palavra[i];
        palavra[i] = palavra[j];
        palavra[j] = temp;
    }

    private int partition(String[] palavra, int menor, int high) {
        String pivot = palavra[menor];
        int i = menor - 1, j = high + 1;

        while (true) {
            do {
                i++;
            } while (palavra[i].length() < pivot.length());

            do {
                j--;
            } while (palavra[j].length() > pivot.length());

            if (i >= j) {
                return j;
            }
            swap(palavra, i, j);
        }
    }

    public String[] quickSort(String[] palavra, int menor, int maior) {
        if (menor < maior) {
            int pivot = partition(palavra, menor, maior);
            quickSort(palavra, menor, pivot);
            quickSort(palavra, (pivot + 1), maior);
        }
        return palavra;
    }
}
