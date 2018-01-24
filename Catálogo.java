import java.util.ArrayList;
/**
 * Esta clase servirá como catálogo de series, pudiendo realizar
 * distintas modificaciones a los datos de las mismas.
 *
 * @author Jorge Jaular Lasaga
 * @version 24/01/2018
 */
public class Catálogo
{
    // Atributo que almacenará las series en el catálogo.
    private ArrayList<SerieTV> series;

    /**
     * Constructor for objects of class Catálogo
     */
    public Catálogo()
    {
        // Inicializamos el atributo en el constructor.
        series = new ArrayList<SerieTV>();
    }

    /**
     * Permite añadir objetos de la clase SerieTV al catálogo.
     */
    public void addSerie(String titulo, int numeroTemporadas, int ano, int mes, int dia)
    {
        SerieTV nuevaSerie = new SerieTV(titulo, numeroTemporadas, ano, mes, dia);
        series.add(nuevaSerie);
    }
}
