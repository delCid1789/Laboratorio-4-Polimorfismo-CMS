import java.util.List;

public interface CMSView {
    void displayContent(Content content);
    void displayContentList(List<Content> contents);
    void displayMessage(String message);
    String getUserInput(String prompt);
}