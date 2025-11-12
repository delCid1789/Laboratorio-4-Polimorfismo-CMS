public class Image extends Content implements Publishable {
    private String imageUrl;
    private String altText;
    private String dimensions;
    
    public Image(String title, String author, String imageUrl) {
        super(title, author);
        this.imageUrl = imageUrl;
        this.altText = "";
        this.dimensions = "0x0";
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getAltText() {
        return altText;
    }
    
    public void setAltText(String altText) {
        this.altText = altText;
    }
    
    public String getDimensions() {
        return dimensions;
    }
    
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    
    @Override
    public String display() {
        return "ID: " + id + "\nTítulo: " + title + "\nAutor: " + author + 
               "\nURL: " + imageUrl + "\nTexto Alt: " + altText + 
               "\nDimensiones: " + dimensions + "\nPublicado: " + (published ? "Sí" : "No");
    }
    
    @Override
    public boolean validate() {
        return title != null && !title.isEmpty() && 
               author != null && !author.isEmpty() && 
               imageUrl != null && !imageUrl.isEmpty();
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