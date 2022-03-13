package jp.co.pickles.salesautomation.infrastructure.datasource.employee;

import jp.co.pickles.salesautomation.domain.employee.Employee;
import jp.co.pickles.salesautomation.domain.employee.EmployeeID;
import jp.co.pickles.salesautomation.domain.employee.EmployeeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDataSource implements EmployeeRepository {

    @Override
    public EmployeeID create(Employee employee) {
        return null;
    }
}
