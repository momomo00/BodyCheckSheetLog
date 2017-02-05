package momomo00.bodychecksheetlog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import momomo00.bodychecksheetlog.FeedReaderContract.FeedEntry;

/**
 * Created by songo_000 on 2017/02/01.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FeedReader.db";
    private static final int DATABASE_VERSION = 1;

    private static FeedReaderDbHelper mInstance = null;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY, " +
                    FeedEntry.INPUT_DATE + " TEXT, " +
                    FeedEntry.BODY_WEIGHT + " REAL, " +
                    FeedEntry.BODY_FAT_PERCENTAGE + " REAL, " +
                    FeedEntry.BODY_AGE + " INTEGER, " +
                    FeedEntry.BMI + " REAL, " +
                    FeedEntry.BASAL_METABOLISM + " REAL, " +
                    FeedEntry.SKELETAL_MUSCLE_RATIO + " REAL, " +
                    FeedEntry.VISCERAL_FAT_LEVEL + " REAL, " +
                    FeedEntry.BODY_TRUNK_SUBCUTANEOUS_FAT_RATIO + " REAL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    private FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("FeedReaderDbHelper: ", SQL_CREATE_ENTRIES);
        Log.d("FeedReaderDbHelper: ", SQL_DELETE_ENTRIES);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public static FeedReaderDbHelper getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new FeedReaderDbHelper(context);
        }
        return mInstance;
    }
}
