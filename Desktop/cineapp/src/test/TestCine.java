package test;
import cineapp.*;

public class TestCine {

	public static void main(String[] args) {

        Pelicula estreno = new Pelicula ("Star War XXX",220,18,Genero.Aventuras);
        Cine salaKursal = new Cine (8,8,estreno,7.5f);
        
        // Creo espectadores
        Espectador juan = new Espectador ("Juan",50,21);
        Espectador luis = new Espectador ("Luis",80,22);
        Espectador ana  = new Espectador ("Ana",20,21);
        Espectador eva  = new Espectador ("Eva",20,17);  // NO tiene la edad  
        Espectador pio  = new Espectador ("Pio",5,68);   // No tiene dinero suficiente
        Espectador noa  = new Espectador ("Noa",75,27);
        Espectador leo  = new Espectador ("Leo",128,32);
        Espectador noe  = new Espectador ("Noe",200,35);
        Espectador zoe  = new Espectador ("Zoe",30, 36);
        
        vender(salaKursal,juan,luis,ana,eva,pio,noa,leo,noe,zoe);
        
        salaKursal.informeSala();
        salaKursal.listadoEspectadores();
        salaKursal.listadoAsientos();
    }
    
	/*
	 *  Ejemplo de método con parámetros variables
	 *  Tiene que ser el último del mismo tipo, se equipara a un array
	 */
    static void vender( Cine sala, Espectador... tespectadores){
        for ( Espectador esp: tespectadores){
            System.out.println(esp.getNombre()+":" +sala.venderAsiento(esp));
        }
    }

}
