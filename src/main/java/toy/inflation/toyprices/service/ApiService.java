package toy.inflation.toyprices.service;

import java.io.IOException;

public interface ApiService {
	public String findValues(Object data) throws IOException;
	public String modifyValues(Object data) throws IOException;
}
