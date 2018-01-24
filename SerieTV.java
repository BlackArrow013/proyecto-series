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
    // El código identificativo del producto.
    private int codigoProducto;
    /**
     * Constructor de la clase SerieTV
     */
    public SerieTV(String titulo, int numeroTemporadas, int ano, int mes, int dia)
    {
        this.titulo = titulo;
        numTemporadas = numeroTemporadas;
        fechaEstreno = LocalDate.of(ano, mes, dia);
        codigoProducto = 01;
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
    
    /**
     * Devuelve el código del producto.
     */
    public int getCodigoProducto()
    {
        return codigoProducto;
    }
    
    /**
     * Cambia el título de una serie.
     */
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;    
    }
    
    /**
     * Cambia el número de temporadas de una serie.
     */
    public void setNumTemporadas(int numeroDeTemporadas)
    {
        numTemporadas = numeroDeTemporadas;
    }
    
    /**
     * Cambia la fecha de estreno de una serie.
     */
    public void setFechaEstreno(int year, int month, int day)
    {
        fechaEstreno = LocalDate.of(year, month, day);
    } 
    
    /**
     * Devuelve toda la información de la serie en formato String.
     */
    public String getDatosSerie()
    {
        String datosSerie = "Título: " + titulo + " - Número de Temporadas: " + numTemporadas + ", fecha de estreno en " + fechaEstreno;
        return datosSerie;
    }
}
