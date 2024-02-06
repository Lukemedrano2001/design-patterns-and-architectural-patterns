package gof.estruturais.proxy.video;

public class Video {
	public String id;
    public String titulo;
    public String dado;

    public Video(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.dado = "Video Aleatório.";
    }
}