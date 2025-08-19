package model;


public class Sala {

	private int idsala;
	private String nombre;
	private int capacidad;
	
	public Sala() {
		// TODO Auto-generated constructor stub
	}
	
	public Sala(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	
	/**
	 * @return the idsala
	 */
	public int getIdsala() {
		return idsala;
	}

	/**
	 * @param idsala the idsala to set
	 */
	public void setIdsala(int idsala) {
		this.idsala = idsala;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"⚠️ El nombre son obligatorio.");
		}
		try {
			this.nombre = Validacion.validarLargoString(nombre, 1, 30);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					"Nombre inválidos: " + e.getMessage());
		}
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	

	@Override
	public String toString() {
		return "Sala [idsala=" + idsala + ", nombre=" + nombre + ", capacidad=" + capacidad + "]";
	}

	


}
