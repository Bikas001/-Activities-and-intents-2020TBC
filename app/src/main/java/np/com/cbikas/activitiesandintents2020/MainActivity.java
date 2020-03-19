package np.com.cbikas.activitiesandintents2020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnsend;
    public static final String LOG_TAG="MainActivity";
    TextView tvMassage,tvReply;
    EditText etmsg;
    private final String KEY_INTENT="ABC";
    private final int REQUEST_KEY= 1;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        setContentView(R.layout.activity_main);
        tvMassage=findViewById(R.id.tvMassage);
        tvReply=findViewById(R.id.tvReply);
        etmsg=findViewById(R.id.etMsgsend);
        tvReply.setVisibility(View.INVISIBLE);

        tvMassage.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    public void runSecondActivity(View view){

        intent = new Intent(this, SecondActivity.class);
        String msg=etmsg.getText().toString();
        intent.putExtra(KEY_INTENT,msg);
        startActivity(intent);
        startActivityForResult(intent,REQUEST_KEY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_KEY){
            if(resultCode==RESULT_OK){
                String msg1=data.getStringExtra("ABCD");
                tvReply.setVisibility(View.VISIBLE);

                if(tvMassage == null){
                    tvMassage.setText("This Message is Empty");
                    tvMassage.setVisibility(View.VISIBLE);
                }else{
                    tvMassage.setText(msg1);
                    tvMassage.setVisibility(View.VISIBLE);

                }


            }
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
