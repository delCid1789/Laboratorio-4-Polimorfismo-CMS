import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContentModel implements Searchable {
    private List<Content> contents;
    
    public ContentModel() {
        this.contents = new ArrayList<>();
    }
    
    public void addContent(Content content) {
        contents.add(content);
    }
    
    public void removeContent(int id) {
        Content content = getContent(id);
        if (content != null) {
            contents.remove(content);
        }
    }
    
    public void updateContent(int id, Content updatedContent) {
        Content content = getContent(id);
        if (content != null) {
            int index = contents.indexOf(content);
            contents.set(index, updatedContent);
        }
    }
    
    public Content getContent(int id) {
        return contents.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public List<Content> getAllContents() {
        return new ArrayList<>(contents);
    }
    
    @Override
    public List<Content> search(String criteria) {
        if (criteria == null || criteria.isEmpty()) {
            return new ArrayList<>(contents);
        }
        
        String lower = criteria.toLowerCase();
        return contents.stream()
                .filter(c -> c.getTitle().toLowerCase().contains(lower) ||
                            c.getAuthor().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Content> filter(String type) {
        if (type == null || type.isEmpty()) {
            return new ArrayList<>(contents);
        }
        
        return contents.stream()
                .filter(c -> c.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}