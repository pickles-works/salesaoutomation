package jp.co.pickles.salesautomation.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SalesAutomationAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public SalesAutomationAuthenticationFilter() {
    }

    public SalesAutomationAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserForm userForm = new ObjectMapper().readValue(request.getInputStream(), UserForm.class);
            UsernamePasswordAuthenticationToken authRequest =
                    new UsernamePasswordAuthenticationToken(userForm.loginId, userForm.password);
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        } catch (IOException e) {
            throw new AuthenticationRequestMappingErrorException("Request mapping error.", e);
        }
    }

    private static class UserForm {
        private String loginId;
        private String password;

        public UserForm(String loginId, String password) {
            this.loginId = loginId;
            this.password = password;
        }

        public UserForm() {
        }
    }

    public static class AuthenticationRequestMappingErrorException extends AuthenticationException {

        public AuthenticationRequestMappingErrorException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public AuthenticationRequestMappingErrorException(String msg) {
            super(msg);
        }
    }
}
