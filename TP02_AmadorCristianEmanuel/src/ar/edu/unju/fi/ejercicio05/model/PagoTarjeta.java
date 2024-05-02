package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoTarjeta implements IPago {
	private String cardNumber;
	private LocalDate paymentDate;
	private double amountPaid;

	public PagoTarjeta() {
	}

	public PagoTarjeta(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PagoTarjeta(String cardNumber, LocalDate paymentDate, double amountPaid) {
		this.cardNumber = cardNumber;
		this.paymentDate = paymentDate;
		this.amountPaid = amountPaid;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	@Override
	public void realizarPago(double monto) {
		this.amountPaid = monto + (monto * 0.15);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nRESUMEN DE PAGO \nNumero de tarjeta: " + cardNumber + "\nFecha de Pago: " + paymentDate
				+ "\nMonto pagado: $" + amountPaid);
	}

}
