package jp.co.pickles.salesautomation.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.Filter;

import static jp.co.pickles.salesautomation.auth.Constants.LOGIN_URL;
import static jp.co.pickles.salesautomation.auth.Constants.SIGN_UP_URL;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SalesAutomationAuthorizationFilter authorizationFilter;

    @Autowired
    private SalesAutomationAuthenticationProvider authenticationProvider;

    @Autowired
    private SalesAutomationAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and().authorizeRequests()
                .antMatchers(SIGN_UP_URL, LOGIN_URL).permitAll()
                .anyRequest().authenticated()
                .and().logout()
                .and().csrf().disable()
                .addFilterAfter(this.authorizationFilter, SalesAutomationAuthenticationFilter.class)
                .addFilterBefore(this.getAuthenticationFilter(), SalesAutomationAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.authenticationProvider);
    }

    private Filter getAuthenticationFilter() throws Exception {
        SalesAutomationAuthenticationFilter filter = new SalesAutomationAuthenticationFilter(this.authenticationManagerBean());
        filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(LOGIN_URL, "POST"));
        filter.setAuthenticationFailureHandler(this.authenticationFailureHandler);
        return filter;
    }
}
