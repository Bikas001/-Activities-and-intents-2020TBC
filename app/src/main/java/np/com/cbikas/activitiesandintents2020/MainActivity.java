package np.com.cbikas.activitiesandintents2020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnsend;
    TextView tvMassage,tvReply;
    EditText etmsg;
    private final String KEY_INTENT="ABC";
    private final int REQUEST_KEY= 1;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMassage=findViewById(R.id.tvMassage);
        tvReply=findViewById(R.id.tvReply);
        etmsg=findViewById(R.id.etMsgsend);
        tvReply.setVisibility(View.INVISIBLE);

        tvMassage.setVisibility(View.INVISIBLE);


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
}
