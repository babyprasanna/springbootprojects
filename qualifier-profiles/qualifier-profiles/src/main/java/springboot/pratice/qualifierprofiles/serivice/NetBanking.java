package springboot.pratice.qualifierprofiles.serivice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("n")
@Qualifier("nb")
public class NetBanking implements Payment {

	@Override
	public String doPayment() {
		// TODO Auto-generated method stub
		return "NetBanking";
	}
	

}
