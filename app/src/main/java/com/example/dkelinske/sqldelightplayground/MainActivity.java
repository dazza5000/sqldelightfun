package com.example.dkelinske.sqldelightplayground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;


import com.squareup.sqlbrite.BriteDatabase;


import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    interface Listener {
        void onListClicked(long id);

        void onNewListClicked();
    }

    BriteDatabase db;

    ListView listView;
    View emptyView;

    private Listener listener;
    private ListsAdapter adapter;
    private Subscription subscription;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
//        MenuItem item = menu.add(R.string.new_list)
//                .setOnMenuItemClickListener(clickedItem -> {
//                    listener.onNewListClicked();
//                    return true;
//                });
//        MenuItemCompat.setShowAsAction(item, SHOW_AS_ACTION_IF_ROOM | SHOW_AS_ACTION_WITH_TEXT);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(android.R.id.list);

        listener = (Listener) this;
        adapter = new ListsAdapter(this);
    }


    @Override
    public void onResume() {
        super.onResume();

//        subscription = db.createQuery(ListsItem.TABLES, ListsItem.QUERY)
//                .mapToList(ListsItem.MAPPER)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        subscription.unsubscribe();
    }
}
