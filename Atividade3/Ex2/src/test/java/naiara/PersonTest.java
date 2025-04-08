package naiara;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonConstructor() {
        Person person = new Person(1, "Joao Silva", 30, Arrays.asList(new Email(1, "joao@teste.com")));
        assertEquals(1, person.getId());
        assertEquals("Joao Silva", person.getName());
        assertEquals(30, person.getAge());
        assertNotNull(person.getEmails());
        assertEquals(1, person.getEmails().size());
        assertEquals("joao@teste.com", person.getEmails().get(0).getName());
    }

    @Test
    public void testSettersAndGetters() {
        Person person = new Person();
        person.setId(2);
        person.setName("Maria Souza");
        person.setAge(28);
        person.setEmails(Collections.singletonList(new Email(2, "maria@teste.com")));

        assertEquals(2, person.getId());
        assertEquals("Maria Souza", person.getName());
        assertEquals(28, person.getAge());
        assertNotNull(person.getEmails());
        assertEquals(1, person.getEmails().size());
        assertEquals("maria@teste.com", person.getEmails().get(0).getName());
    }

    @Test
    public void testEmptyEmails() {
        Person person = new Person(3, "Carlos Santos", 40, Collections.emptyList());
        assertTrue(person.getEmails().isEmpty());
    }

    @Test
    public void testNullEmails() {
        Person person = new Person(4, "Ana Costa", 35, null);
        assertNull(person.getEmails());
    }
}

