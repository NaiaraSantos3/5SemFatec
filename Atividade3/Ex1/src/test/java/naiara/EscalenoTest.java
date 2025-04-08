package naiara;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EscalenoTest {

    @Test
    public void testEscaleno() {
        Escaleno escaleno = new Escaleno();
        assertTrue(escaleno.isTrianguloEscalenoValido(3, 4, 5));
        assertFalse(escaleno.isTrianguloEscalenoValido(3, 3, 3));
    }
}
