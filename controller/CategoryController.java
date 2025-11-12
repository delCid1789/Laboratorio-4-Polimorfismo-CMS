import java.util.List;
import java.util.ArrayList;

/**
 * Clase CategoryController
 * Controlador que gestiona todas las operaciones relacionadas con categorías
 */
public class CategoryController {
    private List<Category> categories;
    private CMSView view;
    
    /**
     * Constructor de CategoryController
     * @param view vista del sistema
     */
    public CategoryController(CMSView view) {
        this.categories = new ArrayList<>();
        this.view = view;
        initializeDefaultCategories();
    }
    
    /**
     * Inicializa categorías por defecto
     */
    private void initializeDefaultCategories() {
        categories.add(new Category("Tecnología", "Contenido relacionado con tecnología"));
        categories.add(new Category("Educación", "Material educativo y académico"));
        categories.add(new Category("Ciencia", "Contenido científico"));
        categories.add(new Category("Arte", "Contenido artístico y creativo"));
        categories.add(new Category("Deportes", "Contenido deportivo"));
    }
    
    /**
     * Crea una nueva categoría
     * @param name nombre de la categoría
     * @param description descripción de la categoría
     * @return la categoría creada
     */
    public Category createCategory(String name, String description) {
        if (name == null || name.trim().isEmpty()) {
            view.displayMessage("Error: El nombre de la categoría no puede estar vacío.");
            return null;
        }
        
        // Verificar si ya existe
        for (Category cat : categories) {
            if (cat.getName().equalsIgnoreCase(name)) {
                view.displayMessage("Error: Ya existe una categoría con ese nombre.");
                return null;
            }
        }
        
        Category category = new Category(name, description);
        categories.add(category);
        view.displayMessage("Categoría '" + name + "' creada exitosamente.");
        return category;
    }
    
    /**
     * Elimina una categoría por ID
     * @param id ID de la categoría
     */
    public void deleteCategory(int id) {
        Category category = getCategoryById(id);
        
        if (category == null) {
            view.displayMessage("Error: Categoría con ID " + id + " no encontrada.");
            return;
        }
        
        categories.remove(category);
        view.displayMessage("Categoría '" + category.getName() + "' eliminada exitosamente.");
    }
    
    /**
     * Edita una categoría existente
     * @param id ID de la categoría
     * @param newName nuevo nombre
     * @param newDescription nueva descripción
     */
    public void editCategory(int id, String newName, String newDescription) {
        Category category = getCategoryById(id);
        
        if (category == null) {
            view.displayMessage("Error: Categoría con ID " + id + " no encontrada.");
            return;
        }
        
        if (newName != null && !newName.trim().isEmpty()) {
            category.setName(newName);
        }
        
        if (newDescription != null && !newDescription.trim().isEmpty()) {
            category.setDescription(newDescription);
        }
        
        view.displayMessage("Categoría actualizada exitosamente.");
    }
    
    /**
     * Obtiene una categoría por ID
     * @param id ID de la categoría
     * @return la categoría o null si no existe
     */
    public Category getCategoryById(int id) {
        return categories.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Obtiene una categoría por nombre
     * @param name nombre de la categoría
     * @return la categoría o null si no existe
     */
    public Category getCategoryByName(String name) {
        return categories.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Obtiene todas las categorías
     * @return lista de todas las categorías
     */
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }
    
    /**
     * Muestra todas las categorías
     */
    public void listAllCategories() {
        if (categories.isEmpty()) {
            view.displayMessage("No hay categorías disponibles.");
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("  LISTA DE CATEGORÍAS (" + categories.size() + ")");
        System.out.println("========================================");
        
        for (Category category : categories) {
            System.out.println("\nID: " + category.getId() + " | Nombre: " + category.getName());
            System.out.println("Descripción: " + category.getDescription());
            System.out.println("----------------------------------------");
        }
    }
}