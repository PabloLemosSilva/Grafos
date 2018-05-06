/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoma;

import java.util.Scanner;

/**
 *
 * @author Bem vindo
 */
public class GrafoMa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int operacao = 0;
        Scanner entrada = new Scanner(System.in);
        int numVertice;
        System.out.printf("Insira o numero de vertice: ");
        numVertice = entrada.nextInt();
        Grafo x = new Grafo(numVertice);

        do {
            System.out.println("1 - Ver o numero de vertices");
            System.out.println("2 - Inserir arestas entre 2 vertices");
            System.out.println("3 - Remover arestas entre 2 vertices");
            System.out.println("4 - Consultar Grau do vertice");
            System.out.println("5 - Consultar se o Grafo é completo");
            System.out.println("6 - Consultar se o Grafo é regular");
            System.out.println("7 - Imprimir  matriz de adjacência ");
            System.out.println("8 - Imprimir  Sequencia de Graus");
            System.out.println("9 - Verificar se Vertice é Isolado");
            System.out.println("10 - Verificar se Vertice é Par");
            System.out.println("11 - Verificar se Vertice é Impar");
            System.out.println("12 - Imprimie adjacente do Vertice");
            System.out.println("13 - Verificar se dois Vertice são adjacentes");
            System.out.println("14 - Imprimr a lista de adjacência usando a matriz MA");
            System.out.println("15 - Adicionar vertice");
            System.out.println("16 - Remover vertice");
            System.out.println("99 - sair");

            System.out.printf("Digite uma opção: ");
            operacao = entrada.nextInt();

            switch (operacao) {
                case 1:
                    int qVert = x.Ordem();
                    System.out.println("Numero de vertices: " + qVert);
                    break;

                case 2:
                    int vertice1;
                    int vertice2;
                    do {
                        System.out.printf("V1: ");
                        vertice1 = entrada.nextInt();
                    } while (vertice1 >= numVertice);
                    do {
                        System.out.printf("V2: ");
                        vertice2 = entrada.nextInt();
                    } while (vertice2 >= numVertice);
                    x.InserirAresta(vertice1, vertice2);

                    break;

                case 3:
                    int verticey;
                    int verticex;
                    do {
                        System.out.println("V1: ");
                        verticey = entrada.nextInt();
                    } while (verticey >= numVertice);
                    do {
                        System.out.println("V2: ");
                        verticex = entrada.nextInt();
                    } while (verticex >= numVertice);
                    x.RemoverAresta(verticey, verticex);
                    break;

                case 4:
                    int Grau;
                    System.out.println("Digite o Vertice: ");
                    Grau = entrada.nextInt();
                    System.out.println("o grau do Vertice: " + Grau + " é: " + x.Grau(Grau));
                    break;
                case 5:
                    if (x.Completo() == true) {
                        System.out.println("o Grafo é Completo ");
                    } else {
                        System.out.println("o Grafo não é Completo ");
                    }
                    break;
                case 6:
                    System.out.println("Ainda não implementado ");
                    break;
                case 7:
                    x.ShowMA();
                    break;
                case 8:
                    x.SequenciaGraus();
                    break;
                case 9:
                    int verticez;
                    System.out.println("Digite o Vertice: ");
                    verticez = entrada.nextInt();
                    if (x.Isolado(verticez) == true) {
                        System.out.println("o vertice é isolado ");
                    } else {
                        System.out.println("o vertice não é isolado ");
                    }
                    break;
                case 10:
                    int verticem;
                    System.out.println("Digite o Vertice: ");
                    verticem = entrada.nextInt();
                    if (x.Par(verticem) == true) {
                        System.out.println("o vertice é Par ");
                    } else {
                        System.out.println("o vertice não é Par ");
                    }
                    break;
                case 11:
                    int verticej;
                    System.out.println("Digite o Vertice: ");
                    verticej = entrada.nextInt();
                    if (x.Impar(verticej) == true) {
                        System.out.println("o vertice é Impar ");
                    } else {
                        System.out.println("o vertice não é Impar ");
                    }
                    break;
                case 12:
                    int verticeadj;
                    System.out.println("Digite o Vertice: ");
                    verticeadj = entrada.nextInt();
                    x.VerticesAdjacentes(verticeadj);
                    break;
                case 13:
                    int verticeadj1;
                    int verticeadj2;
                    do {
                        System.out.printf("V1: ");
                        verticeadj1 = entrada.nextInt();
                    } while (verticeadj1 >= numVertice);
                    do {
                        System.out.printf("V2: ");
                        verticeadj2 = entrada.nextInt();
                    } while (verticeadj2 >= numVertice);
                    if (x.Adjacentes(verticeadj1, verticeadj2) == true) {
                        System.out.println("Os vertices" + verticeadj1 + " e " + verticeadj2 + " são adjacentes ");
                    } else {
                        System.out.println("Os vertices" + verticeadj1 + " e " + verticeadj2 + " não são adjacentes ");
                    }

                    break;
                case 14:
                    x.ShowLA();
                    break;
                case 15:
                    int verticeadd;
                    do {
                        System.out.printf("Adicionar qnts vertices: ");
                        verticeadd = entrada.nextInt();
                    } while (verticeadd >= numVertice);

                    x.InserirVertice(verticeadd);
                    System.out.println("Foi adicionado " + verticeadd + " vertice(s)");
                    break;
                case 16:
                    int verticerem;
                    do {
                        System.out.printf("Remover qual vertice: ");
                        verticerem = entrada.nextInt();
                    } while (verticerem >= numVertice);

                    x.RemoveVertice(verticerem);
                    System.out.println("O vertice " + verticerem + " foi removido");

                    break;
                case 99:
                    System.exit(0);
                    break;

                default:
                    System.out.printf("Você digitou uma operação inválida.");

            }
        } while (operacao != 99);

        /**
         * Grafo x =new Grafo(5); int qVert=x.Ordem();
         * System.out.println("tamanho: " + qVert); int vertice1=2; int
         * vertice2=4; int vertice3=4; int vertice4=3; if(vertice1>=qVert ||
         * vertice2>=qVert){ System.out.println("Vertice invalido"); } else {
         * x.InserirAresta(vertice1,vertice2);
         * x.InserirAresta(vertice3,vertice4); }
         *
         * int Grau = x.Grau(4);
         *
         * x.SequenciaGraus();
         *
         * System.out.println("Grau: " + Grau);
         *
         * System.out.println("Completo: " + x.Completo());
         */
    }

}
