import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock for " + product.getName() + " it can only get " + product.getQuantity());
            return;
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubTotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double getShippingFee() {
        double total = 0;
        for (CartItem item : items) {
            if (item.product instanceof Shippable) total += 10; // we can change it as we want
        }
        return total;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> shippableList = new ArrayList<>();
        for (CartItem item : items) {
            if (item.product instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) shippableList.add((Shippable) item.product);
            }
        }
        return shippableList;
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (CartItem item : items) {
            if (item.product instanceof Shippable) {
                double itemWeight = ((Shippable) item.product).getWeight();
                totalWeight += itemWeight * item.quantity;
            }
        }
        return totalWeight;
    }

}