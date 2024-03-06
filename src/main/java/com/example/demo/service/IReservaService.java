package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Reserva;


import com.example.demo.repository.modelo.dto.ReservaDTO;



public interface IReservaService {
	public void actualizar(Reserva reserva);
	public String reservarVehiculo(String placa,String cedula,LocalDate fechaInicio,LocalDate fechaFin, String numTarjeta);

	public Reserva cambiarEstadoReserva(String numeroReserva);
	public Reserva buscarPorReserva(String numeroReserva);
	
	public LocalDate obtenerFechaDisponible(String placa, LocalDate fechaInicio, LocalDate fechaFin);
	public BigDecimal valorTotalAPagar(String placa, LocalDate fechaInicio, LocalDate fechaFin);
	
	public List<ReservaDTO> reporteReservas(LocalDate fechaInicio, LocalDate fechaFin);

	
}
