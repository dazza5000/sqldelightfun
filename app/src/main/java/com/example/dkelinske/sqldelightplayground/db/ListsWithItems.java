package com.example.dkelinske.sqldelightplayground.db;

import com.example.dkelinske.sqldelightplayground.data.TodoListModel;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ListsWithItems implements TodoListModel.Select_lists_with_itemsModel<TodoList, TodoItem> {
}


//    @SuppressWarnings("StaticInitializerReferencesSubClass")
//    public static TodoListModel.Factory<TodoList> FACTORY = new TodoListModel.Factory<>(new TodoListModel.Creator<TodoList>() {
//        @Override
//        public TodoList create(long _id, @NonNull String name, @Nullable Boolean archived) {
//            return new AutoValue_TodoList(_id, name, archived);
//        }
//    });