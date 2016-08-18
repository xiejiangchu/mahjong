/**
 * Created by xie on 16/8/18.
 */
public class Pai implements Comparable<Pai> {
    private int CODE;
    private String name;

    public Pai(int CODE, String name) {
        this.CODE = CODE;
        this.name = name;
    }

    public void setCODE(int CODE) {
        this.CODE = CODE;
    }

    public int getCODE() {
        return CODE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Pai another) {
        return getCODE() - another.getCODE();
    }

    @Override
    public String toString() {
        return "Pai{" +
                "name='" + name + '\'' +
                '}';
    }
}
