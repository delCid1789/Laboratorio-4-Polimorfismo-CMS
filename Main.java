public class Main {
    public static void main(String[] args) {
        ContentModel model = new ContentModel();
        ConsoleView view = new ConsoleView();
        ContentController controller = new ContentController(model, view);
        
        loadSampleData(model);
        
        boolean running = true;
        while (running) {
            view.displayMenu();
            String option = view.getUserInput("Opción");
            
            switch (option) {
                case "1":
                    createContent(view, controller);
                    break;
                case "2":
                    controller.listAllContent();
                    break;
                case "3":
                    String criteria = view.getUserInput("Buscar");
                    controller.searchContent(criteria);
                    break;
                case "4":
                    editContent(view, controller, model);
                    break;
                case "5":
                    String idDel = view.getUserInput("ID a eliminar");
                    controller.deleteContent(Integer.parseInt(idDel));
                    break;
                case "6":
                    String idPub = view.getUserInput("ID a publicar/despublicar");
                    controller.publishContent(Integer.parseInt(idPub));
                    break;
                case "7":
                    String type = view.getUserInput("Tipo (Article/Video/Image)");
                    controller.filterContent(type);
                    break;
                case "0":
                    running = false;
                    view.displayMessage("Hasta pronto!");
                    break;
                default:
                    view.displayMessage("Opción inválida");
            }
        }
        view.close();
    }
    
    private static void createContent(ConsoleView view, ContentController controller) {
        System.out.println("\n1. Artículo\n2. Video\n3. Imagen");
        String type = view.getUserInput("Tipo");
        
        String title = view.getUserInput("Título");
        String author = view.getUserInput("Autor");
        
        Content content = null;
        
        if (type.equals("1")) {
            String body = view.getUserInput("Texto del artículo");
            content = new Article(title, author, body);
        } else if (type.equals("2")) {
            String url = view.getUserInput("URL del video");
            content = new Video(title, author, url);
            String dur = view.getUserInput("Duración (segundos)");
            ((Video)content).setDuration(Integer.parseInt(dur));
        } else if (type.equals("3")) {
            String url = view.getUserInput("URL de la imagen");
            content = new Image(title, author, url);
        }
        
        if (content != null) {
            controller.createContent(content);
        }
    }
    
    private static void editContent(ConsoleView view, ContentController controller, ContentModel model) {
        String id = view.getUserInput("ID a editar");
        Content content = model.getContent(Integer.parseInt(id));
        
        if (content == null) {
            view.displayMessage("No encontrado");
            return;
        }
        
        String newTitle = view.getUserInput("Nuevo título (Enter=mantener)");
        if (!newTitle.isEmpty()) {
            content.setTitle(newTitle);
        }
        
        view.displayMessage("Contenido actualizado");
    }
    
    private static void loadSampleData(ContentModel model) {
        Article a1 = new Article("Programación Orientada a Objetos", "Prof. García",
            "POO es un paradigma que utiliza objetos para diseñar software. Conceptos clave: encapsulación, herencia, polimorfismo.");
        model.addContent(a1);
        if (a1 instanceof Publishable) {
            ((Publishable)a1).publish();
        }
        
        Video v1 = new Video("Tutorial Java", "Dr. Méndez", "https://youtube.com/video1");
        v1.setDuration(1800);
        model.addContent(v1);
        if (v1 instanceof Publishable) {
            ((Publishable)v1).publish();
        }
        
        Image i1 = new Image("Diagrama UML", "Ing. López", "https://ejemplo.com/uml.png");
        model.addContent(i1);
    }
}