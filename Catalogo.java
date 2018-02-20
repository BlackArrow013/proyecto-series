import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Esta clase servirÃ¡ como catÃ¡logo de series, pudiendo realizar
 * distintas modificaciones a los datos de las mismas.
 *
 * @author Jorge Jaular Lasaga
 * @version 24/01/2018
 */
public class Catalogo
{
    // Atributo que almacenarÃ¡ las series en el catÃ¡logo.
    private ArrayList<SerieTV> series;
    // Contador de producto.
    private int contadorProducto;
    /**
     * Constructor for objects of class CatÃ¡logo
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
     * Permite aÃ±adir objetos de la clase SerieTV al catÃ¡logo.
     */
    public void addSerie(String titulo, int numeroTemporadas, int ano, int mes, int dia)
    {
        SerieTV nuevaSerie = new SerieTV(titulo, numeroTemporadas, ano, mes, dia, contadorProducto);
        series.add(nuevaSerie);
        contadorProducto++;
    }

    /**
     * Muestra por pantalla las series aÃ±adidas al catÃ¡logo.
     */
    public void mostrarSeries()
    {
        if(series.size() > 0) {
            int contador = 0;
            while(contador < series.size()) {
                System.out.println(series.get(contador));
                contador++;
            }
        }
    }

    /**
     * Muestra por pantalla las series ordenadas de 
     * mayor a menor por el nÃºmero de temporadas.
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
     * Permite cambiar el número de temporadas de una temporada a partir de su código.
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
     * Permite borrar una serie a partir del número de temporadas introducido con un iterador.
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

    /**
     * Las series ordenadas por número de temporadas también aparecerán ordenadas alfabéticamente.
     */
    public void ordenarAlfabeticamenteLasSeriesOrdenadasPorTemporadas()
    {
        int variable = 0;
        for (int i = 0; i < series.size(); i++) {
            SerieTV serieConElMayorNumeroDeTemporadas = series.get(i);
            int posicion = i;
            for (int j = i + 1; j < series.size(); j++) {
                SerieTV serieActual = series.get(j);
                if (serieConElMayorNumeroDeTemporadas.getNumTemporadas() < serieActual.getNumTemporadas()) {
                    serieConElMayorNumeroDeTemporadas = serieActual;
                    posicion = j;
                }
                else if (serieConElMayorNumeroDeTemporadas.getNumTemporadas() == serieActual.getNumTemporadas()) {
                    if (serieConElMayorNumeroDeTemporadas.getTitulo().compareToIgnoreCase(serieActual.getTitulo()) > 0) {
                        serieConElMayorNumeroDeTemporadas = serieActual;  
                        posicion = j;
                    }
                }
            }
            if (posicion != i) {                
                SerieTV aux = series.get(i);
                series.set(i, series.get(posicion));
                series.set(posicion, aux);
            } 

            if (serieConElMayorNumeroDeTemporadas.getNumTemporadas() != variable) {
                if (serieConElMayorNumeroDeTemporadas.getNumTemporadas() == 1) {
                    System.out.println("");
                    System.out.println(serieConElMayorNumeroDeTemporadas.getNumTemporadas() + " temporada");
                }
                else {
                    System.out.println("");
                    System.out.println(serieConElMayorNumeroDeTemporadas.getNumTemporadas() + " temporadas");
                }
                variable = serieConElMayorNumeroDeTemporadas.getNumTemporadas();
            }
            System.out.println(serieConElMayorNumeroDeTemporadas);
        }    
    }

    /**
     * Ordena y diferencia el listado por número de temporadas de mayor a menor y las muestra por pantalla.
     */
    public void ordenarSeriesPorTemporadas()
    {
        int variable = 0;
        for (int i = 0; i < series.size(); i++) {
            SerieTV serieConElMayorNumeroDeTemporadas = series.get(i);
            int posicion = i;
            for (int j = i + 1; j < series.size(); j++) {
                SerieTV serieActual = series.get(j);
                if (serieConElMayorNumeroDeTemporadas.getNumTemporadas() < serieActual.getNumTemporadas()) {
                    serieConElMayorNumeroDeTemporadas = serieActual;
                    posicion = j;
                }
            }
            if (posicion != i) {                
                SerieTV aux = series.get(i);
                series.set(i, series.get(posicion));
                series.set(posicion, aux);
            } 

            if (serieConElMayorNumeroDeTemporadas.getNumTemporadas() != variable) {
                if (serieConElMayorNumeroDeTemporadas.getNumTemporadas() == 1) {
                    System.out.println("");
                    System.out.println(serieConElMayorNumeroDeTemporadas.getNumTemporadas() + " temporada");
                }
                else {
                    System.out.println("");
                    System.out.println(serieConElMayorNumeroDeTemporadas.getNumTemporadas() + " temporadas");
                }
                variable = serieConElMayorNumeroDeTemporadas.getNumTemporadas();
            }
            System.out.println(serieConElMayorNumeroDeTemporadas);
        }    
    }
}
