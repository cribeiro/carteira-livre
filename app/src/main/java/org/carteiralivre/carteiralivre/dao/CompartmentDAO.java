package org.carteiralivre.carteiralivre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.carteiralivre.carteiralivre.model.Compartment;
import org.carteiralivre.carteiralivre.util.Constants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompartmentDAO extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "compartment";

    public CompartmentDAO(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder tableFields = new StringBuilder("id INTEGER PRIMARY KEY, ");
        tableFields.append("name TEXT NOT NULL, ");
        tableFields.append("balance REAL NOT NULL, ");
        tableFields.append("description TEXT");

        String createTableSQL = String.format(
                "CREATE TABLE %s (%s);",
                TABLE_NAME,
                tableFields.toString());

        sqLiteDatabase.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long add(Compartment compartment) {
        ContentValues values = new ContentValues();
        values.put("name", compartment.getName());
        values.put("balance", compartment.getBalance().floatValue());
        values.put("description", compartment.getDescription());

        return this.getWritableDatabase().insert(TABLE_NAME, null, values);
    }

    public Compartment findById(Long id) {
        String findCompartmentSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?;";
        String[] args = {id.toString()};
        Cursor cursor = getReadableDatabase().rawQuery(findCompartmentSQL, args);
        cursor.moveToFirst();

        Compartment compartment = new Compartment();
        compartment.setId(cursor.getLong(cursor.getColumnIndex("id")));
        compartment.setName(cursor.getString(cursor.getColumnIndex("name")));

        compartment.setBalance(new BigDecimal(cursor.getString(cursor.getColumnIndex("balance"))));
        compartment.setDescription(cursor.getString(cursor.getColumnIndex("description")));

        return compartment;

    }

    public int removeAll() {
        return getWritableDatabase().delete(CompartmentDAO.TABLE_NAME, "1", null);
    }

}
