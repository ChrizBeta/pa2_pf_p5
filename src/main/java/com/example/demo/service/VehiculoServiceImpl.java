package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.VehiculoDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Vehiculo vehiculo) {
		this.iVehiculoRepository.insertar(vehiculo);
	}

	@Override
	
	public Vehiculo buscarPorId(Integer id) {
		return this.iVehiculoRepository.seleccionarPorId(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Vehiculo vehiculo) {
		this.iVehiculoRepository.actualizar(vehiculo);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void borrar(Integer id) {
		this.iVehiculoRepository.eliminar(id);
	}

	@Override
	
	public List<Vehiculo> buscarPorMarcaModelo(String marca, String modelo) {

		return this.iVehiculoRepository.seleccionarPorMarcaModelo(marca, modelo);
	}

	@Override
	
	public Vehiculo buscarPorPlaca(String placa) {

		return this.iVehiculoRepository.seleccionarPorPlaca(placa);
	}

	@Override
	
	public VehiculoDTO buscarDto(String noReserva) {

		return this.iVehiculoRepository.seleccionarDTO(noReserva);
	}

	@Override

	public List<Vehiculo> buscarDisponibles() {
	
		return this.iVehiculoRepository.seleccionarDisponibles();
	}

}