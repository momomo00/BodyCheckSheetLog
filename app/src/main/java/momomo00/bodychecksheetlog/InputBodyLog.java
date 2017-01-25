package momomo00.bodychecksheetlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_body_log);

        // 画面内のIDを保存
        getIdInScreen();

        // 日付の管理を行う
        new DateManager(this);

        // 登録を押されたとき
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRegisterButton();
            }
        });
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

    private void onClickRegisterButton() {
        double bodyWeight = Double.parseDouble(mBodyWeight.getText().toString());
        double bodyFatPercentage = Double.parseDouble(mBodyFatPercentage.getText().toString());
        int bodyAge = Integer.parseInt(mBodyAge.getText().toString());
        double BMI = Double.parseDouble(mBMI.getText().toString());
        double basalMetabolism = Double.parseDouble(mBasalMetabolism.getText().toString());
        double skeletalMuscleRatio = Double.parseDouble(mSkeletalMuscleRatio.getText().toString());
        double visceralFatLevel = Double.parseDouble(mVisceralFatLevel.getText().toString());
        double bodyTrunkSubcutaneousFatRatio = Double.parseDouble(mBodyTrunkSubcutaneousFatRatio.getText().toString());

        Toast.makeText(this, "体重: " + String.valueOf(bodyWeight), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "体脂肪率: " + String.valueOf(bodyFatPercentage), Toast.LENGTH_SHORT).show();
    }
}
