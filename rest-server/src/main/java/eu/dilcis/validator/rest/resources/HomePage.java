package eu.dilcis.validator.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.dilcis.validator.client.views.RestClientView;

/**
 * Delivers the client home page.
 * 
 * @author <a href="mailto:carl@openpreservation.org">Carl Wilson</a>
 *         <a href="https://github.com/carlwilson">carlwilson AT github</a>
 *
 * @version 0.1
 */
@Path("/")
public class HomePage {

	/**
	 * Default no-arg consructor
	 */
	public HomePage() {
		super();
	}

	/**
	 * Get the client view
	 * 
	 * @return The client Home Page view
	 */
	@GET
	@Produces({ MediaType.TEXT_HTML })
	public static RestClientView client() {
		return new RestClientView();
	}

}
