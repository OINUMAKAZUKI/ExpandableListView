package namanuma.net.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import namanuma.net.expandablelistview.adapter.MainActivityListAdapter;
import namanuma.net.expandablelistview.model.Item;
import namanuma.net.expandablelistview.model.ParentItem;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.expandable_list_view);
        listView.setAdapter(new MainActivityListAdapter(createItemList(), checkListener()));
    }

    private List<ParentItem> createItemList() {
        List<Item> child = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            child.add(new Item("アイテム1_" + i));
        }

        List<Item> child2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            child2.add(new Item("アイテム2_" + i));
        }

        List<ParentItem> parents = new ArrayList<>();
        parents.add(new ParentItem("ヘッダー1", child));
        parents.add(new ParentItem("ヘッダー2", child2));

        return parents;
    }

    private MainActivityListAdapter.OnCheckListener checkListener() {
        return new MainActivityListAdapter.OnCheckListener() {
            @Override
            public void onCheck(int position, boolean check) {
                /**
                 * チェックリストが押されるとここにフィードバックが返ってくる
                 */
                Log.d(TAG, "チェックされた場所:" + position + " チェックされた状態か？:" + check);
            }
        };
    }
}
