/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodicionario.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Tools {

    public int characterCounter(String palavra) {
        int tamanho = 0;

        for (int i = 0; i < palavra.length(); i++) {
            tamanho++;
        }

        return tamanho;
    }

    public String[] readTxt(String[] palavras, String nomeArquivo) {

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

    public void writeTxt(String[] palavra) {
        String arquivo = "./src/projetodicionario/dictionary/Saida.txt";
        try {
            clearTxt(arquivo);
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < palavra.length; i++) {
                bw.write(palavra[i]);
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao imprimir a saida");
            e.printStackTrace();
        }
    }

    public void clearTxt(String arquivo) {
        try {
            //Cria o objeto FileWriter com o parâmetro 'false' para não acrescentar ao arquivo
            FileWriter fw = new FileWriter(arquivo, false);

            //Escreve uma string vazia no arquivo para limpar todo o conteúdo anterior
            fw.write("");

            //Fecha o FileWriter
            fw.close();

            System.out.println("Arquivo limpo com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao limpar o arquivo!");
            e.printStackTrace();
        }
    }
}
