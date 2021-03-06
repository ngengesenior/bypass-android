package in.uncod.android.bypass.style;

import android.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;

import com.commit451.bypass.R;

import in.uncod.android.bypass.Table;
import in.uncod.android.bypass.adapter.TableAdapter;

public class TableClickSpan extends ClickableSpan {

    private String mTitle;
    private Table mTable;

    public TableClickSpan(String title, Table table) {
        mTitle = title;
        mTable = table;
    }

    @Override
    public void onClick(View view) {
        View containerView = LayoutInflater.from(view.getContext()).inflate(R.layout.table_dialog, null);
        RecyclerView recView = (RecyclerView) containerView.findViewById(R.id.rec_view);
        recView.setLayoutManager(new GridLayoutManager(view.getContext(), mTable.getRows().get(0).getCells().size(),
                GridLayoutManager.VERTICAL, false));
        recView.setAdapter(new TableAdapter(mTable));
        new AlertDialog.Builder(view.getContext())
                .setTitle(mTitle)
                .setView(containerView)
                .show();
    }
}
