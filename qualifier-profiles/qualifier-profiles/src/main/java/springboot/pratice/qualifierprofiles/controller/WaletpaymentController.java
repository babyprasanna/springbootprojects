package springboot.pratice.qualifierprofiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.pratice.qualifierprofiles.serivice.Payment;

@RestController
public class WaletpaymentController {

	@Qualifier("wp")
	@Autowired
	Payment payment;

	@RequestMapping(value = "get/waletpayment")
	public String getWaletpayment() {
		return payment.doPayment();
	}

}
