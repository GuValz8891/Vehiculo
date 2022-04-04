package vehiculo;

public class Motocicleta extends Vehiculo {

	private Persona acompañante;
	private int nivelCombustible;
	private final int maximoCombustible = 20;

	/*
	 * POST: Cada motocicleta se crea con un maximo de combustible y sin acompañante
	 */
	public Motocicleta(String nombre) {
		super(nombre);
		this.nivelCombustible = maximoCombustible;
		acompañante = null;
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
		if (nivelCombustible <= kms) {
			System.out.println("El vehiculo no puede avanzar porque no tiene suficiente combustible");
		} else {
			super.avanzar(kms);
			nivelCombustible -= kms * 2;
		}
	}

	/*
	 * Cambia de chofer siempre y cuando no haya un acompañante asignado
	 */
	@Override
	public void cambiarChofer(Persona chofer) {
		if (acompañante != null) {
			System.out.println("No se puede cambiar chofer si hay un acompañante");
		} else {
			asignarChofer(chofer);
		}
	}

	/*
	 * Asigna un acompañante
	 */
	public void asignarCompañante(Persona acompañante) {
		this.acompañante = acompañante;
	}

	/*
	 * Baja del vehiculo al acompañante
	 */
	public void bajarAcompañante() {
		this.acompañante = null;
	}

	/*
	 * Muestra el nombre del acompañante
	 */
	public String mostrarAcompañante() {
		return "Acompañante=[" + acompañante + "]";
	}

	@Override
	public String toString() {

		return super.toString() + "\nKilometraje=[" + getKilometraje() + "]\nNivel de combustible=[" + nivelCombustible
				+ "]\n" + mostrarAcompañante();
	}

}
