package momomo00.bodychecksheetlog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.text.format.DateFormat;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * 日付を管理する
 * Created by songo_000 on 2017/01/22.
 */

public class DateManager {
    private Activity    mActivity;

    /**
     * 画面内のID
     */
    // 現在の日付
    private TextView    mRecordingDate;
    // 次の日ボタン
    private Button  mNextButton;
    // 前の日ボタン
    private Button  mPrevButton;

    // 画面に表示中の日付
    private Calendar    mCalendar;

    public DateManager(Activity activity) {
        mActivity = activity;

        // 画面内のIDを取得
        getIdInScreen();

        // 現在の日時を画面に設定
        setCurrentDate();

        // 次の日付を選択された場合
        mNextButton.setOnClickListener(mOnClickListener);
        // 前の日付を選択された場合
        mPrevButton.setOnClickListener(mOnClickListener);
        // 日付入力が選択された場合
        mRecordingDate.setOnClickListener(mOnClickListener);
    }

    /**
     * 画面上のIDを内部に保存
     */
    private void getIdInScreen() {
        mRecordingDate = (TextView)mActivity.findViewById(R.id.recordingDate);
        mNextButton = (Button)mActivity.findViewById(R.id.nextButton);
        mPrevButton = (Button)mActivity.findViewById(R.id.prevButton);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.recordingDate:
                    setAnyDate();
                    break;
                case R.id.nextButton:
                    setNextDate();
                    break;
                case R.id.prevButton:
                    setPrevDate();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 現在の日付を設定
     */
    private void setCurrentDate() {
        mCalendar = Calendar.getInstance();
        setDateInScreen(mCalendar);
    }

    /**
     * 現在表示されている日付の次の日を設定
     */
    private void setNextDate() {
        mCalendar.add(Calendar.DAY_OF_MONTH, 1);
        setDateInScreen(mCalendar);
    }

    /**
     * 現在表示されている日付の前の日を設定
     */
    private void setPrevDate() {
        mCalendar.add(Calendar.DAY_OF_MONTH, -1);
        setDateInScreen(mCalendar);
    }

    /**
     * 任意の日付を設定
     */
    private void setAnyDate() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                mActivity,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mCalendar.set(year, monthOfYear, dayOfMonth);
                        setDateInScreen(mCalendar);
                    }
                },
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    /**
     * 画面に日付を設定する
     * @param calendar  日付
     */
    private void setDateInScreen(Calendar calendar) {
        CharSequence date = DateFormat.format("yyyy.MM.dd", calendar);
        mRecordingDate.setText(date);
    }

    public String getCalendarDate() {
        return DateFormat.format("yyyy.MM.dd", mCalendar).toString();
    }
}
