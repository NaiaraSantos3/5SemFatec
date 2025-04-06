package naiara;

public class Equilatero {
    
    public boolean isTrianguloEquilateroValido(int lado1, int lado2, int lado3) {
        Triangulo triangulo = new Triangulo();
        return triangulo.verificarTipoTriangulo(lado1, lado2, lado3).equals("Equilátero");
    }
}
