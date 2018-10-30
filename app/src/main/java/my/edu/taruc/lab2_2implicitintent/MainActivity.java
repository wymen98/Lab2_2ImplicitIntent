package my.edu.taruc.lab2_2implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Main Activity", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Main Activity", "onResume");
    }

    public void visitTARUC(View view){
        String uri = "http://www.tarc.edu.my";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));

        //Find an activity to hand the intent, and start that activity.
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else{
            //Log.d = Debug message
            Log.d("ImplicitIntents",  "Can't handle this intent!");
        }
    }

    public void showMain(View v){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "0189054890"));
        startActivity(intent);
    }

    public void showSendTo(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:" + "wymen1998@gmail.com"));
        startActivity(intent);
    }
}
