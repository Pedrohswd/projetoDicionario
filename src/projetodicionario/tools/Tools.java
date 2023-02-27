/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public class Tools {

    public int characterCounter(String palavra) {
        int tamanho = 0;

        for (int i = 0; i < palavra.length(); i++) {
            if (Character.isLetter(palavra.charAt(i))) {
                tamanho++;
            }
        }

        return tamanho;
    }

    public static String[] readTxt(String[] palavras, String nomeArquivo) {

        try ( BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            int i = 0;
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras[i] = linha;
                i++;
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return palavras;
    }
}
