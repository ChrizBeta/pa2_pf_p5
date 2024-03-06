package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
	
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionarPorId(id));
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente seleccionarPorCedula(String cedula) {
		TypedQuery<Cliente> query =this.entityManager.createQuery("Select c From Cliente c Where c.cedula=:DatoCedula", Cliente.class);
		query.setParameter("DatoCedula", cedula);
		return query.getSingleResult();
	}


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente seleccionarCliente(String cedula) {
		TypedQuery<Cliente> myQuery= this.entityManager.createQuery("Select c from Cliente c where c.cedula= :datoCedula",Cliente.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

}
