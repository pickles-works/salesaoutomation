package jp.co.pickles.salesautomation.domain.account.password;

import jp.co.pickles.salesautomation.domain.base.StringType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Pattern;

public class HashingPassword extends StringType<HashingPassword> {
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private HashingPassword(String value) {
        super(value);
    }

    public HashingPassword() {
    }

    public boolean matches(PlainTextPassword plainTextPassword) {
        return PASSWORD_ENCODER.matches(plainTextPassword.asText(), this.value);
    }

    @Override
    protected Pattern pattern() {
        return null;
    }

    @Override
    protected boolean isNullable() {
        return false;
    }

    public static HashingPassword generate(PlainTextPassword plainTextPassword) {
        return new HashingPassword(PASSWORD_ENCODER.encode(plainTextPassword.asText()));
    }
}
