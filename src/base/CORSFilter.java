package base;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public ContainerResponse filter(final ContainerRequest request, final ContainerResponse response) {
		final ResponseBuilder resp = Response.fromResponse(response.getResponse());
		resp.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		final String reqHead = request.getHeaderValue("Access-Control-Request-Headers");
		if (null != reqHead && !reqHead.equals(null)) {
			resp.header("Access-Control-Allow-Headers", reqHead);
		}
		response.setResponse(resp.build());
		return response;
		// MultivaluedMap<String, Object> headers = cres.getHttpHeaders();
		//
		// cres.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
		// cres.getHttpHeaders().add("Access-Control-Allow-Headers", "origin,
		// content-type, accept, authorization");
		// cres.getHttpHeaders().add("Access-Control-Allow-Credentials",
		// "true");
		// cres.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST,
		// PUT, DELETE, OPTIONS, HEAD");
		// cres.getHttpHeaders().add("Access-Control-Max-Age", "1209600");
		// return cres;
	}
}
