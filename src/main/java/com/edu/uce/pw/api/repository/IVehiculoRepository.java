package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public void insertar(Vehiculo vehiculo);
	
	public Vehiculo buscarPorPlaca(String placa);
	
	public List<Vehiculo> buscarTodos();
	
	public void eliminar(String placa);

}
