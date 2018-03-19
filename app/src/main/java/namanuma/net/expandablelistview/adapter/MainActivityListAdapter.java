package namanuma.net.expandablelistview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import namanuma.net.expandablelistview.R;
import namanuma.net.expandablelistview.model.ParentItem;

/**
 * Created by k.oinuma on 2018/03/19.
 */

public class MainActivityListAdapter extends BaseExpandableListAdapter {

    public interface OnCheckListener {
        void onCheck(int position, boolean check);
    }

    private List<ParentItem> groups;
    private  OnCheckListener listener;

    public MainActivityListAdapter(List<ParentItem> groups, OnCheckListener listener) {
        this.groups = groups;
        this.listener = listener;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).getChilds().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).getChilds().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
        TextView textView = parentView.findViewById(R.id.list_item_header_text_view);

        String headerName = groups.get(groupPosition).getName();
        textView.setText(headerName);
        return parentView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CheckBox checkBox = childView.findViewById(R.id.list_item_checkbox);

        boolean check = groups.get(groupPosition).getChilds().get(childPosition).isCheck();
        String name = groups.get(groupPosition).getChilds().get(childPosition).getName();
        checkBox.setChecked(check);
        checkBox.setText(name);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (listener != null) {
                    listener.onCheck(childPosition, isChecked);
                }
            }
        });
        return childView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
