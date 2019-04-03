package com.spirit.force.gestion_des_depenses_revenus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

        public static final int DATABASE_VERSION=1;
        public static final String TABLE_NAME="User";
        public static final String IDU="id";
        public static final String nameU="nom";
        public static final String prenomU="prenom";
        public static final String emailU="email";
        public static final String mdpU="mdp";
        public static final String paysU="pays";
        public static final String deviseU="devise";
        public static final String DATABASE_NAME="GestDepRev.db";
        private static final String SQL_CREATE_ENTRIES="CREATE TABLE "+ TABLE_NAME +
                " ("+IDU+" INTEGER PRIMARY KEY AUTOINCREMENT,"+nameU+" TEXT,"+prenomU+" TEXT,"+emailU+" TEXT,"+mdpU+" TEXT,"+paysU+" TEXT,"+deviseU+" TEXT)";

        public DataBaseHelper(Context context) {
            super(context, DATABASE_NAME,null,DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
            Log.d("red1","database created");

        }
        @Override

        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db,oldVersion,newVersion);

        }
        public void insert(String name, String prenom,String email,String mdp,
                           String pays, String devise)
        {
            Log.d("red1","invoke insert");
            SQLiteDatabase db=getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(nameU,name);
            values.put(prenomU,prenom);
            values.put(emailU,email);
            values.put(mdpU,mdp);
            values.put(paysU,pays);
            values.put(deviseU,devise);
            db.insert(TABLE_NAME,null,values);
        }
        public ArrayList<Utilisateur> read(){
            Log.d("red1","invoke read");
            SQLiteDatabase db=getReadableDatabase();
            Cursor cursor=db.query(TABLE_NAME,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
            ArrayList<Utilisateur> itemTitles=new ArrayList<Utilisateur>();
            while (cursor.moveToNext()){
                String nom=cursor.getString(cursor.getColumnIndexOrThrow("nom"));
                String prenom=cursor.getString(cursor.getColumnIndexOrThrow("prenom"));
                String email=cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String mdp=cursor.getString(cursor.getColumnIndexOrThrow("mdp"));
                String pays=cursor.getString(cursor.getColumnIndexOrThrow("pays"));
                String devise=cursor.getString(cursor.getColumnIndexOrThrow("devise"));

                Utilisateur event=new Utilisateur(nom,prenom,email,mdp,pays,devise);
                itemTitles.add(event);
            }
            cursor.close();
            return itemTitles;
        }
    }
