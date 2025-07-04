import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice**");
        Map<String, Integer> counts = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            counts.put(item.getName(), counts.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        for (var entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
