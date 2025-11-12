public class Video extends Content implements Publishable {
    private String videoUrl;
    private int duration;
    private String resolution;
    
    public Video(String title, String author, String videoUrl) {
        super(title, author);
        this.videoUrl = videoUrl;
        this.duration = 0;
        this.resolution = "1080p";
    }
    
    public String getVideoUrl() {
        return videoUrl;
    }
    
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String getResolution() {
        return resolution;
    }
    
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    
    @Override
    public String display() {
        return "ID: " + id + "\nTítulo: " + title + "\nAutor: " + author + 
               "\nURL: " + videoUrl + "\nDuración: " + duration + "s" + 
               "\nResolución: " + resolution + "\nPublicado: " + (published ? "Sí" : "No");
    }
    
    @Override
    public boolean validate() {
        return title != null && !title.isEmpty() && 
               author != null && !author.isEmpty() && 
               videoUrl != null && !videoUrl.isEmpty();
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