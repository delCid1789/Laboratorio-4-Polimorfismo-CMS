public class Article extends Content implements Publishable {
    private String bodyText;
    private int wordCount;
    
    public Article(String title, String author, String bodyText) {
        super(title, author);
        this.bodyText = bodyText;
        this.wordCount = bodyText.trim().split("\\s+").length;
    }
    
    public String getBodyText() {
        return bodyText;
    }
    
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
        this.wordCount = bodyText.trim().split("\\s+").length;
    }
    
    public int getWordCount() {
        return wordCount;
    }
    
    @Override
    public String display() {
        return "ID: " + id + "\nTítulo: " + title + "\nAutor: " + author + 
               "\nPalabras: " + wordCount + "\nPublicado: " + (published ? "Sí" : "No") + 
               "\nContenido: " + bodyText;
    }
    
    @Override
    public boolean validate() {
        return title != null && !title.isEmpty() && 
               author != null && !author.isEmpty() && 
               bodyText != null && !bodyText.isEmpty();
    }
    
    @Override
    public void publish() {
        if (validate()) {
            setPublished(true);
        }
    }
    
    @Override
    public void unpublish() {
        setPublished(false);
    }
}