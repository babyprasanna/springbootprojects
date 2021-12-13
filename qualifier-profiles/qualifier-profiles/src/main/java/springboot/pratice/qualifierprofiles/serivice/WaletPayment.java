package springboot.pratice.qualifierprofiles.serivice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("n")
@Qualifier("wp")
public class WaletPayment implements Payment {

	@Override
	public String doPayment() {
		// TODO Auto-generated method stub
		return "WaletPayment";
	}

}
