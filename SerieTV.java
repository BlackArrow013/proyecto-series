import java.time.LocalDate;
/**
 * Crea un objeto que almacena una serie de TV y su estado. 
 *
 * @author Jorge Jaular Lasaga
 * @version 24/01/2018
 */
public class SerieTV
{
    // Título de la película.
    private String titulo;
    // El número de la temporada.
    private int temporada;
    // La fecha de estreno de la serie.
    private LocalDate fechaEstreno;
    /**
     * Constructor for objects of class SerieTV
     */
    public SerieTV(String titulo)
    {
        this.titulo = titulo;
        temporada = 0;
        fechaEstreno = null;
    }    
}
