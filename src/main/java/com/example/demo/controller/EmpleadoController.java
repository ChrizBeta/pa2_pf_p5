package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IClienteService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private IClienteService clienteService;

   
    //http://localhost:8080/empleados/principal
    @GetMapping("/principal")
	public String principal(Cliente cliente,Vehiculo vehiculo, Model modelo) {
      
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("vehiculo", vehiculo);
      
        
		return "vistaEmpleadoPrincipal";
	}

    @PostMapping("/registrar")
    public String registrarCliente(Cliente cliente){
        try {
			this.clienteService.guardarEmpleado(cliente);
			return "redirect:/empleados/principal";
		} catch (Exception e) {
			return "redirect:../paginas/principal";
		}
    }
   
	@GetMapping("/cliente/encontrado")
	public String clienteBuscado(@RequestParam("cedula") String cedula, Model modelo) {
		Cliente clientes = this.clienteService.buscarCliente(cedula);
		modelo.addAttribute("clientes", clientes);
		return "vistaCliente";
	}
}
