package com.example.demo.repository.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ReservaDTO {
	

	private String numeroReserva;
	
	private LocalDate fechaCobro;
	
	private String estado;
	
	private BigDecimal valorSubtotal;
	
	private BigDecimal valorTotal;
	
	private String cedulaClie;
	
	private String nombreClie;

	private String apellidoClie;
	
	private String placaVehi;

	private String modeloVehi;
	
	public ReservaDTO() {
		// TODO Auto-generated constructor stub
	}
	



	public ReservaDTO(String numeroReserva, LocalDate fechaCobro, String estado, BigDecimal valorSubtotal,
			BigDecimal valorTotal, String cedulaClie, String nombreClie, String apellidoClie, String placaVehi,
			String modeloVehi) {
		super();
		this.numeroReserva = numeroReserva;
		this.fechaCobro = fechaCobro;
		this.estado = estado;
		this.valorSubtotal = valorSubtotal;
		this.valorTotal = valorTotal;
		this.cedulaClie = cedulaClie;
		this.nombreClie = nombreClie;
		this.apellidoClie = apellidoClie;
		this.placaVehi = placaVehi;
		this.modeloVehi = modeloVehi;
	}





	public LocalDate getFechaCobro() {
		return fechaCobro;
	}


	public void setFechaCobro(LocalDate fechaCobro) {
		this.fechaCobro = fechaCobro;
	}





	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCedulaClie() {
		return cedulaClie;
	}

	public void setCedulaClie(String cedulaClie) {
		this.cedulaClie = cedulaClie;
	}

	public String getNombreClie() {
		return nombreClie;
	}

	public void setNombreClie(String nombreClie) {
		this.nombreClie = nombreClie;
	}

	public String getApellidoClie() {
		return apellidoClie;
	}

	public void setApellidoClie(String apellidoClie) {
		this.apellidoClie = apellidoClie;
	}

	public String getPlacaVehi() {
		return placaVehi;
	}

	public void setPlacaVehi(String placaVehi) {
		this.placaVehi = placaVehi;
	}

	public String getModeloVehi() {
		return modeloVehi;
	}

	public void setModeloVehi(String modeloVehi) {
		this.modeloVehi = modeloVehi;
	}





	public BigDecimal getValorSubtotal() {
		return valorSubtotal;
	}





	public void setValorSubtotal(BigDecimal valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}
	
	

	
	
	
	
	

}
