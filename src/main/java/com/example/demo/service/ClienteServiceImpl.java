package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService{

	
	@Autowired
	private IClienteRepository clienteRepository;
	

	@Override
	public Cliente buscarPorId(Integer id) {
		return this.clienteRepository.seleccionarPorId(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void borrar(Integer id) {
		this.clienteRepository.eliminar(id);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarCliente(Cliente cliente) {
		cliente.setRegistro('C');
		this.clienteRepository.insertar(cliente);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarEmpleado(Cliente cliente) {
		cliente.setRegistro('E');
		this.clienteRepository.insertar(cliente);
		
	}

	
	@Override
	public Cliente buscarCliente(String cedula) {
		return this.clienteRepository.seleccionarCliente(cedula);
	}

}
