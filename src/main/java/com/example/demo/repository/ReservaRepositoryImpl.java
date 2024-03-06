package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Reserva;

import com.example.demo.repository.modelo.dto.ReservaDTO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ReservaRepositoryImpl implements IReservaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Reserva reserva) {
		this.entityManager.persist(reserva);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Reserva seleccionarPorId(Integer id) {
		return this.entityManager.find(Reserva.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Reserva reserva) {
		this.entityManager.merge(reserva);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionarPorId(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Reserva> seleccionarListaPorPlacaV(String placa) {
		TypedQuery<Reserva> query= this.entityManager.createQuery("SELECT r FROM Reserva r JOIN FETCH r.vehiculo v WHERE v.placa =:datoPlaca"
				,Reserva.class);
		query.setParameter("datoPlaca", placa);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Reserva seleccionarPorNoReserva(String numeroReserva) {
		TypedQuery<Reserva> query= this.entityManager.createQuery("Select r From Reserva r Where r.numeroReserva=:DatoNumero",Reserva.class);
		query.setParameter("DatoNumero", numeroReserva);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<ReservaDTO> seleccionarListaPorFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		TypedQuery<ReservaDTO> query=this.entityManager.createQuery("SELECT new com.example.demo.repository.modelo.dto.ReservaDTO(r.numeroReserva,"
				+ "r.fechaCobro,r.estado,r.valorSubtotal,r.valorTotal,"
				+ "c.cedula,c.nombre,c.apellido,v.placa,v.modelo)"
				+ " FROM Reserva r "
				+ " JOIN  r.cliente c "
				+ " JOIN  r.vehiculo v "
				+ " WHERE r.fechaCobro "
				+ " BETWEEN :DatoFechaInicio AND :DatoFechaFin",
				ReservaDTO.class);
		query.setParameter("DatoFechaInicio", fechaInicio);
		query.setParameter("DatoFechaFin", fechaFin);
		return query.getResultList();
	}


}