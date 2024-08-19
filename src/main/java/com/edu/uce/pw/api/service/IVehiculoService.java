package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.service.to.VehiculoCompletoTO;
import com.edu.uce.pw.api.service.to.VehiculoTO;

public interface IVehiculoService {
	
	public void guardar(VehiculoCompletoTO vehiculo);
	
	public VehiculoCompletoTO buscarPorPlaca(String placa);
	
	public List<VehiculoTO> buscarTodos();
	
	public void eliminar(String placa);

}
