package naiara;

public class Isosceles {

    public boolean isTrianguloIsoscelesValido(int lado1, int lado2, int lado3) {
        Triangulo triangulo = new Triangulo();
        return triangulo.verificarTipoTriangulo(lado1, lado2, lado3).equals("Isósceles");
    }
}