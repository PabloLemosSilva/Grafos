/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoma;

/**
 *
 * @author Bem vindo
 */
public class Grafo {

    private int[][] MA;
    private int qtVertices;
    private int tamMA;
    private int[][] MAaux;

    public Grafo(int qtVertices) {
        this.MA = new int[qtVertices][qtVertices];

        for (int xGrafo = 0; xGrafo < this.MA.length; xGrafo++) {
            for (int yGrafo = 0; yGrafo < this.MA.length; yGrafo++) {
                this.MA[xGrafo][yGrafo] = 0;
            }

        }

    }

    public boolean InserirVertice(int Acrvertice) {
        int novotamMA = this.MA.length + Acrvertice;
        this.MAaux = new int[novotamMA][novotamMA];

        for (int xGrafo = 0; xGrafo < this.MAaux.length; xGrafo++) {
            for (int yGrafo = 0; yGrafo < this.MAaux.length; yGrafo++) {
                this.MAaux[xGrafo][yGrafo] = 0;

            }

        }
        for (int xGrafo = 0; xGrafo < this.MA.length; xGrafo++) {
            for (int yGrafo = 0; yGrafo < this.MA.length; yGrafo++) {
                this.MAaux[xGrafo][yGrafo] = this.MA[xGrafo][yGrafo];

            }

        }

        this.MA = new int[novotamMA][novotamMA];

        for (int xGrafo = 0; xGrafo < this.MA.length; xGrafo++) {
            for (int yGrafo = 0; yGrafo < this.MA.length; yGrafo++) {
                this.MA[xGrafo][yGrafo] = this.MAaux[xGrafo][yGrafo];

            }

        }

        return true;

    }

    public boolean RemoveVertice(int removertice) {
        int novotamMA = this.MA.length - 1;
        this.MAaux = new int[novotamMA][novotamMA];

        for (int xGrafo = 0; xGrafo < this.MAaux.length; xGrafo++) {
            for (int yGrafo = 0; yGrafo < this.MAaux.length; yGrafo++) {
                this.MAaux[xGrafo][yGrafo] = 0;

            }

        }
        for (int xGrafo = 0; xGrafo < this.MA.length; xGrafo++) {
            for (int yGrafo = 0; yGrafo < this.MA.length; yGrafo++) {
                if (this.MA[xGrafo][removertice] != this.MA[xGrafo][yGrafo]) {
                    if (this.MA[removertice][yGrafo] != this.MA[xGrafo][yGrafo]) {
                        this.MAaux[xGrafo][yGrafo] = this.MA[xGrafo][yGrafo];
                    }
                }
            }

        }

        this.MA = new int[novotamMA][novotamMA];

        for (int xGrafo = 0; xGrafo < this.MA.length; xGrafo++) {
            for (int yGrafo = 0; yGrafo < this.MA.length; yGrafo++) {
                this.MA[xGrafo][yGrafo] = this.MAaux[xGrafo][yGrafo];

            }

        }

        return true;

    }

    public int Ordem() {

        if (this.MA.length > 0) {
            this.tamMA = this.MA.length;
        }

        return tamMA;
    }

    public boolean InserirAresta(int v1, int v2) {

        this.MA[v1][v2] = 1;
        this.MA[v2][v1] = 1;
        System.out.println("Inserido aresta entre os vertices: " + v1 + " e " + v2);

        return true;
    }

    public boolean RemoverAresta(int v1, int v2) {

        this.MA[v1][v2] = 0;
        this.MA[v2][v1] = 0;
        System.out.println("Inserido aresta entre os vertices: " + v1 + " e " + v2);

        return true;
    }

    public int Grau(int vertice) {
        int totalGrau = 0;
        for (int x = 0; x < this.MA.length; x++) {
            if (this.MA[x][vertice] == 1) {
                System.out.println("tem entre" + x + " e " + vertice);
                totalGrau += 1;
            }
        }

        return totalGrau;
    }

    public void ShowMA() {

        for (int linha = 0; linha < this.MA.length; linha++) {
            for (int coluna = 0; coluna < this.MA[linha].length; coluna++) {
                System.out.printf(" " + this.MA[linha][coluna]);
            }
            System.out.println(" ");
        }

    }

    public boolean Completo() {
        boolean x = true;

        for (int linha = 0; linha < this.MA.length; linha++) {
            for (int coluna = 0; coluna < this.MA[linha].length; coluna++) {
                if (linha != coluna) {
                    if (this.MA[linha][coluna] != 1) {
                        x = false;
                    }
                }
            }
        }
        return x;

    }

    public void SequenciaGraus() {
        int totalGrau = 0;
        int x;
        for (int linha = 0; linha < this.MA.length; linha++) {
            for (int coluna = 0; coluna < this.MA[linha].length; coluna++) {
                if (this.MA[linha][coluna] == 1) {
                    totalGrau += 1;
                }
            }
            System.out.println("Vertice: " + linha + " grau: " + totalGrau);
            totalGrau = 0;
        }

    }

    public boolean Isolado(int vertice) {
        int totalGrau = 0;
        for (int x = 0; x < this.MA.length; x++) {
            if (this.MA[x][vertice] == 1) {
                System.out.println("tem entre" + x + " e " + vertice);
                totalGrau += 1;
            }
        }
        if (totalGrau == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Par(int vertice) {
        int totalGrau = 0;
        for (int x = 0; x < this.MA.length; x++) {
            if (this.MA[x][vertice] == 1) {
                System.out.println("tem entre" + x + " e " + vertice);
                totalGrau += 1;
            }
        }

        if (totalGrau % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Impar(int vertice) {
        int totalGrau = 0;
        for (int x = 0; x < this.MA.length; x++) {
            if (this.MA[x][vertice] == 1) {
                System.out.println("tem entre" + x + " e " + vertice);
                totalGrau += 1;
            }
        }

        if (totalGrau % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Adjacentes(int v1, int v2) {

        if (this.MA[v1][v2] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void VerticesAdjacentes(int vert) {
        for (int coluna = 0; coluna < this.MA.length; coluna++) {
            if (this.MA[vert][coluna] == 1) {
                System.out.printf(" " + coluna);
            }

        }
        System.out.println(" são adjacentes ao vertice: " + vert);
    }

    public void ShowLA() {
        for (int linha = 0; linha < this.MA.length; linha++) {
            System.out.printf(" " + linha + ": ");
            for (int coluna = 0; coluna < this.MA[linha].length; coluna++) {
                if (this.MA[linha][coluna] == 1) {
                    System.out.printf(" " + coluna + ", ");
                }
            }
            System.out.println("");
        }

    }

}
