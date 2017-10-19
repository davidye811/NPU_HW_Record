package npu.services;

import npu.domain.Order;

public class AccountingServiceIntlRules implements AccountingService {

	public void recordNewOrder(Order order) {
		System.out.println("Applying International Accounting Rules");
		return;
	}

}
