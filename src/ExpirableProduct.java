import java.util.Date;

public class ExpirableProduct extends Product{
    private final Date expiryDate;

    public ExpirableProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.before(new Date());
    }

}
