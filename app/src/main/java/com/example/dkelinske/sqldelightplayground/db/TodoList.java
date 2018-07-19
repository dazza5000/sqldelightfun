/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.dkelinske.sqldelightplayground.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.dkelinske.sqldelightplayground.data.TodoItemModel;
import com.example.dkelinske.sqldelightplayground.data.TodoListModel;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

import rx.functions.Func1;

// Note: normally I wouldn't prefix table classes but I didn't want 'List' to be overloaded.
@AutoValue
public abstract class TodoList implements TodoListModel, Parcelable {
    public static final String TABLE = "todo_list";

    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String ARCHIVED = "archived";

    @SuppressWarnings("StaticInitializerReferencesSubClass")
    public static Factory<TodoList> FACTORY = new Factory<>(new TodoListModel.Creator<TodoList>() {
        @Override
        public TodoList create(long _id, @NonNull String name, @Nullable Boolean archived) {
            return new AutoValue_TodoList(_id, name, archived);
        }
    });

    public static RowMapper<String> NAME_MAPPER = FACTORY.select_name_by_idMapper();

    public static RowMapper<ListsItem> LISTS_ITEM_MAPPER =
            FACTORY.select_lists_with_item_countsMapper(AutoValue_TodoList_ListsItem::new);

    public static Func1<Cursor, ListsItem> LISTS_ITEM_MAPPER_FUNCTION = LISTS_ITEM_MAPPER::map;

    @AutoValue
    public static abstract class ListsItem implements Select_lists_with_item_countsModel {}




//    public static final RowMapper<ListsWithItems> SELECT_ALL_INFO_MAPPER =
//            FACTORY.select_lists_with_itemsMapper(new Factory<ListsWithItems>(new TodoList.Select_lists_with_itemsCreator<TodoList, TodoItem, ListsWithItems>() {
//                @Override
//                public ListsWithItems create(@NonNull TodoList todo_list, @Nullable TodoItem todo_item) {
//                    return new AutoValue_TodoList_ListsWithItems(todo_list, todo_item);
//                }
//            }), TodoItem.FACTORY.creator);



    //
    public static final class Builder {
        private final ContentValues values = new ContentValues();

        public Builder id(long id) {
            values.put(ID, id);
            return this;
        }

        public Builder name(String name) {
            values.put(NAME, name);
            return this;
        }

        public Builder archived(boolean archived) {
            values.put(ARCHIVED, archived);
            return this;
        }

        public ContentValues build() {
            return values; // TODO defensive copy?
        }
    }
}
