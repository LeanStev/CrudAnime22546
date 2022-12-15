
package dominio;


public class Anime {
    private int idanime;
    private String Nombre;
    private String Autor;
    private int Capitulos;
    private int Finalizado;
    
    public Anime(){}

    public Anime(int idanime) {
        this.idanime = idanime;
    }


    public Anime(String Nombre, String Autor, int Capitulos, int Finalizado) {
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.Capitulos = Capitulos;
        this.Finalizado = Finalizado;
    }

    public Anime(int IdAnime, String Nombre, String Autor, int Capitulos, int Finalizado) {
        this.idanime = IdAnime;
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.Capitulos = Capitulos;
        this.Finalizado = Finalizado;
    }

    public int getidanime() {
        return idanime;
    }

    public void setidanime(int IdAnime) {
        this.idanime = IdAnime;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
   
    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getCapitulos() {
        return Capitulos;
    }

    public void setCapitulos(int Capitulos) {
        this.Capitulos = Capitulos;
    }

    public int getFinalizado() {
        return Finalizado;
    }

    public void setFinalizado(int Finalizado) {
        this.Finalizado = Finalizado;
    }

     @Override
    public String toString() {
        return "Anime{" + "IdAnime=" + idanime + ", Nombre=" + Nombre + ", Autor=" + Autor + ", Capitulos=" + Capitulos + ", Finalizado=" + Finalizado + "}";
    }
    
    
}
