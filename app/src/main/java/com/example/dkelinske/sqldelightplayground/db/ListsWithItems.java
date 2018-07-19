package com.example.dkelinske.sqldelightplayground.db;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.dkelinske.sqldelightplayground.data.TodoItemModel;
import com.example.dkelinske.sqldelightplayground.data.TodoListModel;
import com.google.auto.value.AutoValue;

@AutoValue
public  abstract class ListsWithItems implements TodoListModel.Select_lists_with_itemsModel<TodoList, TodoItem> {
//    @SuppressWarnings("StaticInitializerReferencesSubClass")
//    public static TodoListModel.Factory<ListsWithItems> FACTORY = new TodoListModel.Factory<>(new TodoListModel.Select_lists_with_itemsModel<TodoListModel, TodoItemModel>().Creator<ListsWithItems>() {
//        @Override
//        public ListsWithItems create(long _id, @NonNull String name, @Nullable Boolean archived) {
//            return new AutoValue_TodoList(_id, name, archived);
//        }
//    });
}