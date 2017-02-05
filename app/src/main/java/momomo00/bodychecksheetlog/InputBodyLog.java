package momomo00.bodychecksheetlog;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import momomo00.bodychecksheetlog.FeedReaderContract.FeedEntry;

/**
 * Created by songo_000 on 2017/01/22.
 */

public class InputBodyLog extends AppCompatActivity {
    /**
     * 画面内のID
     */
    private EditText    mBodyWeight;
    private EditText    mBodyFatPercentage;
    private EditText    mBodyAge;
    private EditText    mBMI;
    private EditText    mBasalMetabolism;
    private EditText    mSkeletalMuscleRatio;
    private EditText    mVisceralFatLevel;
    private EditText    mBodyTrunkSubcutaneousFatRatio;
    private Button mRegisterButton;

    private DateManager mDateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_body_log);

        setActionBarSettings();

        // 画面内のIDを保存
        getIdInScreen();

        // 日付の管理を行う
        mDateManager = new DateManager(this);

        // 登録を押されたとき
        mRegisterButton.setOnClickListener(mOnClickListener);
    }

    private void setActionBarSettings() {
        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("登録画面");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.input_body_log_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result;

        switch(item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "onSettings", Toast.LENGTH_SHORT).show();
                result = true;
                break;
            default:
                result = super.onOptionsItemSelected(item);
                break;
        }
        return result;
    }

    /**
     * 画面内のIDを取得
     */
    private void getIdInScreen() {
        mBodyWeight = (EditText)findViewById(R.id.bodyWeight);
        mBodyFatPercentage = (EditText)findViewById(R.id.bodyFatPercentage);
        mBodyAge = (EditText)findViewById(R.id.bodyAge);
        mBMI = (EditText)findViewById(R.id.BMI);
        mBasalMetabolism = (EditText)findViewById(R.id.basalMetabolism);
        mSkeletalMuscleRatio = (EditText)findViewById(R.id.skeletalMuscleRatio);
        mVisceralFatLevel = (EditText)findViewById(R.id.visceralFatLevel);
        mBodyTrunkSubcutaneousFatRatio = (EditText)findViewById(R.id.bodyTrunkSubcutaneousFatRatio);
        mRegisterButton = (Button)findViewById(R.id.registerButton);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.registerButton:
                    onClickRegisterButton();
                    break;
                default:
                    break;
            }
        }
    };

    private void onClickRegisterButton() {
        insertBodyLog();
        Toast.makeText(this, "登録完了", Toast.LENGTH_SHORT).show();
    }

    private void insertBodyLog() {
        String inputDate = mDateManager.getCalendarDate();
        double bodyWeight = Double.parseDouble(mBodyWeight.getText().toString());
        double bodyFatPercentage = Double.parseDouble(mBodyFatPercentage.getText().toString());
        int bodyAge = Integer.parseInt(mBodyAge.getText().toString());
        double BMI = Double.parseDouble(mBMI.getText().toString());
        double basalMetabolism = Double.parseDouble(mBasalMetabolism.getText().toString());
        double skeletalMuscleRatio = Double.parseDouble(mSkeletalMuscleRatio.getText().toString());
        double visceralFatLevel = Double.parseDouble(mVisceralFatLevel.getText().toString());
        double bodyTrunkSubcutaneousFatRatio = Double.parseDouble(mBodyTrunkSubcutaneousFatRatio.getText().toString());

        SQLiteDatabase db = FeedReaderDbHelper.getInstance(this).getWritableDatabase();

        ContentValues   values = new ContentValues();
        values.put(FeedEntry.INPUT_DATE, inputDate);
        values.put(FeedEntry.BODY_WEIGHT, bodyWeight);
        values.put(FeedEntry.BODY_FAT_PERCENTAGE, bodyFatPercentage);
        values.put(FeedEntry.BODY_AGE, bodyAge);
        values.put(FeedEntry.BMI, BMI);
        values.put(FeedEntry.BASAL_METABOLISM, basalMetabolism);
        values.put(FeedEntry.SKELETAL_MUSCLE_RATIO, skeletalMuscleRatio);
        values.put(FeedEntry.VISCERAL_FAT_LEVEL, visceralFatLevel);
        values.put(FeedEntry.BODY_TRUNK_SUBCUTANEOUS_FAT_RATIO, bodyTrunkSubcutaneousFatRatio);

        db.insert(FeedEntry.TABLE_NAME, null, values);
    }
}
