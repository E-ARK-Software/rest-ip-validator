package eu.dilcis.validator.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.dilcis.validator.server.views.RestClientView;
/**
 * @author <a href="mailto:carl@openpreservation.org">Carl Wilson</a>
 *         <a href="https://github.com/carlwilson">carlwilson AT github</a>
 *
 * @version 0.1
 * 
 *          Created 2 Aug 2018:19:19:25
 */

public class HomePage {

	/**
	 * 
	 */
	public HomePage() {
		super();
	}

	@GET
	@Produces({ MediaType.TEXT_HTML })
	public static RestClientView client() {
		return new RestClientView();
	}

}
