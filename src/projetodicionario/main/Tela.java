/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.main;

import projetodicionario.tools.Tools;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import projetodicionario.ordination.Ordenation;
import projetodicionario.search.Search;

/**
 * InputMismatchException
 *
 * @author pedro
 */
public class Tela {

    public static void main(String[] args) throws Exception {
        int userInput;
        String dictionary;
        Ordenation ordenation = new Ordenation();
        Search search = new Search();
        Scanner sc = new Scanner(System.in);
        Tools tool = new Tools();
        String[] palavras;
        try {
            System.out.println("--------------------------Olá Humano!--------------------------");
            System.out.println("Este sistema possui a intenção de fazer busca em um dicionário.\n");
            System.out.println("Sendo assim, selecione qual dicionário deseja utilizar:");
            System.out.println("1 - Português Brasil");
            System.out.println("2 - Inglês (Americano)");
            System.out.print("Digite o número referente ao dicionário desejado: ");
            userInput = sc.nextInt();

            int qtd;
            if (userInput == 1) {
                System.out.println("Dicionário PT-BR");
                dictionary = "./src/projetodicionario/dictionary/PT-BR.txt";
                palavras = new String[307374];
                qtd = 307374;
            } else {
                System.out.println("Dicionário ING-EUA");
                dictionary = "./src/projetodicionario/dictionary/EN-US.txt";
                palavras = new String[48447];
                qtd = 48447;
            }

            palavras = tool.readTxt(palavras, dictionary);
            System.out.println(palavras[5]);
            System.out.println("--------------------------Prontinho!--------------------------");
            System.out.println("Defina o método de ordenação:\n");
            System.out.println("1 - SelectionSort");
            System.out.println("2 - InsertionSort");
            System.out.println("3 - MergeSort");
            System.out.println("4 - QuickSort");
            System.out.print("Digite o número referente ao dicionário desejado: ");
            userInput = sc.nextInt();

            long ti = System.currentTimeMillis(); // tempo inicial em miliseg.
            long ni = System.nanoTime(); // tempo inicial em nanoseg.
            switch (userInput) {
                case 1:
                    palavras = ordenation.selectionSort(palavras);
                    break;
                case 2:
                    palavras = ordenation.insertionSort(palavras);
                    break;
                case 3:
                    palavras = ordenation.mergeSort(palavras, 0, qtd - 1);
                    break;
                case 4:
                    palavras = ordenation.quickSort(palavras, 0, qtd - 1);
                    break;
                default:
                    throw new AssertionError();
            }
            long tf = System.currentTimeMillis(); // tempo final em miliseg.
            long nf = System.nanoTime(); // tempo final em nanoseg.
            long dt = tf - ti; // delta T miliseg.
            long nt = nf - ni; // delta T nanoseg.
            tool.writeTxt(palavras);

            if (dt == 0) {
                System.out.println("-----------Essa Ordenação Demorou " + nt + " nanosegundos-----------");
            } else {
                System.out.println("-----------Essa Ordenação Demorou " + dt + " milisegundos-----------");
            }

            System.out.println("--------------------------Ok!--------------------------");
            System.out.print("Digite agora 10 palavras que você deseja buscar no dicionário: ");
            String[] palavrasBuscadas = new String[10];
            for (int i = 0; i < 10; i++) {
                palavrasBuscadas[i] = sc.next();
            }
            System.out.println("-----------------------Beleza meu compatriota!-----------------------");
            System.out.println("Agora escolha o método de busca a ser utilizado: ");
            System.out.println("1- Sequencial");
            System.out.println("2- Binária ");
            System.out.println("Digite sua escolha");
            userInput = sc.nextInt();

            ti = System.currentTimeMillis();
            ni = System.nanoTime();
            switch (userInput) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        System.out.print("A palavra " + palavras[search.sequential(palavras, palavrasBuscadas[i])] + " foi encontrada.");
                    }

                    // MEDIÇÃO DO TEMPO NA BUSCA SEQUENCIAL
                    tf = System.currentTimeMillis();
                    nf = System.nanoTime();
                    dt = tf - ti;
                    nt = nf - ni;

                    if (dt == 0) {
                        System.out.println("-----------Essa Ordenação Demorou " + nt + " nanosegundos-----------");
                    } else {
                        System.out.println("-----------Essa Ordenação Demorou " + dt + " milisegundos-----------");
                    }

                case 2:
                    for (int i = 0; i < 10; i++) {
                        System.out.println("A palavra " + palavras[search.binary(palavras, palavrasBuscadas[i], 0, qtd - 1)] + " foi encontrada");
                    }

                    // MEDIÇÃO DO TEMPO NA BUSCA BINARIA
                    tf = System.currentTimeMillis();

                    nf = System.nanoTime();
                    dt = tf - ti;
                    nt = nf - ni;

                    if (dt == 0) {
                        System.out.println("-----------Essa Ordenação Demorou " + nt + " nanosegundos-----------");
                    } else {
                        System.out.println("-----------Essa Ordenação Demorou " + dt + " milisegundos-----------");
                    }
            }

        } catch (InputMismatchException erro) {
            JOptionPane.showMessageDialog(null, "Digite apenas números");
        }

    }

}
