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

    public boolean BuscaSequencial(String[] vetor, String palavraBuscada) {

        int i;
        for (i = 0; i < vetor.length; i++) {
            if (palavraBuscada == vetor[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean BuscaBinaria(String[] vetor, String palavraBuscada, int inicio, int fim) {
        int meio;
        if (inicio > fim) {
            return false;
        }
        meio = (inicio + fim) / 2;
        if (palavraBuscada == vetor[meio]) {
            return true;
        } else if (palavraBuscada.compareTo(vetor[meio]) == -1) {
            return (BuscaBinaria(vetor, palavraBuscada, inicio, meio - 1));
        } else {
            return (BuscaBinaria(vetor, palavraBuscada, meio + 1, fim));
        }
    }
}
