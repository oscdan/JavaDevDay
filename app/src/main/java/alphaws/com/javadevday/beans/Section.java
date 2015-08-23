package alphaws.com.javadevday.beans;

/**
 * Created by oscarvargas on 05/08/15.
 */
public class Section {
    private int section;
    private String name;

    public Section(int section, String name) {
        this.section = section;
        this.name = name;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
