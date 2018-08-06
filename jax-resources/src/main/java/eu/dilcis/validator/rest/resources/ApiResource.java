package eu.dilcis.validator.rest.resources;

import javax.ws.rs.Path;

	
/**
 * @author  <a href="mailto:carl@openpreservation.org">Carl Wilson</a>
 *          <a href="https://github.com/carlwilson">carlwilson AT github</a>
 *
 * @version 0.1
 */
@Path("/")
public final class ApiResource {

	/**
	 * 
	 */
	public ApiResource() {
		super();
	}

    /**
     * @return a new {@link ByteStreamResource}
     */
    @Path("/bytes/")
    public static ByteStreamResource byteResources() {
        return new ByteStreamResource();
    }

    /**
     * @return a new {@link ByteStreamResource}
     */
    @Path("/validate/")
    public static ValidationResource validationResources() {
        return new ValidationResource();
    }
}
