package model;

import java.sql.Date;

public class Reserva {

	private int idreserva;
	private int idsala;
	private int idusuario;
	private Date fechaCreacion;
	private Date fechaReserva;
	
	public Reserva() {
	}
	
	

	/**
	 * @param idreserva
	 * @param idsala
	 * @param idusuario
	 * @param fechaCreacion
	 * @param fechaReserva
	 */
	public Reserva(int idsala, int idusuario, Date fechaCreacion, Date fechaReserva) {

		this.idreserva = 1;
		this.idsala = idsala;
		this.idusuario = idusuario;
		this.fechaCreacion = fechaCreacion;
		this.fechaReserva = fechaReserva;
	}



	/**
	 * @return the idreserva
	 */
	public int getIdreserva() {
		return idreserva;
	}

	/**
	 * @param idreserva the idreserva to set
	 */
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
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
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaReserva
	 */
	public Date getFechaReserva() {
		return fechaReserva;
	}

	/**
	 * @param fechaReserva the fechaReserva to set
	 */
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idreserva=" + idreserva + ", idsala=" + idsala + ", idusuario=" + idusuario
				+ ", fechaCreacion=" + fechaCreacion + ", fechaReserva=" + fechaReserva + "]";
	}
	
	
	
	

}
