/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.main;

import java.lang.ref.Cleaner;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * InputMismatchException
 *
 * @author pedro
 */
public class Tela {

    public static void main(String[] args) throws Exception {
        int userInput;
        String dictionary;
        Scanner sc = new Scanner(System.in);
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
            } else {
                System.out.println("Dicionário ING-EUA");
                dictionary = "./src/projetodicionario/dictionary/EN-US.txt";
            }

            System.out.println(Cleaner.create());

        } catch (InputMismatchException erro) {
            JOptionPane.showMessageDialog(null, "Digite apenas números");
        }

    }

}
