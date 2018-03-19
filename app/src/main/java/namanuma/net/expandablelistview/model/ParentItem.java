package namanuma.net.expandablelistview.model;

import java.util.List;

/**
 * Created by k.oinuma on 2018/03/19.
 */

public class ParentItem {

    private String name;
    private List<Item> items;

    public ParentItem(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<Item> getChilds() {
        return items;
    }
}
