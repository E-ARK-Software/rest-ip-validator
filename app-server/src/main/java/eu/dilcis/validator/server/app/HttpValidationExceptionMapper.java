package eu.dilcis.validator.server.app;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class HttpValidationExceptionMapper
		implements ExceptionMapper<HttpValidationException> {

	public HttpValidationExceptionMapper() {
		super();
	}

	@Override
	public Response toResponse(HttpValidationException exception) {
		return Response.status(exception.code).entity(exception.getMessage())
				.type(MediaType.TEXT_PLAIN).build();
	}

}
