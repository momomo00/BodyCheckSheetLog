package momomo00.bodychecksheetlog;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import momomo00.bodychecksheetlog.FeedReaderContract.FeedEntry;

/**
 * Created by songo_000 on 2017/01/31.
 */

public class ShowBodyLog extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_body_log);

        setMyActionBar();

//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.showBodyLogMain, new ShowBodyLog1());
//        fragmentTransaction.commit();

        showListItem();
    }

    private void setMyActionBar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.showBodyLogToolbar);
        setSupportActionBar(toolbar);

        ActionBar   actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        Spinner spinner = (Spinner)toolbar.findViewById(R.id.showBodyLogToolbarSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.show_body_log_menu_list, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(mOnItemSelectedListener);
    }

    private AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//            CharSequence charSequence = (CharSequence)adapterView.getItemAtPosition(i);
//            switch(i) {
//                case 0:
//                    replaceShowBodyLog(new ShowBodyLog1());
//                    break;
//                case 1:
//                    replaceShowBodyLog(new ShowBodyLog2());
//                    break;
//                case 2:
//                    replaceShowBodyLog(new ShowBodyLog3());
//                    break;
//                default:
//                    break;
//            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private void replaceShowBodyLog(Fragment fragment) {
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.showBodyLogMain, fragment);
//        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.show_body_log_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result;

        switch(item.getItemId()) {
            default:
                result = super.onOptionsItemSelected(item);
                break;
        }
        return result;
    }

    private void showListItem() {
        SQLiteDatabase read = FeedReaderDbHelper.getInstance(this).getReadableDatabase();
        String  projection[] = {
                FeedEntry.INPUT_DATE,
                FeedEntry.BODY_WEIGHT
//                FeedEntry.BODY_FAT_PERCENTAGE,
//                FeedEntry.BODY_AGE,
//                FeedEntry.BMI,
//                FeedEntry.BASAL_METABOLISM,
//                FeedEntry.SKELETAL_MUSCLE_RATIO,
//                FeedEntry.VISCERAL_FAT_LEVEL,
//                FeedEntry.BODY_TRUNK_SUBCUTANEOUS_FAT_RATIO
        };

        Cursor cursor = read.query(FeedReaderContract.FeedEntry.TABLE_NAME, projection, null, null, null, null, null);
        startManagingCursor(cursor);
        cursor.moveToFirst();

        String[]    fromColumns = {FeedEntry.INPUT_DATE, FeedEntry.BODY_WEIGHT};
        int[] toViews = {R.id.show_body_log_date, R.id.show_body_log_attr};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.show_body_log_list_item, cursor, fromColumns, toViews
        );
        ListView listView = (ListView)findViewById(R.id.show_body_log_list);
        listView.setAdapter(adapter);


//
//        String inputDate;
//        double bodyWeight;
//        double bodyFatPercentage;
//        int bodyAge;
//        double BMI;
//        double basalMetabolism;
//        double skeletalMuscleRatio;
//        double visceralFatLevel;
//        double bodyTrunkSubcutaneousFatRatio;
//
//        for(boolean isEof = cursor.moveToFirst(); isEof; isEof = cursor.moveToNext()) {
//            inputDate = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.INPUT_DATE));
//            bodyWeight = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.BODY_WEIGHT));
//            bodyFatPercentage = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.BODY_FAT_PERCENTAGE));
//            bodyAge = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.BODY_AGE));
//            BMI = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.BMI));
//            basalMetabolism = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.BASAL_METABOLISM));
//            skeletalMuscleRatio = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.SKELETAL_MUSCLE_RATIO));
//            visceralFatLevel = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.VISCERAL_FAT_LEVEL));
//            bodyTrunkSubcutaneousFatRatio = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.BODY_TRUNK_SUBCUTANEOUS_FAT_RATIO));
//
//            Log.d("InputBodyLog", "INPUT_DATE: " + inputDate + " BODY_WEIGHT: " + bodyWeight + " BODY_FAT_PERCENTAGE: " + bodyFatPercentage +
//                    " BODY_AGE: " + bodyAge + " BMI: " + BMI + " BASAL_METABOLISM: " + basalMetabolism + " SKELETAL_MUSCLE_RATIO: " + skeletalMuscleRatio +
//                    " VISCERAL_FAT_LEVEL: " + visceralFatLevel + " BODY_TRUNK_SUBCUTANEOUS_FAT_RATIO: " + bodyTrunkSubcutaneousFatRatio);
//        }
//
        cursor.close();
    }
}
