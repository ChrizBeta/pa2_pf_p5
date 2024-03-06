package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.List;
import java.util.Random;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IReservaRepository;
import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.IClienteRepository;

import com.example.demo.repository.modelo.Vehiculo;

import com.example.demo.repository.modelo.dto.ReservaDTO;


import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	private IReservaRepository iReservaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public String reservarVehiculo(String placa, String cedula, LocalDate fechaInicio, LocalDate fechaFin,String numTarjeta) {

		BigDecimal[] valores = calcularValores(placa, fechaInicio, fechaFin);
		Cliente cliente = this.clienteRepository.seleccionarPorCedula(cedula);
		Vehiculo vehiculo = this.iVehiculoRepository.seleccionarPorPlaca(placa);
		
		Reserva reserva = new Reserva();
		Random rand = new Random();
		int randomNumero = rand.nextInt(100000) + 1;
		reserva.setNumeroReserva(Integer.toString(randomNumero));
		reserva.setFechaInicio(fechaInicio);
		reserva.setFechaFin(fechaFin);
		reserva.setFechaCobro(LocalDate.now());
		reserva.setEstado("G");
		reserva.setValorSubtotal(valores[0]);
		reserva.setNumeroTarjetaCredito(numTarjeta);
		reserva.setValorICE(valores[1]);
		reserva.setValorTotal(valores[2]);
		reserva.setCliente(cliente);
		reserva.setVehiculo(vehiculo);
		this.iReservaRepository.insertar(reserva);
		return reserva.getNumeroReserva();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Reserva cambiarEstadoReserva(String numeroReserva) {

		Reserva r = this.iReservaRepository.seleccionarPorNoReserva(numeroReserva);
		r.setEstado("E");
		this.iReservaRepository.actualizar(r);
		return r;
	}

	@Override
	public Reserva buscarPorReserva(String numeroReserva) {

		return this.iReservaRepository.seleccionarPorNoReserva(numeroReserva);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Reserva reserva) {

		this.iReservaRepository.actualizar(reserva);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public LocalDate obtenerFechaDisponible(String placa, LocalDate fechaInicio, LocalDate fechaFin) {
		List<Reserva> reservas = this.iReservaRepository.seleccionarListaPorPlacaV(placa);
		LocalDate fechaDisponible = LocalDate.now();
		for (Reserva reserva : reservas) {
			LocalDate fechaInicioReserva = reserva.getFechaInicio();
			LocalDate fechaFinReserva = reserva.getFechaFin();

			// Verifica si el rango de fechas se solapa con alguna reserva existente
			if (!(fechaFin.isBefore(fechaInicioReserva) || fechaInicio.isAfter(fechaFinReserva))) {
				fechaDisponible = fechaFinReserva.plusDays(1);
			}
		}
		
		return fechaDisponible;
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal valorTotalAPagar(String placa, LocalDate fechaInicio, LocalDate fechaFin) {

		BigDecimal[] valores = calcularValores(placa, fechaInicio, fechaFin);
		BigDecimal valorTotal = valores[2];
		return valorTotal;
	}

	@Override
	public List<ReservaDTO> reporteReservas(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.iReservaRepository.seleccionarListaPorFechas(fechaInicio, fechaFin);
	}


	public BigDecimal[] calcularValores(String placa, LocalDate fechaInicio, LocalDate fechaFin) {
		Vehiculo vehiculo = this.iVehiculoRepository.seleccionarPorPlaca(placa);
		long diasDiferencia = ChronoUnit.DAYS.between(fechaInicio, fechaFin);

		BigDecimal valorSubTotal = vehiculo.getValorPorDia().multiply(new BigDecimal(diasDiferencia));
		BigDecimal valorICE = valorSubTotal.multiply(new BigDecimal(0.15));
		BigDecimal valorTotal = valorSubTotal.add(valorICE);

		BigDecimal valorSubTotalRedondear = valorSubTotal.setScale(2, RoundingMode.HALF_UP);
		BigDecimal valorICERedondear = valorICE.setScale(2, RoundingMode.HALF_UP);
		BigDecimal valorTotalRedondear = valorTotal.setScale(2, RoundingMode.HALF_UP);
		BigDecimal[] valores = { valorSubTotalRedondear, valorICERedondear, valorTotalRedondear };
		return valores;
	}
}
