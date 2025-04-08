package naiara;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EquilateroTest {

    @Test
    public void testEquilatero() {
        Equilatero equilatero = new Equilatero();
        assertTrue(equilatero.isTrianguloEquilateroValido(3, 3, 3));
        assertFalse(equilatero.isTrianguloEquilateroValido(3, 4, 5));
    }
}
