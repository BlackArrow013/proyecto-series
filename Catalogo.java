import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
    public Catalogo(String nombreArchivo)
    {
        // Inicializamos el atributo en el constructor.
        series = new ArrayList<SerieTV>();
        contadorProducto = 01;
        try {
            File archivo = new File(nombreArchivo);
            Scanner sc = new Scanner(archivo);            
            while (sc.hasNextLine()) {  
                String[] objeto = sc.nextLine().split(" # ");
                String titulo = objeto[0];
                int numeroTemporadas = Integer.parseInt(objeto[1]);
                int ano = Integer.parseInt(objeto[2]);
                int mes = Integer.parseInt(objeto[3]);
                int dia = Integer.parseInt(objeto[4]);
                addSerie(titulo, numeroTemporadas, ano, mes, dia);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        ArrayList<SerieTV> copiaListadoSeries = new ArrayList(series);        
        while (copiaListadoSeries.size() > 0) {
            copiaListadoSeries = serieDeMayorTemporada(copiaListadoSeries);
        }
    }

    /**
     * Muestra por pantalla las series ordenadas fecha de estreno.
     */
    public void mostrarSeriesOrdenadasPorFechaDeEstreno()
    {
        ArrayList<SerieTV> copiaListadoSeries = new ArrayList(series);        
        while (copiaListadoSeries.size() > 0) {
            copiaListadoSeries = serieOrdenadasPorFecha(copiaListadoSeries);
        }
    }

    public ArrayList<SerieTV> serieDeMayorTemporada(ArrayList<SerieTV> coleccion)
    {
        SerieTV serieDeMayorTemporada = null;
        int posicionSerieConMasTemporadas = -1;
        int numTemporadasReferencia = 0;       
        int posicion = 0;
        for (SerieTV serie : series){
            if (serie.getNumTemporadas() >= numTemporadasReferencia){
                numTemporadasReferencia = serie.getNumTemporadas();
                serieDeMayorTemporada = serie;
                posicionSerieConMasTemporadas = posicion;
            }
            posicion++;
        }              
        System.out.println(serieDeMayorTemporada);
        coleccion.remove(posicionSerieConMasTemporadas);
        return coleccion;        
    }

    public ArrayList<SerieTV> serieOrdenadasPorFecha(ArrayList<SerieTV> coleccion)
    {
        SerieTV serieMasAntigua = null;
        int posicionSerieMasAntigua = -1;
        LocalDate numFechaReferencia = null;       
        int posicion = 0;
        for (SerieTV serie : series){
            if (serie.getFechaEstreno().isBefore(numFechaReferencia)){
                numFechaReferencia = serie.getFechaEstreno();
                serieMasAntigua = serie;
                posicionSerieMasAntigua = posicion;
            }
            posicion++;
        }              
        System.out.println(serieMasAntigua);
        coleccion.remove(posicionSerieMasAntigua);
        return coleccion;        
    }

    /**
     * Permite cambiar el n�mero de temporadas de una temporada a partir de su c�digo.
     */
    public void cambiarNumTemporadas(int idSerie, int nuevoNumTemporadas)
    {        
        int contador = 0;
        boolean seCambioElNumTemporadas = false;
        while (contador < series.size() && !seCambioElNumTemporadas) {
            if (series.get(contador).getCodigoProducto() == idSerie) {
                series.get(contador).setNumTemporadas(nuevoNumTemporadas);
                seCambioElNumTemporadas = true;    
            }
            contador++;
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
