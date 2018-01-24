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
    // Contador de producto.
    private int contadorProducto;
    /**
     * Constructor for objects of class Catálogo
     */
    public Catálogo()
    {
        // Inicializamos el atributo en el constructor.
        series = new ArrayList<SerieTV>();
        contadorProducto = 01;
    }

    /**
     * Permite añadir objetos de la clase SerieTV al catálogo.
     */
    public void addSerie(String titulo, int numeroTemporadas, int ano, int mes, int dia)
    {
        SerieTV nuevaSerie = new SerieTV(titulo, numeroTemporadas, ano, mes, dia, contadorProducto);
        series.add(nuevaSerie);
        contadorProducto++;
    }
    
    /**
     * Muestra por pantalla las series añadidas al catálogo.
     */
    public void mostrarSeries()
    {
        int contador = 0;
        while(contador < series.size()) {
            System.out.println(series.get(contador).getDatosSerie());
            contador++;
        }
    }
    
    /**
     * Muestra por pantalla las series ordenadas de 
     * mayor a menor por el número de temporadas.
     */
    public void mostrarSeriesOrdenadasPorTemporada()
    {
        ArrayList<SerieTV> serieFinal = new ArrayList<>();
        SerieTV serieActual = new SerieTV("", 0, 1, 1, 1, 0);
        for (SerieTV serie : series) {
            if(serie.getNumTemporadas() > serieActual.getNumTemporadas()) {
                serieFinal.clear();
                serieFinal.add(serie);
            }
            System.out.println(serieActual.getDatosSerie());
        }
    }
    
}
