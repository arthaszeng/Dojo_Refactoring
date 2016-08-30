public class OrderReceipt {
    private Order order;
	private final double taxRate = .10;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		// print headers
		output.append("======Printing Orders======\n");

		// print date, bill no, customer name
//        output.append("Date - " + order.getDate();
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

		// prints lineItems
		double totalSalesTax = 0d;
		double total = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');



			// calculate total amount of lineItem = price * quantity + 10 % sales tax
			total += lineItem.totalAmount();
		}

		// prints the state tax
		output.append("Sales Tax").append('\t').append(totalSalesTax);
		total = calculateTotal(total);

		// print total amount
		output.append("Total Amount").append('\t').append(total);
		return output.toString();
	}

	private double calculateTotal(double total) {
		double totalSalesTax;
		totalSalesTax = total * taxRate;
		total += totalSalesTax;
		return total;
	}
}