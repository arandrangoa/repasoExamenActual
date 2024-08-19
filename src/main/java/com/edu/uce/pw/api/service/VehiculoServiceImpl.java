package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IVehiculoRepository;
import com.edu.uce.pw.api.repository.modelo.Vehiculo;
import com.edu.uce.pw.api.service.to.VehiculoCompletoTO;
import com.edu.uce.pw.api.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public void guardar(VehiculoCompletoTO vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.insertar(this.convertirCompletoTOAVehiculo(vehiculo));
	}

	@Override
	public VehiculoCompletoTO buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		Vehiculo v=this.iVehiculoRepository.buscarPorPlaca(placa);
		return this.convertirACompletoTO(v);
	}

	@Override
	public List<VehiculoTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Vehiculo> lista=this.iVehiculoRepository.buscarTodos();
		List<VehiculoTO> listaTO=new ArrayList<>();
		
		for(Vehiculo v:lista) {
			listaTO.add(this.convertirAVehiculotTO(v));
		}
		return listaTO;
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.eliminar(placa);
	}
	
	
	private VehiculoCompletoTO convertirACompletoTO(Vehiculo vehiculo) {
		VehiculoCompletoTO v=new VehiculoCompletoTO();
		
		v.setColor(vehiculo.getColor());
		v.setId(vehiculo.getId());
		v.setMarca(vehiculo.getMarca());
		v.setModelo(vehiculo.getModelo());
		v.setPlaca(vehiculo.getPlaca());
		v.setPrecio(vehiculo.getPrecio());
		
		return v;
	}
	
	private VehiculoTO convertirAVehiculotTO(Vehiculo vehiculo) {
		
		VehiculoTO v=new VehiculoTO();
		
		v.setMarca(vehiculo.getMarca());
		v.setModelo(vehiculo.getModelo());
		v.setPlaca(vehiculo.getPlaca());
		
		return v;
	}
	
	private Vehiculo convertirCompletoTOAVehiculo(VehiculoCompletoTO vehiculo) {
		Vehiculo v=new Vehiculo();
		
		v.setColor(vehiculo.getColor());
		v.setId(vehiculo.getId());
		v.setMarca(vehiculo.getMarca());
		v.setModelo(vehiculo.getModelo());
		v.setPlaca(vehiculo.getPlaca());
		v.setPrecio(vehiculo.getPrecio());
		
		return v;
	}

}
