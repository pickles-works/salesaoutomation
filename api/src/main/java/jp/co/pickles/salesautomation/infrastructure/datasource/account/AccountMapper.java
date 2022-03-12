package jp.co.pickles.salesautomation.infrastructure.datasource.account;

import jp.co.pickles.salesautomation.domain.account.AccountID;
import jp.co.pickles.salesautomation.domain.account.AccountWithPassword;
import jp.co.pickles.salesautomation.domain.account.LoginID;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    AccountWithPassword findBy(LoginID loginID);
    AccountWithPassword findBy(AccountID accountID);
}
