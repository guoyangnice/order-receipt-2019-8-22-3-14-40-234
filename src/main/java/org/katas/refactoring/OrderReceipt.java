package org.katas.refactoring;

public class OrderReceipt {
	private Order order;
	private StringBuilder output = new StringBuilder();

	public OrderReceipt(Order order) {
		this.order = order;
	}

	public String printReceipt() {
		printHeaders();
		printCustomerNameAndAddress();
		printLineItems();
		return output.toString();
	}

	private StringBuilder printHeaders() {
		output.append("======Printing Orders======\n");
		return output;
	}

	private StringBuilder printCustomerNameAndAddress() {
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
		return output;
	}

	private void printStateTax(double totSalesTx) {
		output.append("Sales Tax").append('\t').append(totSalesTx);
	}

	private void printLineItems() {
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			//Ò»¸Ä¾Í´í
			output.append(lineItem.getName());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');

			double salesTax = calculateSalesTax(lineItem);
			totSalesTx = calculateTotSalesTax(salesTax, totSalesTx);
			tot = calculateTotalAmount(lineItem, salesTax, tot);
		}
		printStateTax(totSalesTx);
		printTotalAmount(tot);
	}

	private double calculateSalesTax(LineItem lineItem) {
		double taxRate = .10;
		double salesTax = lineItem.totalAmount() * taxRate;
		return salesTax;
	}

	private double calculateTotSalesTax(double salesTax, double totSalesTx) {
		totSalesTx += salesTax;
		return totSalesTx;
	}

	private double calculateTotalAmount(LineItem lineItem, double salesTax, double tot) {
		tot += lineItem.totalAmount() + salesTax;
		return tot;
	}

	private void printTotalAmount(double tot) {
		output.append("Total Amount").append('\t').append(tot);
	}

}