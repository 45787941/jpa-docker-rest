package fr.univtln.kcollot171.executable;

import fr.univtln.kcollot171.utils.ChienManager;
import fr.univtln.kcollot171.utils.RestStuff;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int getPort(int defaultPort){
        String httpPort = System.getProperty("jersey.test.port");
        if(null != httpPort){
            try{
                return Integer.parseInt(httpPort);
            } catch (NumberFormatException e){
            }
        }
        return defaultPort;
    }

    private static URI getBaseURI(){
        return UriBuilder.fromUri("http://localhost/").port(getPort(9998)).build();
    }

    public static final URI BASE_URI = getBaseURI();

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in fr.univtln.kcollot171 package
        final ResourceConfig rc = new ResourceConfig().packages("fr.univtln.kcollot171.utils");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        RestStuff rs = new RestStuff();
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}
