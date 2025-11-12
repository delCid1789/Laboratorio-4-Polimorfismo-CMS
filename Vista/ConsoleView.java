import java.util.List;
import java.util.Scanner;

public class ConsoleView implements CMSView {
    private Scanner scanner;
    
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public void displayContent(Content content) {
        if (content == null) {
            System.out.println("No hay contenido");
            return;
        }
        System.out.println("\n" + content.display());
    }
    
    @Override
    public void displayContentList(List<Content> contents) {
        if (contents == null || contents.isEmpty()) {
            System.out.println("No hay contenidos");
            return;
        }
        
        System.out.println("\n=== CONTENIDOS ===");
        for (Content c : contents) {
            System.out.println("ID: " + c.getId() + " | " + c.getType() + " | " + 
                             c.getTitle() + " | Autor: " + c.getAuthor() + 
                             " | Publicado: " + (c.isPublished() ? "Sí" : "No"));
        }
    }
    
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
    
    public void displayMenu() {
        System.out.println("\n=== CMS - ESTUDIO DE GRABACIÓN AUDIOVISUAL ===");
        System.out.println("1. Crear Contenido");
        System.out.println("2. Ver Contenidos");
        System.out.println("3. Buscar Contenido");
        System.out.println("4. Editar Contenido");
        System.out.println("5. Eliminar Contenido");
        System.out.println("6. Publicar/Despublicar");
        System.out.println("7. Filtrar por Tipo");
        System.out.println("0. Salir");
    }
    
    public void close() {
        scanner.close();
    }
}