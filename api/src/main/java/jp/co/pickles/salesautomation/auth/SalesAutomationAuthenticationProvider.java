package jp.co.pickles.salesautomation.auth;

import jp.co.pickles.salesautomation.domain.account.AccountRepository;
import jp.co.pickles.salesautomation.domain.account.AccountWithPassword;
import jp.co.pickles.salesautomation.domain.account.LoginID;
import jp.co.pickles.salesautomation.domain.account.password.PlainTextPassword;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class SalesAutomationAuthenticationProvider implements AuthenticationProvider {

    private AccountRepository accountRepository;
    public SalesAutomationAuthenticationProvider(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        LoginID loginId = new LoginID((String) auth.getPrincipal());
        AccountWithPassword userAccount = this.accountRepository.findWithPasswordBy(loginId);

        if (userAccount.isLocked()) {
            throw new LockedException("Account is locked.");
        }

        PlainTextPassword password = new PlainTextPassword((String) auth.getCredentials());
        if (!userAccount.matchPassword(password)) {
            throw new BadCredentialsException("Password not matched.");
        }

        return new SalesAutomationAuthentication(userAccount.withoutPassword(), auth.getDetails());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
