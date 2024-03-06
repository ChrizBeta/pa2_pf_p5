package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Reserva;

import com.example.demo.repository.modelo.dto.ReservaDTO;


public interface IReservaRepository {
	public void insertar(Reserva reserva);
	public Reserva seleccionarPorId(Integer id);
	public void actualizar(Reserva reserva);
	public void eliminar(Integer id);
	
	public List<Reserva> seleccionarListaPorPlacaV(String placa);
    public Reserva seleccionarPorNoReserva(String numeroReserva);
	public List<ReservaDTO> seleccionarListaPorFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
