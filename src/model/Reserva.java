package model;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva {

	private int idreserva;
	private int idsala;
	private int idusuario;
	private LocalDate fechaCreacion;
	private LocalDate fechaReserva;
	
	public Reserva() {
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
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaReserva
	 */
	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	/**
	 * @param fechaReserva the fechaReserva to set
	 */
	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idreserva=" + idreserva + ", idsala=" + idsala + ", idusuario=" + idusuario
				+ ", fechaCreacion=" + fechaCreacion + ", fechaReserva=" + fechaReserva + "]";
	}
	
	
	
	

}
