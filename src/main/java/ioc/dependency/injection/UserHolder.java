package ioc.dependency.injection;

import container.overview.domain.Employee;

/**
 * {@link container.overview.domain.Employee} 的 holder 类
 *
 * @auther AaronYu
 * @date 2020/5/16 23:49
 */
public class UserHolder {

    private Employee employee;

    public UserHolder(Employee employee) {
        this.employee = employee;
    }

    /*public UserHolder() {

    }*/

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "employee=" + employee +
                '}';
    }
}
