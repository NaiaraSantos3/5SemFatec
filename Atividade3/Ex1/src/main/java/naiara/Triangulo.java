package naiara;

public class Triangulo {

    public String verificarTipoTriangulo(int lado1, int lado2, int lado3) {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            return "Valores inválidos!";
        }

        if (lado1 + lado2 <= lado3 || lado2 + lado3 <= lado1 || lado3 + lado1 <= lado2) {
            return "Não é um triângulo!";
        }

        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        }

        if (lado1 == lado2 || lado2 == lado3 || lado3 == lado1) {
            return "Isósceles";
        }

        return "Escaleno";
    }
}