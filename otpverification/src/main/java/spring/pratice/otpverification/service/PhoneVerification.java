package spring.pratice.otpverification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

@Service
public class PhoneVerification {

	private final Twilioproperties twilioproperties;

	@Autowired
	public PhoneVerification(Twilioproperties twilioproperties) {
		this.twilioproperties = twilioproperties;
	}

	public VerificationResult startVerification(String phone) {
		try {
			Verification verification = Verification.creator(twilioproperties.getServiceId(), phone, "sms").create();
			if ("approved".equals(verification.getStatus()) || "pending".equals(verification.getStatus())) {
				return new VerificationResult(verification.getSid());
			}
		} catch (ApiException exception) {
			return new VerificationResult(new String[] { exception.getMessage() });
		}
		return null;
	}
	
	
    public VerificationResult checkverification(String phone, String code) {
        try {
            VerificationCheck verification = VerificationCheck.creator(twilioproperties.getServiceId(), code).setTo(phone).create();
            if("approved".equals(verification.getStatus())) {
                return new VerificationResult(verification.getSid());
            }
            return new VerificationResult(new String[]{"Invalid code."});
        } catch (ApiException exception) {
            return new VerificationResult(new String[]{exception.getMessage()});
        }
    }

}
