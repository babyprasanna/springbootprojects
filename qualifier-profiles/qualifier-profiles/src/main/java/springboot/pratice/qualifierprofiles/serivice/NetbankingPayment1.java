package springboot.pratice.qualifierprofiles.serivice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("otp")
@Qualifier("nb")
public class NetbankingPayment1 implements Payment {

	@Override
	public String doPayment() {
		// TODO Auto-generated method stub
		return "netbanking card otp";
	}

}
