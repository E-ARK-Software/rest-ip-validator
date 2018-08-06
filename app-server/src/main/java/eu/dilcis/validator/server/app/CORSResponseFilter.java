package eu.dilcis.validator.server.app;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

public class CORSResponseFilter implements ContainerResponseFilter {

	public CORSResponseFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) {

		MultivaluedMap<String, Object> headers = responseContext.getHeaders();

		headers.add("Access-Control-Allow-Origin", "*"); //$NON-NLS-1$ //$NON-NLS-2$
		headers.add("Access-Control-Allow-Methods", //$NON-NLS-1$
				"OPTIONS,GET,PUT,POST,DELETE,HEAD"); //$NON-NLS-1$
		headers.add("Access-Control-Allow-Headers", //$NON-NLS-1$
				"X-Requested-With,Content-Type,Accept,Origin"); //$NON-NLS-1$
	}

}
