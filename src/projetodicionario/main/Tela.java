/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import projetodicionario.tools.Tools;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import projetodicionario.ordination.Ordenation;

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

            if (userInput == 1) {
                System.out.println("Dicionário PT-BR");
                dictionary = "./src/projetodicionario/dictionary/PT-BR.txt";
                palavras = new String[307374];

            } else {
                System.out.println("Dicionário ING-EUA");
                dictionary = "./src/projetodicionario/dictionary/EN-US.txt";
                palavras = new String[48447];
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

            switch (userInput) {
                case 1:
                    palavras = ordenation.selectionSort(palavras);
                    break;
                case 2:
                    palavras = ordenation.insertionSort(palavras);
                    break;
                case 3:
                    palavras = ordenation.mergeSort(palavras);
                    break;
                case 4:
                    palavras = ordenation.selectionSort(palavras);
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println("--------------------------Ok!--------------------------");
            System.out.print("Digite agora 10 palavras que você deseja buscar no dicionário: ");
            String[] plavrasBuscadas = new String[10];

        } catch (InputMismatchException erro) {
            JOptionPane.showMessageDialog(null, "Digite apenas números");
        }

    }

}
