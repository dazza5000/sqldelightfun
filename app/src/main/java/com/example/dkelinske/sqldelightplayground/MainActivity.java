package com.example.dkelinske.sqldelightplayground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.example.dkelinske.sqldelightplayground.db.DbOpenHelper;
import com.example.dkelinske.sqldelightplayground.db.TodoList;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.QueryObservable;
import com.squareup.sqlbrite.SqlBrite;
import com.squareup.sqldelight.SqlDelightStatement;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

//        listener = (Listener) this;
//        adapter = new ListsAdapter(this);

        SqlBrite.Builder builder = new SqlBrite.Builder();
        BriteDatabase database = builder.build().wrapDatabaseHelper(new DbOpenHelper(this), Schedulers.io());
        SqlDelightStatement statement = TodoList.FACTORY.select_name_by_id(1);
        Observable<String> todoListName = database.createQuery(statement.tables, statement.statement, statement.args).mapToOne(TodoList.FACTORY.select_name_by_idMapper()::map);
        todoListName.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("Darran", "The todo list name is: " +s);
            }
        });

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
//        subscription.unsubscribe();
    }
}
