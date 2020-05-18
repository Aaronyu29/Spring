package container.overview.domain;

/**
 * TODO
 *
 * @auther AaronYu
 * @date 2020/5/18 8:37
 */
public class Company {
    // 特意把属性的名字做了改变。
    private Employee emp;

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employee=" + emp +
                '}';
    }
}
