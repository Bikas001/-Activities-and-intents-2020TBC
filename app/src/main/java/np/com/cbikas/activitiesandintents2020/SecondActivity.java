package np.com.cbikas.activitiesandintents2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    Button btnmsgReply;
    TextView tvMsg,tvMassageRecived;
    EditText etMsgReply;
    private final String KEY_INTENT="ABC";
    private final String KEY_INTENT1="ABCD";
    private final int REQUEST_KEY=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvMsg =findViewById(R.id.tvMsg);
        tvMassageRecived=findViewById(R.id.tvmassageRecevied);
        etMsgReply=findViewById(R.id.etMsgReply);


        Intent intent = getIntent();
        String msg= intent.getStringExtra(KEY_INTENT);
        tvMassageRecived.setText(msg);

        if(tvMassageRecived.equals("")){
            tvMassageRecived.setText("This Message is Empty");
            tvMassageRecived.setVisibility(View.VISIBLE);
        }else{
            tvMassageRecived.setText(msg);
            tvMassageRecived.setVisibility(View.VISIBLE);

        }


    }

    public void replyMessage(View view){
      String msgrep=etMsgReply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(KEY_INTENT1, msgrep);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();



    }

}
