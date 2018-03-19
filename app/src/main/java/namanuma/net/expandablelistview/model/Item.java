package namanuma.net.expandablelistview.model;

/**
 * Created by k.oinuma on 2018/03/19.
 */

public class Item {

    private boolean check = false;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return check;
    }

    public String getName() {
        return name;
    }
}
