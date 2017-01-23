package momomo00.bodychecksheetlog;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by songo_000 on 2017/01/22.
 */

public class InputScreen {
    private Activity mActivity;

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

    public InputScreen(Activity activity) {
        mActivity = activity;

        getIdInScreen();

        // 日付の管理を行う
        new DateManager(mActivity);

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
        mBodyWeight = (EditText)mActivity.findViewById(R.id.bodyWeight);
        mBodyFatPercentage = (EditText)mActivity.findViewById(R.id.bodyFatPercentage);
        mBodyAge = (EditText)mActivity.findViewById(R.id.bodyAge);
        mBMI = (EditText)mActivity.findViewById(R.id.BMI);
        mBasalMetabolism = (EditText)mActivity.findViewById(R.id.basalMetabolism);
        mSkeletalMuscleRatio = (EditText)mActivity.findViewById(R.id.skeletalMuscleRatio);
        mVisceralFatLevel = (EditText)mActivity.findViewById(R.id.visceralFatLevel);
        mBodyTrunkSubcutaneousFatRatio = (EditText)mActivity.findViewById(R.id.bodyTrunkSubcutaneousFatRatio);
        mRegisterButton = (Button)mActivity.findViewById(R.id.registerButton);
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

        Toast.makeText(mActivity, "体重: " + String.valueOf(bodyWeight), Toast.LENGTH_SHORT).show();
        Toast.makeText(mActivity, "体脂肪率: " + String.valueOf(bodyFatPercentage), Toast.LENGTH_SHORT).show();
    }
}
