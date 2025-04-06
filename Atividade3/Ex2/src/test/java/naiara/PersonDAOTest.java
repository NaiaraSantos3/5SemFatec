package naiara;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {

    @Test
    public void testValidPerson() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(1, "Joao Silva", 30, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        System.out.println("Erros: " + errors); 

        assertTrue(errors.isEmpty(), "Esperado nenhum erro para pessoa válida");
    }

    @Test
    public void testInvalidName() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(2, "Joao", 25, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        System.out.println("Erros: " + errors); 

        assertTrue(errors.contains("Você deve atribuir o nome e sobrenome"));
    }

    @Test
    public void testInvalidAge() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(3, "Ana Maria", 111, Arrays.asList(new Email(1, "ana@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        System.out.println("Erros: " + errors); 

        assertTrue(errors.contains("Idade deve estar entre 1 e 110."));
    }

    @Test
    public void testMissingEmail() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(4, "Carlos Alberto", 45, Collections.emptyList());

        List<String> errors = dao.isValidToInclude(person);
        System.out.println("Erros: " + errors); 

        assertTrue(errors.contains("Inisira pelo menos um email."));
    }

    @Test
    public void testInvalidEmailFormat() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(5, "Naiara Santos", 26, Arrays.asList(new Email(1, "naiara@.com")));

        List<String> errors = dao.isValidToInclude(person);
        System.out.println("Erros: " + errors); 

        assertTrue(errors.contains("Email inválido: naiara@.com"));
    }
}
