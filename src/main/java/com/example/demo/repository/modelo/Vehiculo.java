package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
	
	@GeneratedValue(generator = "seq_vehiculo",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_vehiculo",sequenceName ="seq_vehiculo",allocationSize = 1 )
	@Id
	@Column(name = "vhcl_id")
	private Integer id;
	@Column(name = "vhcl_placa")
	private String placa;
	@Column(name = "vhcl_modelo")
	private String modelo;
	@Column(name = "vhcl_marca")
	private String marca;
	@Column(name = "vhcl_anio_fabricacion")
	private LocalDate anioFabricacion;
	@Column(name = "vhcl_pais_fabricaion")
	private String paisFabricacion;
	@Column(name = "vhcl_cilindraje")
	private Double cilindraje;
	@Column(name = "vhcl_avaluo")
	private BigDecimal avaluo;
	@Column(name = "vhcl_valor_por_dia")
	private BigDecimal valorPorDia;
	@Column(name = "vhcl_estado")
	private String estado="D";

	@OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY)
	private List<Reserva> resevas;
	//SET Y GET

	public Integer getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDate getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(LocalDate anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getPaisFabricacion() {
		return paisFabricacion;
	}

	public void setPaisFabricacion(String paisFabricacion) {
		this.paisFabricacion = paisFabricacion;
	}

	public Double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
	}

	public BigDecimal getAvaluo() {
		return avaluo;
	}

	public void setAvaluo(BigDecimal avaluo) {
		this.avaluo = avaluo;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

	public List<Reserva> getResevas() {
		return resevas;
	}
	
	public void setResevas(List<Reserva> resevas) {
		this.resevas = resevas;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", valorPorDia=" + valorPorDia
				+ ", estado=" + estado + "]";
	}

	
	
	
	
}
