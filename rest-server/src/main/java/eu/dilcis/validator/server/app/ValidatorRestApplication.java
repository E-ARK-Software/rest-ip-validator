package eu.dilcis.validator.server.app;

import org.glassfish.jersey.server.validation.internal.ValidationExceptionMapper;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author  <a href="mailto:carl@openpreservation.org">Carl Wilson</a>
 *          <a href="https://github.com/carlwilson">carlwilson AT github</a>
 *
 * @version 0.1
 *
 * Created 2 Aug 2018:16:20:27
 */

public class ValidatorRestApplication extends Application<ValidatorRestConfig> {
    private static final String NAME = "verapdf-rest"; //$NON-NLS-1$

    /**
     * Main method for Jetty server application. Simply calls the run method
     * with command line args.
     *
     * @param args
     *            command line arguments as string array.
     * @throws Exception
     *             passes any exception thrown by run
     */
    public static void main(String[] args) throws Exception {
        new ValidatorRestApplication().run(args);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void initialize(Bootstrap<ValidatorRestConfig> bootstrap) {
        // Dropwizard assets bundle to map static resources
        bootstrap.addBundle(new AssetsBundle("/assets/", "/")); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public void run(ValidatorRestConfig configuration,
            Environment environment) {
        // Create & register our REST resources
        final ValidationExceptionMapper vem = new ValidationExceptionMapper();
        environment.jersey().register(vem);
        // Set up cross domain REST
        environment.jersey().register(CORSResponseFilter.class);
    }

}
