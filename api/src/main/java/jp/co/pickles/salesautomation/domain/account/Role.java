package jp.co.pickles.salesautomation.domain.account;

import jp.co.pickles.salesautomation.domain.base.EnumType;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class Role extends EnumType<Role, Role.Type> {
    public Role(Type value) {
        super(value);
    }

    public Role() {
    }

    @Override
    protected boolean isNullable() {
        return false;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return Collections.singleton(this.value);
    }

    public enum Type implements GrantedAuthority {
        CUSTOMER_USER, SALES_USER, SALES_ADMIN, SYSTEM_ADMIN;

        @Override
        public String getAuthority() {
            return this.name();
        }
    }
}
