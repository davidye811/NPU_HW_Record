package nvz.services;
import nvz.domain.*;

public interface ShippingChargeCalculator {
	public double shippingCharge(Order order);
}
