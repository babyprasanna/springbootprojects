package springboot.pratice.qualifierprofiles.serivice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("n")
@Qualifier("cp")
public class CreditcardPayment implements Payment {

	@Override
	public String doPayment() {

		return "CreditcardPayment";

	}

}
