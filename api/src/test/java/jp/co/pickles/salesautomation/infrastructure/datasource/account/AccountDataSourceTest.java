package jp.co.pickles.salesautomation.infrastructure.datasource.account;

import jp.co.pickles.salesautomation.domain.account.AccountRepository;
import jp.co.pickles.salesautomation.domain.account.LoginID;
import jp.co.pickles.salesautomation.testutils.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class AccountDataSourceTest extends AbstractTest {

    @Autowired
    private AccountRepository repository;

    @Test
    public void データを取得できる() {
        assertNotNull(this.repository);
        this.repository.findWithPasswordBy(new LoginID("hogehoge"));
    }
}
