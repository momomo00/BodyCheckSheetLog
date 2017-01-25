package momomo00.bodychecksheetlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectFunction();
    }

    private void selectFunction() {
        TextView    toRegisterScreenTV = (TextView)findViewById(R.id.to_register_screen);
        toRegisterScreenTV.setOnClickListener(this);

        TextView    displayInListTV = (TextView)findViewById(R.id.display_in_list);
        displayInListTV.setOnClickListener(this);

        TextView    displayInGraphTV = (TextView)findViewById(R.id.display_in_graph);
        displayInGraphTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.to_register_screen:
                toRegisterScreen();
                break;
            case R.id.display_in_list:
                displayInList();
                break;
            case R.id.display_in_graph:
                displayInGraph();
                break;
            default:
                break;
        }
    }

    private void toRegisterScreen() {
        Intent  inputBodyLogScreen = new Intent(this, InputBodyLog.class);
        startActivity(inputBodyLogScreen);
    }

    private void displayInList() {
        Toast.makeText(this, "まだ未実装だよ", Toast.LENGTH_SHORT).show();
    }

    private void displayInGraph() {
        Toast.makeText(this, "まだ未実装だよ", Toast.LENGTH_SHORT).show();
    }
}
