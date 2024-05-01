package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoEfectivo implements IPago {
	private double amountPaid;
	private LocalDate paymentDate;

	public PagoEfectivo() {
	}

	public PagoEfectivo(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PagoEfectivo(double amountPaid, LocalDate paymentDate) {
		this.amountPaid = amountPaid;
		this.paymentDate = paymentDate;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "PagoEfectivo [amountPaid=" + amountPaid + ", paymentDate=" + paymentDate + "]";
	}

	@Override
	public void realizarPago(double monto) {
		this.amountPaid = monto - (monto * 0.1);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nRESUMEN DE PAGO \nFecha de Pago: " + paymentDate + "\nMonto Pagado: $" + 
				amountPaid);
	}

}
