package vehiculo;

import java.util.Arrays;

public class Autobus extends Vehiculo {

	private Persona[] pasajeros;
	private int cantidadDePasajeros;
	private int nivelCombustible;
	private final int maximoCombustible = 80;

	/*
	 * POST: cada autobus se crea con un maximo de combustible y con la cantidad de
	 * asientos que se indica por parametro. Tambien llama al metodo para
	 * inicializar los asientos
	 */
	public Autobus(String nombre, int asientos) {
		super(nombre);
		this.nivelCombustible = maximoCombustible;
		pasajeros = new Persona[asientos];
		cantidadDePasajeros = 0;
		inicializarAsientos();
	}

	@Override
	public void cargarCombustible(int combustible) {

		nivelCombustible += combustible;

		comprobarMaximo();

	}

	/*
	 * Verifica que la carga de combustible nunca sobrepase el maximo
	 */
	private void comprobarMaximo() {
		if (nivelCombustible > maximoCombustible) {
			nivelCombustible = maximoCombustible;
		}
	}

	/*
	 * Avanza la cantidad de kilometros que se le indica siempre que kms sea mayor a
	 * 0 y decrementa en 2 el nivel de combustible por cada km recorrido
	 */
	@Override
	public void avanzar(int kms) {
		if (nivelCombustible < kms) {
			System.out.println("El vehiculo no puede avanzar porque no tiene suficiente combustible");
		} else {
			super.avanzar(kms);
			nivelCombustible -= kms * 2;
		}
	}

	/*
	 * Inicializa los asientos en null
	 */
	private void inicializarAsientos() {
		for (int i = 0; i < pasajeros.length; i++) {
			pasajeros[i] = null;
		}

	}

	/*
	 * Agrega un pasajero en la posicion que se indica por parametro
	 */
	public void agregarPasajero(Persona pasajero, int asiento) {
		if (pasajeros[asiento] == null) {
			pasajeros[asiento] = pasajero;
			cantidadDePasajeros += 1;
		} else
			System.out.println("Este asiento esta ocupado");
	}

	/*
	 * Lista el array de pasajeros
	 */
	public String listarPasajeros() {

		return "Pasajeros=" + Arrays.toString(pasajeros);

	}

	/*
	 * Cambia de chofer siempre y cuando no haya ningun pasajero
	 */
	@Override
	public void cambiarChofer(Persona chofer) {
		if (cantidadDePasajeros != 0) {
			throw new Error("No se puede cambiar chofer si hay pasajeros");
		}
		asignarChofer(chofer);

	}

	/*
	 * Reinicia el array y el contador de la cantidad de pasajeros
	 */
	public void bajarPasajeros() {
		inicializarAsientos();
		cantidadDePasajeros = 0;
	}

	@Override
	public String toString() {

		return super.toString() + "\nKilometraje=[" + getKilometraje() + "]\nNivel de combustible=[" + nivelCombustible
				+ "]\n" + listarPasajeros();
	}
}
