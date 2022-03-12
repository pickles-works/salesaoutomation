package jp.co.pickles.salesautomation.infrastructure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jp.co.pickles.salesautomation.SalesAutomationApplication;
import jp.co.pickles.salesautomation.domain.account.AccountID;
import jp.co.pickles.salesautomation.domain.auth.accesstoken.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {
    private static final String ISSUER = SalesAutomationApplication.class.getName();
    private static final byte[] SECRET = ISSUER.getBytes();

    private Long accessTokenExpirationTime = 60L * 60L * 1000L;

//    public JWTUtils(
//            @Value("${salesautomation.auth.accesstoken.expiration.time}")
//                    String accessTokenExpirationTime) {
//        this.accessTokenExpirationTime = Long.parseLong(accessTokenExpirationTime);
//    }

    public AccessToken encode(AccountID accountID) {
        return new AccessToken(
                Jwts.builder()
                        .setSubject(accountID.asText())
                        .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpirationTime))
                        .setIssuer(ISSUER)
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .compact()
        );
    }

    public AccountID decodeSubject(AccessToken accessToken) {
        return new AccountID(Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(accessToken.getJwtValue())
                .getBody()
                .getSubject());
    }
}
