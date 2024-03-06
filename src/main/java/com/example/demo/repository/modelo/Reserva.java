package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@GeneratedValue(generator = "seq_reserva",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_reserva",sequenceName ="seq_reserva",allocationSize = 1 )
	@Id
	@Column(name="rese_id")
	private Integer id;
	
	@Column(name="rese_numero_reserva")
	private String numeroReserva;
	
	@Column(name="rese_fecha_inicio")
	private LocalDate fechaInicio;

	@Column(name="rese_fecha_cobro")
	private LocalDate fechaCobro;
	
	@Column(name="rese_fecha_fin")
	private LocalDate fechaFin;
	
	@Column(name="rese_estado")
	private String estado = "G";
	
	@Column(name="rese_valor_subtotal")
	private BigDecimal valorSubtotal;
	
	@Column(name="rese_valor_ICE")
	private BigDecimal valorICE;
	
	@Column(name="rese_valor_Total")
	private BigDecimal valorTotal;
	
	@Column(name="rese_numero_tarjeta_credito")
	private String numeroTarjetaCredito;
	
	@ManyToOne
	@JoinColumn(name="rese_clie_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="rese_vhcl_id")
	private Vehiculo vehiculo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorSubtotal() {
		return valorSubtotal;
	}

	public void setValorSubtotal(BigDecimal valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public BigDecimal getValorICE() {
		return valorICE;
	}

	public void setValorICE(BigDecimal valorICE) {
		this.valorICE = valorICE;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNumeroTarjetaCredito() {
		return numeroTarjetaCredito;
	}

	public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
		this.numeroTarjetaCredito = numeroTarjetaCredito;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public LocalDate getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(LocalDate fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
	
	
	
}
