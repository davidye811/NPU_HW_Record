package nvz.services;

import org.springframework.stereotype.Component;

import nvz.domain.Order;
@Component("shippingCalculator")
public class ShippingChargeCalculatorSimpleImpl implements ShippingChargeCalculator {
	public double shippingCharge(Order order) {
		return order.getAmount() * .10;
	}
}
