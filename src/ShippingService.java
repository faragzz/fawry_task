import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("\n** Shipment notice **");

        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> weights = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
            weights.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : counts.keySet()) {
            int quantity = counts.get(name);
            double weight = weights.get(name) * quantity;
            System.out.printf("%dx %s %.0fg\n", quantity, name, weight * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}

