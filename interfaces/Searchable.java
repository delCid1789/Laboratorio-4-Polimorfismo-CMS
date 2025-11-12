import java.util.List;

public interface Searchable {
    List<Content> search(String criteria);
    List<Content> filter(String type);
}