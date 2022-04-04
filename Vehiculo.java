package vehiculo;

public abstract class Vehiculo implements cargaDeCombustible {

	private Persona chofer;
	private String nombre;
	private int kilometraje;

	/*
	 * Post: Los vehiculos se crean sin chofer asignado y con el kilometraje en 0
	 */
	public Vehiculo(String nombre) {
		this.nombre = nombre;
		this.chofer = null;
		kilometraje = 0;

	}

	/*
	 * Asigna un chofer al vehiculo
	 */
	public void asignarChofer(Persona chofer) {
		this.chofer = chofer;
	}

	/*
	 * Avanza la cantidad de kilometros que se le indica siempre que kms sea mayor a
	 * 0
	 */
	public void avanzar(int kms) {
		if (kms > 0)
			kilometraje += kms;
	}

	public abstract void cambiarChofer(Persona chofer);

	@Override
	public String toString() {
		return "Nombre=[" + nombre + "]\nChofer=[" + chofer + "]";
	}

	public int getKilometraje() {
		return kilometraje;
	}

}
