package com.example.exemplo_sqlite.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BDsqlite extends SQLiteOpenHelper {

    public static final String BD_NAME = "bdsqlite";
    //If you change the database schema, you must increment the database version.
    public static final int BD_VERSAO = 1;

    public BDsqlite(@Nullable Context context) {

        /**
         * super(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
         * @param context to use for locating paths to the the database This value may be null.
         * @param name of the database file, or null for an in-memory database This value may be null.
         * @param factory SQLiteDatabase.CursorFactory: to use for creating cursor objects, or null for the default This value may be null.
         * @param version int: number of the database (starting at 1); if the database is older, onUpgrade(SQLiteDatabase, int, int) 
         * will be used to upgrade the database; if the database is newer, onDowngrade(SQLiteDatabase, int, int) will be used to downgrade the database
         */
        super(context, BD_NAME, null, BD_VERSAO);
    }

    /**
     * Responsável por GERAR A TABELA TB_PESSOA NO BANCO
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE TB_PESSOA(");
        query.append(" ID INTEGER PRIMARY KEY AUTOINCREMENT,");
        query.append(" NOME TEXT NOT NULL,");
        query.append(" IDADE INT NOT NULL)");

        db.execSQL(query.toString());
    }

    /**
     * Called when the database needs to be upgraded. The implementation should use this method to drop tables, 
     * add tables, or do anything else it needs to upgrade to the new schema version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
