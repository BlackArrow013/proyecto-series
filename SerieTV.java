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
    // El número de temporadas.
    private int numTemporadas;
    // La fecha de estreno de la serie.
    private LocalDate fechaEstreno;
    /**
     * Constructor de la clase SerieTV
     */
    public SerieTV(String titulo, int numTemporadas, int ano, int mes, int dia)
    {
        this.titulo = titulo;
        this.numTemporadas = numTemporadas;
        fechaEstreno = LocalDate.of(ano, mes, dia);
    }
    
    /**
     * Devuelve el título de la serie.
     */
    public String getTitulo()
    {
        return titulo;
    }
    
    /**
     * Devuelve el número de temporadas de una serie.
     */
    public int getNumTemporadas()
    {
        return numTemporadas;
    }
    
    /**
     * Devuelve la fecha de estreno de la serie.
     */
    public LocalDate getFechaEstreno()
    {
        return fechaEstreno;
    }
}
