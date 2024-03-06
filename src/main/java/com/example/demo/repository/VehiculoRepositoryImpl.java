package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import com.example.demo.repository.modelo.dto.VehiculoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vehiculo seleccionarPorId(Integer id) {
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.merge(this.seleccionarPorId(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vehiculo seleccionarPorPlaca(String placa) {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery("Select v From Vehiculo v Where v.placa=:DatoPlaca",
				Vehiculo.class);
		query.setParameter("DatoPlaca", placa);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vehiculo> seleccionarPorMarcaModelo(String marca, String modelo) {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery(
				"Select v From Vehiculo v Where v.marca=:DatoMarca AND v.modelo=:DatoModelo", Vehiculo.class);
		query.setParameter("DatoMarca", marca);
		query.setParameter("DatoModelo", modelo);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public VehiculoDTO seleccionarDTO(String noReserva) {
		TypedQuery<VehiculoDTO> query = this.entityManager.createQuery(
				"Select new com.example.demo.repository.modelo.dto.VehiculoDTO(r.vehiculo.placa, r.vehiculo.modelo, r.cliente.cedula, r.estado,r.vehiculo.marca, r.fechaFin, r.fechaInicio, r.numeroReserva, r.vehiculo.valorPorDia ) "
						+ "From Reserva r Where r.numeroReserva=:DatoReserva",
				VehiculoDTO.class);
		query.setParameter("DatoReserva", noReserva);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vehiculo> seleccionarDisponibles() {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery("Select v From Vehiculo v Where v.estado='D'",
				Vehiculo.class);
		return query.getResultList();
	}

}