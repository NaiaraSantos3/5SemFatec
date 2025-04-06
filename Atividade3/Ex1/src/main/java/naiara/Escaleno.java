package naiara;


public class Escaleno {

    public boolean isTrianguloEscalenoValido(int lado1, int lado2, int lado3) {
        Triangulo triangulo = new Triangulo();
        return triangulo.verificarTipoTriangulo(lado1, lado2, lado3).equals("Escaleno");
    }
}
