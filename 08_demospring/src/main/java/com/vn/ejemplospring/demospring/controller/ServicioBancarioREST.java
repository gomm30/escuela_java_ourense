package com.vn.ejemplospring.demospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vn.ejemplospring.demospring.modelo.CuentaBanc;
import com.vn.ejemplospring.demospring.modelo.CuentasDAOpanama;

@RestController
@CrossOrigin(origins = "*")
public class ServicioBancarioREST {

	// Nosotros NO instanciamos, lo hace Spring
	// Nosotros NO gestionamos la dependencia, lo hace Spring
	// Nosotros NO asignamos el valor, lo hace Spring
	// Esto es la inyección de dependencias.
	@Autowired
	private CuentasDAOpanama repo;

	// Nos permite capturar varios métodos HTTP
	@RequestMapping(path = "/cuentas", method = RequestMethod.POST)
	// Sólo el método POST
	// @PostMapping
	public CuentaBanc crearCuentaAingenuo(@RequestBody CuentaBanc cuenta) {
		System.out.println(cuenta.toString());
		System.out.println(">>>> CuentaBanc recibida: " + cuenta.toString());
		return repo.save(cuenta);
	}

	@RequestMapping(path = "/cuentas", method = RequestMethod.GET)
	public List<CuentaBanc> obtenerTodas() {
		System.out.println(">>>> GET todas cuentas");
		return repo.findAll();
	}

	@DeleteMapping(path = "/cuentas/{id}")
	public void eliminarCuenta(@PathVariable Integer id) {
		System.out.println(">>>> DELETE " + id);
		repo.deleteById(id);
	}
	
	//TODO: Hacer el PUT para modificar
	@PutMapping(path = "/cuentas/{id}")
	public CuentaBanc modificarCuenta(@PathVariable Integer id, @RequestBody CuentaBanc cuentaModif) {
		if(cuentaModif.getId() == id) {
			System.out.println(">>>> PUT/Modificar " + id);
			return repo.save(cuentaModif);
			
		}else {
			System.out.println(">>>> PUT/Modificar " + id + " e " + cuentaModif.getId() + " no son iguales.");
			return null;
		}
	}
}
