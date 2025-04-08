package naiara;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonDAOTest {

    @Test
    public void testValidPerson() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(1, "Joao Silva", 30, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.isEmpty(), "Esperado nenhum erro para pessoa válida");
    }

    @Test
    public void testInvalidName() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(2, "Joao", 25, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Você deve atribuir o nome e sobrenome"));
    }

    @Test
    public void testNameWithSpecialCharacters() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(3, "João@ Silva", 25, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Só é aceito letras para inserir o nome"));
    }

    @Test
    public void testNullName() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(4, null, 25, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Por favor, insira um nome."));
    }

    @Test
    public void testEmptyName() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(5, "", 25, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Por favor, insira um nome."));
    }

    @Test
    public void testValidAge() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(6, "Carlos Alberto", 30, Arrays.asList(new Email(1, "carlos@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.isEmpty(), "Esperado nenhum erro para idade válida");
    }

    @Test
    public void testInvalidAgeTooYoung() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(7, "Joao Silva", 0, Arrays.asList(new Email(1, "joao@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Idade deve estar entre 1 e 110."));
    }

    @Test
    public void testInvalidAgeTooOld() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(8, "Ana Maria", 111, Arrays.asList(new Email(1, "ana@teste.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Idade deve estar entre 1 e 110."));
    }

    @Test
    public void testMissingEmail() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(9, "Carlos Alberto", 45, Collections.emptyList());

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Inisira pelo menos um email."));
    }


    @Test
    public void testValidEmail() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(11, "Fernanda Souza", 28, Arrays.asList(new Email(1, "fernanda.souza@dominio.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.isEmpty(), "Esperado nenhum erro para email válido.");
    }

    @Test
    public void testNullEmail() {
        PersonDAO dao = new PersonDAO();
        Person person = new Person(12, "Carlos Silva", 30, Arrays.asList(new Email(1, null)));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Email inválido: null"));
    }
  }
    

