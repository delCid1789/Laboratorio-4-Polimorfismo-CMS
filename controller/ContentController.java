import java.util.List;

public class ContentController {
    private ContentModel model;
    private CMSView view;
    
    public ContentController(ContentModel model, CMSView view) {
        this.model = model;
        this.view = view;
    }
    
    public void createContent(Content content) {
        if (content.validate()) {
            model.addContent(content);
            view.displayMessage("Contenido creado exitosamente");
        } else {
            view.displayMessage("Error: El contenido no es válido");
        }
    }
    
    public void editContent(int id, Content updatedContent) {
        if (updatedContent.validate()) {
            model.updateContent(id, updatedContent);
            view.displayMessage("Contenido editado");
        } else {
            view.displayMessage("Error: Contenido no válido");
        }
    }
    
    public void deleteContent(int id) {
        model.removeContent(id);
        view.displayMessage("Contenido eliminado");
    }
    
    public void publishContent(int id) {
        Content content = model.getContent(id);
        if (content == null) {
            view.displayMessage("Contenido no encontrado");
            return;
        }
        
        if (content instanceof Publishable) {
            Publishable p = (Publishable) content;
            if (p.isPublished()) {
                p.unpublish();
                view.displayMessage("Contenido despublicado");
            } else {
                p.publish();
                view.displayMessage("Contenido publicado");
            }
        }
    }
    
    public void searchContent(String criteria) {
        List<Content> results = model.search(criteria);
        view.displayContentList(results);
    }
    
    public void filterContent(String type) {
        List<Content> results = model.filter(type);
        view.displayContentList(results);
    }
    
    public void listAllContent() {
        List<Content> contents = model.getAllContents();
        view.displayContentList(contents);
    }
    
    public void viewContent(int id) {
        Content content = model.getContent(id);
        view.displayContent(content);
    }
}