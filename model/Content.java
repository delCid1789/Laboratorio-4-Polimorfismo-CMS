import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Content implements Categorizable {
    protected static int idCounter = 1;
    protected int id;
    protected String title;
    protected String author;
    protected Date creationDate;
    protected Date lastModified;
    protected boolean published;
    protected List<Category> categories;
    
    public Content(String title, String author) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
        this.creationDate = new Date();
        this.lastModified = new Date();
        this.published = false;
        this.categories = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
        this.lastModified = new Date();
    }
    
    public String getAuthor() {
        return author;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    
    public Date getLastModified() {
        return lastModified;
    }
    
    public boolean isPublished() {
        return published;
    }
    
    protected void setPublished(boolean published) {
        this.published = published;
    }
    
    @Override
    public void addCategory(Category category) {
        if (!categories.contains(category)) {
            categories.add(category);
        }
    }
    
    @Override
    public void removeCategory(Category category) {
        categories.remove(category);
    }
    
    @Override
    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }
    
    public abstract String display();
    public abstract boolean validate();
    
    public String getType() {
        return this.getClass().getSimpleName();
    }
}