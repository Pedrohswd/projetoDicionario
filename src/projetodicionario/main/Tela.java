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
import projetodicionario.tree.Tree;

/**
 * InputMismatchException
 *
 * @author pedro
 */
public class Tela {

    private static int userInput = 0;
    private static String dictionary, palavraDesejada;
    private static char letter;
    private static Ordenation ordenation = new Ordenation();
    private static Search search = new Search();
    private static Scanner sc = new Scanner(System.in);
    private static Tools tool = new Tools();
    private static String[] palavras;
    private static int qtd;

    public static void main(String[] args) throws Exception {
        Tela tela = new Tela();
        userInput = 0;
        System.out.println("--------------------------Escolha com sabedoria!--------------------------");
        System.out.println("[1] - Arvore");
        System.out.println("[2] - Vetores");
        System.out.print("Digite o número referente a escolha desejada: ");
        userInput = sc.nextInt();
        if (userInput == 1) {
            tela.treeScrean();
        } else {
            tela.vector();
        }
    }

    public void treeScrean() {
        Tree tree = new Tree();
        dictionary = "./src/projetodicionario/dictionary/Dicionario limpo.txt";
        tree.verifica(dictionary);
        tree.readTxt(dictionary);
        while (userInput != 5) {
            System.out.println("--------------------------Oi usuário!--------------------------");
            System.out.println("Você está na opção de árvore... Isso me deu uma dor de cabeça legal");
            System.out.println("Sendo assim, o que deseja agora?");
            System.out.println("[1] - Incluir uma palavra");
            System.out.println("[2] - Deletar uma palavra");
            System.out.println("[3] - Procurar palavras");
            System.out.println("[4] - Imprimir a árvore");
            System.out.println("[5] - Sair");
            System.out.print("Digite o número referente a escolha desejada: ");
            userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Digite a palavra que deseja incluir: ");
                    palavraDesejada = sc.next();
                    tree.insert(palavraDesejada.charAt(0), palavraDesejada);
                    break;
                case 2:
                    System.out.println("Digite a palavra que deseja Deletar: ");
                    palavraDesejada = sc.next();
                    letter = palavraDesejada.charAt(0);
                    tree.delete(letter, palavraDesejada);
                    break;
                case 3:
                    System.out.print("Digite agora 10 palavras que você deseja buscar no dicionário: ");
                    String[] palavrasBuscadas = new String[10];
                    for (int i = 0; i < 10; i++) {
                        palavrasBuscadas[i] = sc.next();
                    }
                    for (int i = 0; i < 10; i++) {
                        if (tree.search(palavrasBuscadas[i]) == true) {
                            System.out.println("A palavra " + palavrasBuscadas[i] + " foi encontrada");
                        } else {
                            System.out.println("A palavra " + palavrasBuscadas[i] + " não foi encontrada");
                        }
                    }
                    break;
                case 4:
                    tree.print();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public void vector() throws Exception {

        try {
            System.out.println("--------------------------Olá Humano!--------------------------");
            System.out.println("Este sistema possui a intenção de fazer busca em um dicionário.\n");
            System.out.println("Sendo assim, selecione qual dicionário deseja utilizar:");
            System.out.println("1 - Português Brasil");
            System.out.println("2 - Inglês (Americano)");
            System.out.print("Digite o número referente ao dicionário desejado: ");
            userInput = sc.nextInt();

            if (userInput == 1) {
                System.out.println("Dicionário PT-BR");
                dictionary = "./src/projetodicionario/dictionary/PT-BR.txt";
                qtd = 307374;
                palavras = new String[qtd];

            } else {
                System.out.println("Dicionário ING-EUA");
                dictionary = "./src/projetodicionario/dictionary/EN-US.txt";
                qtd = 48447;
                palavras = new String[qtd];

            }

            palavras = tool.readTxt(palavras, dictionary);
            System.out.println("--------------------------Prontinho!--------------------------");
            System.out.println("Defina o método de ordenação:\n");
            System.out.println("1 - SelectionSort");
            System.out.println("2 - InsertionSort");
            System.out.println("3 - MergeSort");
            System.out.println("4 - QuickSort");
            System.out.print("Digite o número referente ao dicionário desejado: ");
            userInput = sc.nextInt();

            long ti;
            long ni;
            switch (userInput) {
                case 1:
                    ti = System.currentTimeMillis(); // tempo inicial em miliseg.
                    ni = System.nanoTime(); // tempo inicial em nanoseg.
                    palavras = ordenation.selectionSort(palavras);
                    break;
                case 2:
                    ti = System.currentTimeMillis(); // tempo inicial em miliseg.
                    ni = System.nanoTime(); // tempo inicial em nanoseg.
                    palavras = ordenation.insertionSort(palavras);
                    break;
                case 3:
                    ti = System.currentTimeMillis(); // tempo inicial em miliseg.
                    ni = System.nanoTime(); // tempo inicial em nanoseg.
                    palavras = ordenation.mergeSort(palavras, 0, qtd - 1);
                    break;
                case 4:
                    ti = System.currentTimeMillis(); // tempo inicial em miliseg.
                    ni = System.nanoTime(); // tempo inicial em nanoseg.
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

            switch (userInput) {
                case 1:
                    ti = System.currentTimeMillis();
                    ni = System.nanoTime();
                    for (int i = 0; i < 10; i++) {
                        int palavra = search.sequential(palavras, palavrasBuscadas[i]);
                        if (palavra != -1) {
                            System.out.println("A palavra " + palavras[palavra] + " foi encontrada");
                        } else {
                            System.out
                                    .println("A palavra " + palavrasBuscadas[i] + " não foi encontrada no dicionário");
                        }
                    }

                    // MEDIÇÃO DO TEMPO NA BUSCA SEQUENCIAL
                    tf = System.currentTimeMillis();
                    nf = System.nanoTime();
                    dt = tf - ti;
                    nt = nf - ni;

                    if (dt == 0) {
                        System.out.println("-----------Essa Busca Demorou " + nt + " nanosegundos-----------");
                    } else {
                        System.out.println("-----------Essa Busca Demorou " + dt + " milisegundos-----------");
                    }

                case 2:
                    ti = System.currentTimeMillis();
                    ni = System.nanoTime();
                    for (int i = 0; i < 10; i++) {
                        int palavra = search.binary(palavras, palavrasBuscadas[i], 0, qtd - 1);

                        if (palavra != -1) {
                            System.out.println("A palavra " + palavras[palavra] + " foi encontrada");
                        } else {
                            System.out
                                    .println("A palavra " + palavrasBuscadas[i] + " não foi encontrada no dicionário");
                        }
                    }

                    // MEDIÇÃO DO TEMPO NA BUSCA BINARIA
                    tf = System.currentTimeMillis();
                    nf = System.nanoTime();
                    dt = tf - ti;
                    nt = nf - ni;

                    if (dt == 0) {
                        System.out.println("-----------Essa Busca Demorou " + nt + " nanosegundos-----------");
                    } else {
                        System.out.println("-----------Essa Busca Demorou " + dt + " milisegundos-----------");
                    }
            }

        } catch (InputMismatchException erro) {
            JOptionPane.showMessageDialog(null, "Digite apenas números");
        }

    }
}
