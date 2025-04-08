package naiara;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person p) {
        System.out.println("Pessoa salva com sucesso: " + p.getName());
    }

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        if (p.getName() == null || p.getName().trim().isEmpty()) {
            errors.add("Por favor, insira um nome.");
        } else {
            String[] parts = p.getName().trim().split("\\s+");
            if (parts.length < 2) {
                errors.add("Você deve atribuir o nome e sobrenome");
            }
            for (String part : parts) {
                if (!part.matches("[a-zA-Z]+")) {
                    errors.add("Só é aceito letras para inserir o nome");
                    break;
                }
            }
        }

        if (p.getAge() < 1 || p.getAge() > 110) {
            errors.add("Idade deve estar entre 1 e 110.");
        }

        List<Email> emails = p.getEmails();
        if (emails == null || emails.isEmpty()) {
            errors.add("Inisira pelo menos um email.");
        } else {
            for (Email email : emails) {
                if (!isValidEmail(email.getName())) {
                    errors.add("Email inválido: " + email.getName());
                }
            }
        }

        return errors;
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
}
