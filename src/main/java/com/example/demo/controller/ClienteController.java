package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	

	@PostMapping("/registrar")
	public String registrarCliente(Cliente cliente) {
		try {
			
			this.clienteService.guardarCliente(cliente);
        	
			return "redirect:/paginas/cliente";
		} catch (Exception e) {
			
			return "redirect:/clientes/registroCliente";
		}
	
	}

	@GetMapping("/registroCliente")
	public String registo(Cliente c, Model modelo) {
		modelo.addAttribute("cliente", c);
		return "vistaClienteNuevo";
	}

}
