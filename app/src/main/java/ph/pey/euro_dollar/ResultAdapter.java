package ph.pey.euro_dollar;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bertrand on 19/01/18.
 */

public class ResultAdapter implements ListAdapter {


    private LinkedList<String> items = new LinkedList<>();
    private DataSetObserver dataSetObserver;
    private Context applicationContext;

    public ResultAdapter(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.dataSetObserver = dataSetObserver;
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.dataSetObserver = null;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(this.applicationContext);
        textView.setText(items.get(i));
        return textView;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public void addResult(String i) {
        items.addFirst(i);
        if(this.dataSetObserver != null)
            this.dataSetObserver.onChanged();
    }
}
