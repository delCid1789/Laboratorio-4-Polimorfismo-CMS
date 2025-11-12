import java.util.List;

public interface Categorizable {
    void addCategory(Category category);
    void removeCategory(Category category);
    List<Category> getCategories();
}