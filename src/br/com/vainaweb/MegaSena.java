package br.com.vainaweb;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MegaSena {

    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
        
        System.out.println("-------------- Simulador da Mega Sena -------------");
        System.out.println("Insira sua aposta");

        // Aposta do Usuario
        int[] aposta = new int[6];
        for (int i = 0; i < 6; i++) {
            boolean numOk = false;

            while (!numOk) {
                System.out.print((i + 1) + "º número: ");
                int escolha = sc.nextInt();
                
                // Verifica se o numero escolhido já existe e é válido
                boolean numExiste = false;
                for (int elemento : aposta) {
                    if (elemento == escolha) {
                        numExiste = true;
                    }
                }
                if (escolha >= 1 && escolha <= 60 && !numExiste) {
                	aposta[i] = escolha;
                    numOk = true;
                } else {
                    System.out.println("Número inválido ou repetido. Tente novamente.");
                }
            }
        }
        
        // Sorteia os números
        Random random = new Random();
        int[] numerosSorteados = new int[6];

        for (int i = 0; i < 6; i++) {
            numerosSorteados[i] = random.nextInt(61);
        }
        
        // Confere o numero de acertos
        int acertos = 0;
        for (int numApostado : aposta) {
            for (int numSorteado : numerosSorteados) {
                if (numApostado == numSorteado) {
                    acertos++;
                    break;
                }
            }
        }

        // Exibe resultados
        System.out.println("\nSua aposta: " + Arrays.toString(aposta));
        System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados));


        System.out.println("\nVocê acertou " + acertos + " número(s).");
        
        sc.close();
    }



}
