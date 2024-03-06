package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.VehiculoDTO;

public interface IVehiculoService {
	public void guardar(Vehiculo vehiculo);
	public Vehiculo buscarPorId(Integer id);
	public void actualizar(Vehiculo vehiculo);
	public void borrar(Integer id);
	public Vehiculo buscarPorPlaca(String placa);
	public List<Vehiculo> buscarPorMarcaModelo(String marca, String modelo);
	
	public VehiculoDTO buscarDto(String noReserva);
    public List<Vehiculo> buscarDisponibles();
}