/**
 *
 */
package eu.dilcis.validator.rest.resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.roda_project.commons_ip.model.ParseException;
import org.roda_project.commons_ip.model.SIP;
import org.roda_project.commons_ip.model.ValidationReport;
import org.roda_project.commons_ip.model.impl.eark.EARKSIP;


/**
 * The REST resource definition for byte stream identification services, these
 * are JERSEY REST services and it's the annotations that perform the magic of
 * handling content types and serialisation.
 *
 * @author <a href="mailto:carl@openpreservation.org">Carl Wilson</a>.</p>
 */
public class ValidationResource {
	private static final String SHA1_NAME = "SHA-1"; //$NON-NLS-1$
    /**
     * Default public constructor required by Jersey / Dropwizard
     */
    public ValidationResource() {
        super();
    }

    /**
     * @param uploadedInputStream
     *            InputStream for the uploaded file
     * @param contentDispositionHeader
     *            extra info about the uploaded file, currently unused.
     * @return the {@link org.verapdf.pdfa.metadata.bytestream.ByteStreamId} of
     *         the uploaded file's byte stream serialised according to requested
     *         content type.
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({ MediaType.APPLICATION_JSON })
    public static ValidationReport validate(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") final FormDataContentDisposition contentDispositionHeader) throws ParseException, IOException {
        MessageDigest sha1 = getDigest();
        DigestInputStream dis = new DigestInputStream(uploadedInputStream, sha1);
        SIP sip = EARKSIP.parse(inputToTempPath(dis));
        return sip.getValidationReport();
    }

    private static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance(SHA1_NAME);
        } catch (NoSuchAlgorithmException nsaExcep) {
            // If this happens the Java Digest algorithms aren't present, a
            // faulty Java install??
            throw new IllegalStateException(
                    "No digest algorithm implementation for " + SHA1_NAME + ", check you Java installation.", nsaExcep); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    private static Path inputToTempPath(InputStream is) throws IOException {
        Path temp = Files.createTempFile("ip-", "-up");
        try (OutputStream os = new FileOutputStream(temp.toFile())) {
            byte[] buff = new byte[4096];
            int length;
            while ((length = is.read(buff)) > 0) {
                os.write(buff, 0, length);
            }
        }
        return temp;
    }
}
