package vehiculo;

public class Motocicleta extends Vehiculo {

	private Persona acompa�ante;
	private int nivelCombustible;
	private final int maximoCombustible = 20;

	/*
	 * POST: Cada motocicleta se crea con un maximo de combustible y sin acompa�ante
	 */
	public Motocicleta(String nombre) {
		super(nombre);
		this.nivelCombustible = maximoCombustible;
		acompa�ante = null;
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
	 * Cambia de chofer siempre y cuando no haya un acompa�ante asignado
	 */
	@Override
	public void cambiarChofer(Persona chofer) {
		if (acompa�ante != null) {
			System.out.println("No se puede cambiar chofer si hay un acompa�ante");
		} else {
			asignarChofer(chofer);
		}
	}

	/*
	 * Asigna un acompa�ante
	 */
	public void asignarCompa�ante(Persona acompa�ante) {
		this.acompa�ante = acompa�ante;
	}

	/*
	 * Baja del vehiculo al acompa�ante
	 */
	public void bajarAcompa�ante() {
		this.acompa�ante = null;
	}

	/*
	 * Muestra el nombre del acompa�ante
	 */
	public String mostrarAcompa�ante() {
		return "Acompa�ante=[" + acompa�ante + "]";
	}

	@Override
	public String toString() {

		return super.toString() + "\nKilometraje=[" + getKilometraje() + "]\nNivel de combustible=[" + nivelCombustible
				+ "]\n" + mostrarAcompa�ante();
	}

}
