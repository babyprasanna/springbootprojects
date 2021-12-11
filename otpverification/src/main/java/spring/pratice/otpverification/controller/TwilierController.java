package spring.pratice.otpverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.pratice.otpverification.service.PhoneVerification;
import spring.pratice.otpverification.service.VerificationResult;

@Controller
public class TwilierController {

	@Autowired
	PhoneVerification phoneVerification;

	@RequestMapping("/")
	public String indexPage() {
		return "index";

	}

	@PostMapping("/sendotp")
	public ResponseEntity<String> sendotp(@RequestParam("phone") String phone) {

		VerificationResult result = phoneVerification.startVerification(phone);

		if (result.isValid()) {
			return new ResponseEntity<>("Otp send ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Otp failed to send ", HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/verifyotp")
	public ResponseEntity<String> checkotp(@RequestParam("phone") String phone, @RequestParam("otp") String otp) {
		VerificationResult result = phoneVerification.checkverification(phone, otp);

		if (result.isValid()) {
			return new ResponseEntity<String>("Verified phone number OTP ", HttpStatus.OK);
		}
		return new ResponseEntity<String>("In valied Number Otp ", HttpStatus.BAD_REQUEST);

	}

	
}
