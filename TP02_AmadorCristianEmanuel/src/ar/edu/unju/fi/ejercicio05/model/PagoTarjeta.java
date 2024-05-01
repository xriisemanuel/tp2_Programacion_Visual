package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoTarjeta implements IPago {
	private String cardNumber;
	private LocalDate paymentDate;
	private double amountPaid;

	public PagoTarjeta() {
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
	public String toString() {
		return "PagoTarjeta [cardNumber=" + cardNumber + ", paymentDate=" + paymentDate + ", amountPaid=" + amountPaid
				+ "]";
	}

	@Override
	public void realizarPago(double monto) {
		this.amountPaid += (this.amountPaid * 15) / 100;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nINFORMACION DE LA TARJETA \nNumero de tarjeta: " + cardNumber + 
				"\nFecha de Pago: " + paymentDate + "\nMonto pagado: $" + amountPaid);
	}

}
