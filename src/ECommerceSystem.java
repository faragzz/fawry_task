public class ECommerceSystem {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new RuntimeException("Cart is empty");

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired())
                throw new RuntimeException("Product " + item.product.getName() + " is expired");
        }

        double subtotal = cart.getSubTotal();
        double shipping = cart.getShippingFee();
        double total = subtotal + shipping;

        customer.deductBalance(total);

        for (CartItem item : cart.getItems()) {
            item.product.decreaseQuantity(item.quantity);
        }

        ShippingService.ship(cart.getShippableItems());

        System.out.println("** Shipment notice **");
        for (CartItem item : cart.getItems()) {
            if (item.product instanceof Shippable) {
                System.out.printf("%dx %s %.0fg\n", item.quantity, item.product.getName(), ((Shippable)item.product).getWeight() * item.quantity * 1000);
            }
        }
        System.out.printf("Total package weight %.1fkg\n", cart.getTotalWeight());

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.quantity, item.product.getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shipping);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Remaining balance %.0f\n", customer.getBalance());
    }
}
