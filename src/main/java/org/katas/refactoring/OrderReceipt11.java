package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt11 {
    private Order order;
    private StringBuilder output;
    private double tot;
    private double totSalesTx = 0d;
    private LineItem lineItem;
    private double salesTax;
    
    public OrderReceipt11(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        output = new StringBuilder();
        printCustomerNameAndAddress();

        // prints lineItems
        printslineItems();

        // prints the state tax
        printsTheStateTax();

        // print total amount
        printTotalAmount();
        return output.toString();
    }

	private void printTotalAmount() {
		output.append("Total Amount").append('\t').append(tot);
	}

	private void printCustomerNameAndAddress() {
		output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
	}
	
	private void printslineItems() {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getName()+"\t");
            output.append(lineItem.getPrice()+"\t");
            output.append(lineItem.getQuantity()+"\t");
            output.append(lineItem.totalAmount()+"\n");

            // calculate sales tax @ rate of 10%
            calculateSalesTaxRate(lineItem,totSalesTx);

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            calculateTotalAmountofLintItem();
        }
	}
	
	private void printsTheStateTax() {
		output.append("Sales Tax").append('\t').append(totSalesTx);
	}
	
	private double calculateSalesTaxRate(LineItem lineItem,double totSalesTx) {
		double taxRate = 0.10;
		double salesTax = lineItem.totalAmount() * taxRate;
        totSalesTx += salesTax;
        return totSalesTx;
	}
	private double calculateTotalAmountofLintItem() {
		tot += lineItem.totalAmount() + salesTax;
		return tot;
	}
	
}