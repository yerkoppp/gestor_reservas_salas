package model;

public class Usuario {

	private int idusuario;
	private String nombres;
	private String apellidos;
	private String run;
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	


	/**
	 * @param idusuario
	 * @param nombres
	 * @param apellidos
	 * @param run
	 */
	public Usuario(String nombres, String apellidos, String run) {
		this.idusuario = 1;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.run = run;
	}




	/**
	 * @return the idusuario
	 */
	public int getIdusuario() {
		return idusuario;
	}


	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}


	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the run
	 */
	public String getRun() {
		return run;
	}


	/**
	 * @param run the run to set
	 */
	public void setRun(String run) {
		this.run = run;
	}


	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombres=" + nombres + ", apellidos=" + apellidos + ", run=" + run
				+ "]";
	}
	
	

}
