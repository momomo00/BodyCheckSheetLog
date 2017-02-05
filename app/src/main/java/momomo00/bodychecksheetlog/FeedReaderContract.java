package momomo00.bodychecksheetlog;

import android.provider.BaseColumns;

/**
 * Created by songo_000 on 2017/02/01.
 */

public class FeedReaderContract {
    private FeedReaderContract() {

    }

    public static class FeedEntry implements BaseColumns {
        // テーブル名
        public static final String  TABLE_NAME = "body_log_database";

        // 属性名
        public static final String  INPUT_DATE = "input_date";
        public static final String  BODY_WEIGHT = "body_weight";
        public static final String  BODY_FAT_PERCENTAGE = "body_fat_percentage";
        public static final String  BODY_AGE = "body_age";
        public static final String  BMI = "BMI";
        public static final String  BASAL_METABOLISM = "basal_metabolism";
        public static final String  SKELETAL_MUSCLE_RATIO = "skeletal_muscle_ratio";
        public static final String  VISCERAL_FAT_LEVEL = "visceral_fat_level";
        public static final String  BODY_TRUNK_SUBCUTANEOUS_FAT_RATIO = "body_trunk_subcutaneous_fat_ratio";
    }
}
