package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> query=this.entityManager.createQuery("select v from Vehiculo v where v.placa= :datoplaca",Vehiculo.class);
		query.setParameter("datoplaca", placa);
		return query.getSingleResult();
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> query=this.entityManager.createQuery("select v from Vehiculo v",Vehiculo.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo v=this.buscarPorPlaca(placa);
		this.entityManager.remove(v);
	}

}
