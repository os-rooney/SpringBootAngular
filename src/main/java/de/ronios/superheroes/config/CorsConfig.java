package de.ronios.superheroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    // Global CORS configuration
    @Bean
    CorsFilter corsFilter(){
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        /* The setAllowCredentials() method indicates whether the browser should send credentials
        such as cookies with cross-origin requests
        This means that we want to set this option to true if we retrieve cookies and
        Cross-Site Request Forgery (CSRF) tokens
         */
        corsConfiguration.setAllowCredentials(true);
        /*
        The setAllowedOrigins() method allows us to set the permitted origins that can access our
        endpoints. These are the domains for the trusted frontend applications.
        http://localhost:4200, which will be the development server of our frontend application:
         */
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        /*
         the setAllowedHeaders() method allows us to configure the list of headers permitted in the
         HTTP requests. In the preceding example, we have set several headers that can be used in the
         requests:
         */
        corsConfiguration.setAllowedHeaders(
                Arrays.asList(
                        "Origin",
                        "Access-Control-Allow-Origin",
                        "Content-type",
                        "Accept",
                        "Authorization",
                        "Origin, Accept",
                        "X-Requested-With",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers"
                )
        );
        /*
        The setExposedHeaders() method allows us to specify the list of response headers from the server
        We can use this method to limit the headers on the response for security measures:
         */
        corsConfiguration.setExposedHeaders(
                Arrays.asList(
                        "Origin",
                        "Content-type",
                        "Accept",
                        "Authorization",
                        "Access-Control-Allow-Origin",
                        "Access-Control-Allow-Origin",
                        "Access-Control-Allow-Credentials"
                )
        );
        /*
        The setAllowedMEthods() method will allow us to add the HTTP request methods that are authorized
        to be used to access the endpoints. In the following example, we have configured GET, POST, PUT, DELETE
        and OPTIONS as the allowed methods since we are only building a simple Create, Read, Update and Delete (CRUD)
        application
         */
        corsConfiguration.setAllowedMethods(
                Arrays.asList(
                        "GET",
                        "POST",
                        "PUT",
                        "DELETE",
                        "OPTIONS"
                )
        );
        /*
        The last step we need to do is register the CORS configuration. We will instantiate a new
        urlBasedCorsCOnfigurationSource() and use the registerCorsConfiguration() method for the registration.
        The first parameter is "/**", which indicates that the configuration applies to all the methods found
        in the application, and the second parameter is corsConfiguration, which is the configuration we have created
         */
        final UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration(
                "/**",
                corsConfiguration
        );
        return new CorsFilter(corsConfigurationSource);
    }
}
