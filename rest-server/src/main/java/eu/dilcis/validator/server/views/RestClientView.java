package eu.dilcis.validator.server.views;

import java.nio.charset.Charset;

import io.dropwizard.views.View;

/**
 * @author  <a href="mailto:carl@openpreservation.org">Carl Wilson</a>
 *          <a href="https://github.com/carlwilson">carlwilson AT github</a>
 *
 * @version 0.1
 */

public class RestClientView extends View {

	/**
	 * @param templateName
	 */
	public RestClientView() {
		this("restclient.mustache");
	}

	/**
	 * @param templateName
	 */
	public RestClientView(String templateName) {
		super(templateName);
	}

	/**
	 * @param templateName
	 * @param charset
	 */
	public RestClientView(String templateName, Charset charset) {
		super(templateName, charset);
	}

}
