package container.overview.domain;

/**
 * Boss Model 继承 {@link Employee} Model
 *
 * @auther AaronYu
 * @date 2020/5/16 23:42
 */
public class Boss extends Employee{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}
