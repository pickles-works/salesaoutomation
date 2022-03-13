package jp.co.pickles.salesautomation.infrastructure.datasource.employee;

import jp.co.pickles.salesautomation.domain.account.AccountID;
import jp.co.pickles.salesautomation.domain.account.AccountWithPassword;
import jp.co.pickles.salesautomation.domain.account.LoginID;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    AccountWithPassword findBy(LoginID loginID);
    AccountWithPassword findBy(AccountID accountID);
}
