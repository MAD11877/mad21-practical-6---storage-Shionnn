package sg.edu.np.prac2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

import static sg.edu.np.prac2.ListActivity.staticInfoList;

public class DBHandler extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "accountsDB.db";
    public static String ACCOUNTS = "Accounts";
    public static String COLUMN_ID = "id";
    public static String COLUMN_USERNAME = "Username";
    public static String COLUMN_DESC = "Description";
    public static String COLUMN_BOOLEAN = "Followed";
    public static int DATABASE_VERSION = 1;

    public DBHandler(@Nullable Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNTS_TABLE = "CREATE TABLE " + ACCOUNTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USERNAME + " TEXT," + COLUMN_DESC + " TEXT," + COLUMN_BOOLEAN + " INTEGER" + ")";
        //CREATE TABLE ACCOUNTS
        db.execSQL(CREATE_ACCOUNTS_TABLE);



        for(int i = 0;i < 20; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_USERNAME, "NAME-" + randomNumber());
            values.put(COLUMN_DESC, "Description-" + randomNumber());
            values.put(COLUMN_BOOLEAN, new Random().nextInt()%2 == 0);
            db.insert(ACCOUNTS,null,values);
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + ACCOUNTS);
        onCreate(db);
    }

    public ArrayList<User> GetUsers(){
        ArrayList<User> queryDataList = new ArrayList<>();
        String query = "SELECT * FROM " + ACCOUNTS;

        //SELECT * FROM ACCOUNTS

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);



        while(cursor.moveToNext()){
            User user = new User();
            user.setName(cursor.getString(1));
            user.setDescription(cursor.getString(2));
            user.setId(cursor.getInt(0));
            user.setFollowed(cursor.getInt(3)==0);
            queryDataList.add(user);

        }
        cursor.close();
        db.close();
        return queryDataList;
    }
    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("Followed", user.isFollowed());
        db.update("Accounts", args, COLUMN_ID+ " = " + user.getId(),null);

        db.close();
    }

    private int randomNumber(){
        Random ran = new Random();
        int ranValue = ran.nextInt(10000000);
        return ranValue;
    }

    private int randomFollowed(){
        Random ran = new Random();
        int ranValue = ran.nextInt(1);
        if (ranValue == 0){
            return 0;
        }
        else return 1;
    }
}
