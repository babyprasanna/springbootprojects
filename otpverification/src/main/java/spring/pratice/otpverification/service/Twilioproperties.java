package spring.pratice.otpverification.service;

import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twillio")
public class Twilioproperties {

	private String accountSid;
	private String authToken;
	private String serviceId;

	public Twilioproperties() {

	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String toString() {
		return "Twilioproperties [accountSid=" + accountSid + ", authToken=" + authToken + ", serviceId=" + serviceId
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountSid, authToken, serviceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Twilioproperties other = (Twilioproperties) obj;
		return Objects.equals(accountSid, other.accountSid) && Objects.equals(authToken, other.authToken)
				&& Objects.equals(serviceId, other.serviceId);
	}

}
