package com.example.taskFromAl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NewsDataBase extends SQLiteOpenHelper {

    public NewsDataBase(Context context) {
        //Подключаемся к базе данных
        super(context, "AmazonNews", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Cоздаём таблицу
        db.execSQL("CREATE TABLE news (url text, startData text, andData text, name text, iconUrl text, objectType text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Уничтожаем таблицу
        db.execSQL("DROP TABLE IF EXISTS news");
        //Создаём заново
        onCreate(db);
    }

    public void wipeNews() {
        //Подключаем переменную с БД
        SQLiteDatabase db = this.getWritableDatabase();
        //Отправляем SQL для удаления данных
        db.execSQL("DELETE FROM news");
    }

    public void insertNews(String url, String startData, String andData, String name, String iconUrl, String objectType) {
        //Подключаем переменную с БД
        SQLiteDatabase db = this.getWritableDatabase();
        //Отправляем SQL для добавления данных
        db.execSQL("INSERT INTO news VALUES('" + url + "', '" + startData + "', '" + andData + "', '" + name + "', '" + iconUrl + "', '" + objectType + "')");

    }

    public ArrayList<AmazonNews> getNews() {

        ArrayList<AmazonNews> newsArray = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM news", null);
        result.moveToFirst();
        Integer i = 0;
        while (i < result.getCount()) {
            AmazonNews amazonNews = new AmazonNews();
            amazonNews.setUrl(result.getString(0));
            amazonNews.setStartDate(result.getString(1));
            amazonNews.setAndDate(result.getString(2));
            amazonNews.setName(result.getString(3));
            amazonNews.setIconUrl(result.getString(4));
            amazonNews.setObjType(result.getString(5));
            newsArray.add(amazonNews);
            i = i + 1;
            result.moveToNext();
        }
        return newsArray;
    }

}
