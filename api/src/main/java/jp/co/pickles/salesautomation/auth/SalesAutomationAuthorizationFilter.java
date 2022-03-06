package jp.co.pickles.salesautomation.auth;

import jp.co.pickles.salesautomation.domain.account.Account;
import jp.co.pickles.salesautomation.domain.account.AccountID;
import jp.co.pickles.salesautomation.domain.account.AccountRepository;
import jp.co.pickles.salesautomation.domain.auth.accesstoken.AccessToken;
import jp.co.pickles.salesautomation.infrastructure.jwt.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static jp.co.pickles.salesautomation.auth.Constants.*;

@Component
public class SalesAutomationAuthorizationFilter extends OncePerRequestFilter {
    AccountRepository accountRepository;
    JWTUtils jwtUtils;

    @Autowired
    public SalesAutomationAuthorizationFilter(AccountRepository accountRepository, JWTUtils jwtUtils) {
        this.accountRepository = accountRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        AccessToken accessToken = new AccessToken(req.getHeader(HEADER_STRING));

        if (!accessToken.isValid()) {
            chain.doFilter(req, res);
            return;
        }

        AccountID accountID = this.jwtUtils.decodeSubject(accessToken);
        Account account = this.accountRepository.getWithPassword(accountID);
        Authentication authentication = new SalesAutomationAuthentication(account, req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
}
