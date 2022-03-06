package jp.co.pickles.salesautomation.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class SalesAutomationAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private static final Logger logger = LoggerFactory.getLogger(SalesAutomationAuthenticationFailureHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.error("Authentication Failed.", exception);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
