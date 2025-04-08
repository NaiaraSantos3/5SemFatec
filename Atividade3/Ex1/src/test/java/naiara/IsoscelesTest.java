package naiara;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsoscelesTest {

    @Test
    public void testIsosceles() {
        Isosceles isosceles = new Isosceles();
        assertTrue(isosceles.isTrianguloIsoscelesValido(3, 3, 4));
        assertFalse(isosceles.isTrianguloIsoscelesValido(3, 4, 5));
    }
}
