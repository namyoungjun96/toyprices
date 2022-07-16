package toy.inflation.toyprices.repository;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public interface ApiDao {
	URL get(Object data) throws IOException;
	URL update(Object data) throws IOException;
}
