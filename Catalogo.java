import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * Esta clase servirá como catálogo de series, pudiendo realizar
 * distintas modificaciones a los datos de las mismas.
 *
 * @author Jorge Jaular Lasaga
 * @version 24/01/2018
 */
public class Catalogo
{
    // Atributo que almacenará las series en el catálogo.
    private ArrayList<SerieTV> series;
    // Contador de producto.
    private int contadorProducto;
    /**
     * Constructor for objects of class Catálogo
     */
    public Catalogo()
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
        if(series.size() > 0) {
            int contador = 0;
            while(contador < series.size()) {
                System.out.println(series.get(contador).getDatosSerie());
                contador++;
            }
        }
    }
    
    /**
     * Muestra por pantalla las series ordenadas de 
     * mayor a menor por el número de temporadas.
     */
    public void mostrarSeriesOrdenadasPorTemporada()
    {
        ArrayList<SerieTV> seriesOrdenadasPorTemporada = new ArrayList<SerieTV>();
        ArrayList<SerieTV> seriesAlmacenadas = new ArrayList<SerieTV>();
        seriesAlmacenadas.addAll(series);
        boolean salirDelBucle = false;
        if(series.size() > 0) {
            while (seriesAlmacenadas.size() != 0 && !salirDelBucle) {
                seriesOrdenadasPorTemporada.addAll(serieDeMayorTemporada(series)); 
                salirDelBucle = true;
            }
            for (SerieTV serie : series) {
                System.out.println(serie.getDatosSerie());
            }
        }
    }
    
    public ArrayList<SerieTV> serieDeMayorTemporada(ArrayList<SerieTV> coleccion)
    {
        ArrayList<SerieTV> serieDeMasTemporadas = new ArrayList<SerieTV>();
        int maxTemporada = 0;
        if (coleccion.size() > 0) {
            for (SerieTV serie : coleccion) {
                if (serie.getNumTemporadas() > maxTemporada) {
                    maxTemporada = serie.getNumTemporadas();
                }
            }
            for (int i = 0; i < coleccion.size(); i++) {
                if(coleccion.get(i).getNumTemporadas() == maxTemporada) {
                    serieDeMasTemporadas.add(coleccion.get(i));
                    coleccion.remove(coleccion.get(i));
                    i--;
                }
            }
        }
        return serieDeMasTemporadas;
    }
    
    /**
     * Permite cambiar el n�mero de temporadas de una temporada a partir de su c�digo.
     */
    public void cambiarNumTemporadas(int idSerie, int nuevoNumTemporadas)
    {        
        if (series.size() >= idSerie && idSerie >= 0) {
            SerieTV serieACambiarTemporadas = series.get(idSerie - 1);
            serieACambiarTemporadas.setNumTemporadas(nuevoNumTemporadas);    
        }
    }
    
    /**
     * Permite borrar una serie a partir del n�mero de temporadas introducido con un iterador.
     */
    public void eliminarSerieConUnNumeroDeterminadoDeTemporadas(int numTemporadas)
    {
        Iterator<SerieTV> it = series.iterator();
        while (it.hasNext()) {
            SerieTV t = it.next();
            int temporadasSerie = t.getNumTemporadas();
            if (temporadasSerie == numTemporadas) {
                it.remove();
            }
        }
    }
}
