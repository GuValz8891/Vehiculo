package vehiculo;

public class Demo {

	public static void main(String[] args) {

		/*
		 * Demo motocicleta
		 */

		Motocicleta moto = new Motocicleta("Moto");
		Persona motoquero = new Persona("Cacho");
		Persona otroMotoquero = new Persona("Cacho2");
		Persona acompañante = new Persona("Roberto");
		System.out.println(moto);
		System.out.println("///////////////////////////////////////////");
		moto.asignarChofer(motoquero);
		System.out.println(moto);
		System.out.println("///////////////////////////////////////////");
		moto.asignarCompañante(acompañante);
		System.out.println(moto);
		System.out.println("///////////////////////////////////////////");
		moto.cambiarChofer(otroMotoquero);
		System.out.println("///////////////////////////////////////////");
		moto.bajarAcompañante();
		moto.cambiarChofer(otroMotoquero);
		System.out.println(moto);
		System.out.println("///////////////////////////////////////////");
		moto.avanzar(2);
		System.out.println(moto);

		/*
		 * Demo autobus
		 */

		System.out.println("///////////////////////////////////////////");
		Autobus bondi = new Autobus("Bondi", 5);
		Persona colectivero = new Persona("Cacho");

		Persona pasajero1 = new Persona("Pedro");
		Persona pasajero2 = new Persona("Silvia");
		Persona pasajero3 = new Persona("Mauro");
		Persona pasajero4 = new Persona("Paula");
		System.out.println(bondi);
		System.out.println("///////////////////////////////////////////");
		bondi.asignarChofer(colectivero);
		bondi.agregarPasajero(pasajero1, 0);
		bondi.agregarPasajero(pasajero2, 1);
		bondi.agregarPasajero(pasajero3, 2);
		bondi.agregarPasajero(pasajero4, 3);
		System.out.println(bondi);
		System.out.println("///////////////////////////////////////////");
		bondi.agregarPasajero(pasajero2, 3);
		bondi.bajarPasajeros();
		System.out.println(bondi);
	}

}
