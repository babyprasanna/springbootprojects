package springboot.pratice.qualifierprofiles.serivice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("n")
@Qualifier("dc")
public class DebitCard implements Payment {

	@Override
	public String doPayment() {

		return "DebitCard";
	}

}
