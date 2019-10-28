import java.util.List;
import java.util.Optional;

import com.system.eas.model.Employee;
import com.system.eas.repository.EmployeeRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class EmployeeController implements EmployeeRepository {

    @Override
    public List<Employee> listAllEmployee() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateEmployee(Long employeeId) {
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}