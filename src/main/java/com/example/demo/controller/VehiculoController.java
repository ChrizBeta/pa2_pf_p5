package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;
import com.example.demo.repository.modelo.dto.VehiculoDTO;


@Controller
@RequestMapping("/vehiculos")

public class VehiculoController {
	
	@Autowired
    private IVehiculoService iVehiculoService;
    @Autowired
    private IReservaService iReservaService;

  
    
    //http://localhost:8080/vehiculos/buscarPorPlaca/?
    @GetMapping("/buscarPorPlaca")
    public String buscaPorPlaca(@RequestParam("placa") String placa, Model modelo){
        Vehiculo buscado = this.iVehiculoService.buscarPorPlaca(placa);
       
        modelo.addAttribute("vehiculo",buscado);
        
    
        return "vistaPorPlaca";
    }
    @GetMapping("/buscarPorReserva")
    public String buscarPorReserva(@RequestParam("noReserva") String noReserva,Model modelo){
        VehiculoDTO vDto= this.iVehiculoService.buscarDto(noReserva);
        modelo.addAttribute("vehiculoDTO", vDto);
        
       
        return "vistaPorReserva";
    }

    //http://localhost:8080/vehiculos/buscar
	@GetMapping("/buscar")
    public String buscarVehiculos(@RequestParam("marca") String marca,
                                  @RequestParam("modelo") String modelo,
                                  Model model) {
        List<Vehiculo> vehiculosFiltrados = this.iVehiculoService.buscarPorMarcaModelo(marca, modelo); 
        model.addAttribute("vehiculos", vehiculosFiltrados);
        
       
        return "vistaListaVehiculos";
    }
    @GetMapping("/buscarSinReserva")
    public String buscarVehiculosSinReserva(@RequestParam("marca") String marca,
                                  @RequestParam("modelo") String modelo,
                                  Model model) {
        List<Vehiculo> vehiculosFiltrados = this.iVehiculoService.buscarPorMarcaModelo(marca, modelo); 
        model.addAttribute("vehiculos", vehiculosFiltrados);
        
        
        return "vistaVehiculosDisponibles";
    }

    @PutMapping("/retirar/{noReserva}")
    public String retirarReservado(@PathVariable("noReserva") String numeroReserva,Model modelo){
        Reserva r = this.iReservaService.buscarPorReserva(numeroReserva); 
        Vehiculo v = r.getVehiculo();
        r.setEstado("E");
        v.setEstado("I");
        this.iVehiculoService.actualizar(v);
        this.iReservaService.actualizar(r);
        
        
        return "success.html";
    }
    
    @PostMapping("/registrar")
	public String registrarCliente(Vehiculo vehiculo) {
		try {
			this.iVehiculoService.guardar(vehiculo);
           
			return "redirect:/paginas/empleado";
		} catch (Exception e) {
         
			return "redirect:/vehiculos/registroVehiculo";
		}
	}
	
}
