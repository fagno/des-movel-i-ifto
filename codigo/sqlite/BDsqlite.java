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
    public static final int BD_VERSAO = 1;

    public BDsqlite(@Nullable Context context) {
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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
