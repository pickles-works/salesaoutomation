package jp.co.pickles.salesautomation.auth;

import jp.co.pickles.salesautomation.domain.account.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Objects;

public class SalesAutomationAuthentication implements Authentication {
    private Account account;
    private Object details;

    public SalesAutomationAuthentication(
            Account account,
            Object details) {
        this.account = account;
        this.details = details;
    }

    public SalesAutomationAuthentication(
            Account account,
            HttpServletRequest request) {
        this.account = account;
        this.details =  new WebAuthenticationDetails(request);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return account.getRole().getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return this.details;
    }

    @Override
    public Object getPrincipal() {
        return this.account;
    }

    @Override
    public boolean isAuthenticated() {
        return !this.account.isLocked() && this.account.hasRole();
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new UnsupportedOperationException("SalesAutomationAuthentication#setAuthenticated is unsupported.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesAutomationAuthentication)) return false;
        SalesAutomationAuthentication that = (SalesAutomationAuthentication) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, details);
    }

    @Override
    public String toString() {
        return "SalesAutomationAuthentication{" +
                "userAccount=" + account +
                ", details=" + details +
                '}';
    }

    @Override
    public String getName() {
        return this.account.getLoginID().asText();
    }
}
