package npu.services;

import npu.domain.*;

public class OrderProcessor {
	private AccountingService acctService;
	
	public AccountingService getAcctService() {
		return acctService;
	}

	public void setAcctService(AccountingService acctService) {
		this.acctService = acctService;
	}

	public OrderProcessor() {
	}
	
	public void newOrder(Order order) {
		acctService.recordNewOrder(order);
//		inventoryService.adjustInventory(order);
	}
}