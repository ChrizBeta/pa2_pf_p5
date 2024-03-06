package com.example.demo.repository;


import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.VehiculoDTO;


public interface IVehiculoRepository {
	public void insertar(Vehiculo vehiculo);
	public Vehiculo seleccionarPorId(Integer id);
	public void actualizar(Vehiculo vehiculo);
	public void eliminar(Integer id);
	
	public Vehiculo seleccionarPorPlaca(String placa);
	public List<Vehiculo> seleccionarPorMarcaModelo(String marca, String modelo);
    public VehiculoDTO seleccionarDTO(String noReserva);
    public List<Vehiculo> seleccionarDisponibles();
}