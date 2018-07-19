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
import com.google.auto.value.AutoValue;

import java.util.function.Function;

@AutoValue
public abstract class TodoItem implements TodoItemModel {
    public static final String TABLE = "todo_item";

    public static final String ID = "_id";
    public static final String LIST_ID = "todo_list_id";
    public static final String DESCRIPTION = "description";
    public static final String COMPLETE = "complete";

    public static Factory<TodoItem> FACTORY = new Factory<>(new TodoItem.Creator<TodoItem>() {
        @Override
        public TodoItem create(long _id, long listId, @NonNull String description, @Nullable Boolean archived) {
            return new AutoValue_TodoItem(_id, listId, description, archived);
        }
    });

    public static final Function<Cursor, TodoItem> MAPPER = new Function<Cursor, TodoItem>() {
        @Override public TodoItem apply(Cursor cursor) {
            long id = Db.getLong(cursor, ID);
            long listId = Db.getLong(cursor, LIST_ID);
            String description = Db.getString(cursor, DESCRIPTION);
            boolean complete = Db.getBoolean(cursor, COMPLETE);
            return new AutoValue_TodoItem(id, listId, description, complete);
        }
    };
}