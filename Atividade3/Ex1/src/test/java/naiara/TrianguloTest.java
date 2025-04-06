package naiara;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TrianguloTest {

    @ParameterizedTest
    @MethodSource("provideTrianguloAndExpectedValues")
    public void validarTipoTriangulo(int lado1, int lado2, int lado3, String tipoEsperado) {
        Triangulo triangulo = new Triangulo();
        String tipoTriangulo = triangulo.verificarTipoTriangulo(lado1, lado2, lado3);
        Assertions.assertEquals(tipoEsperado, tipoTriangulo);
    }

    private static Stream<Arguments> provideTrianguloAndExpectedValues() {
        return Stream.of(
                Arguments.of(3, 3, 3, "Equilátero"),

                Arguments.of(3, 3, 5, "Isósceles"),
                Arguments.of(3, 5, 3, "Isósceles"),
                Arguments.of(5, 3, 3, "Isósceles"),

                Arguments.of(3, 4, 5, "Escaleno"),
                Arguments.of(5, 6, 7, "Escaleno"),
                Arguments.of(9, 8, 7, "Escaleno"),

                Arguments.of(0, 3, 4, "Valores inválidos!"),
                Arguments.of(3, 0, 4, "Valores inválidos!"),
                Arguments.of(3, 4, 0, "Valores inválidos!"),
                Arguments.of(-3, 4, 5, "Valores inválidos!"),
                Arguments.of(3, -4, 5, "Valores inválidos!"),
                Arguments.of(3, 4, -5, "Valores inválidos!"),

                Arguments.of(3, 4, 7, "Não é um triângulo!"),
                Arguments.of(4, 3, 7, "Não é um triângulo!"),
                Arguments.of(7, 3, 4, "Não é um triângulo!"),

                Arguments.of(1, 2, 6, "Não é um triângulo!"),
                Arguments.of(2, 1, 6, "Não é um triângulo!"),
                Arguments.of(6, 2, 1, "Não é um triângulo!"),

                Arguments.of(0, 0, 0, "Valores inválidos!")
        );
    }
}
