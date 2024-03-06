package com.example.demo.repository.modelo;

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
@Table(name="cliente")
public class Cliente {
	@GeneratedValue(generator = "seq_cliente",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_cliente",sequenceName ="seq_cliente",allocationSize = 1 )
	@Id
	@Column(name="clie_id")
	private Integer id;
	
	@Column(name="clie_cedula")
	private String cedula;
	
	@Column(name="clie_nombre")
	private String nombre;
	
	@Column(name="clie_apellido")
	private String apellido;
	
	@Column(name="clie_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name="clie_genero")
	private Character genero;
	
	@Column(name="clie_registro")
	private Character registro;
	
	@OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
	private List<Reserva> resevas;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public Character getRegistro() {
		return registro;
	}

	public void setRegistro(Character registro) {
		this.registro = registro;
	}

	public List<Reserva> getResevas() {
		return resevas;
	}

	public void setResevas(List<Reserva> resevas) {
		this.resevas = resevas;
	}
	
	
	

}
