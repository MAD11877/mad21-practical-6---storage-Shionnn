package sg.edu.np.prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static sg.edu.np.prac2.ListActivity.staticInfoList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private final static String TAG = "Main Activity";

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receiveData = getIntent();
//        int img = receiveData.getIntExtra("Image",0);
//        int userid = receiveData.getIntExtra("id",0);
//        String username = receiveData.getStringExtra("username");
//        String userdesc = receiveData.getStringExtra("desc");
//        boolean userfllw = receiveData.getBooleanExtra("fllw",false);

        int adapterPosition = receiveData.getIntExtra("adapter",0);
        User userList =  staticInfoList.get(adapterPosition);


        Log.v(TAG, "Create");
//        User user1 = new User(R.drawable.dog,"Lester","Very Handsome",123,false);
        ImageView image = findViewById(R.id.imageView3);
        Button follow = findViewById(R.id.button_follow);
        TextView name = findViewById(R.id.textView_name);
        TextView desc = findViewById(R.id.textView_desc);

        image.setImageLevel(R.drawable.dog);
        name.setText(userList.getName() + userList.getId());
        desc.setText(userList.getDescription());



        if (userList.isFollowed()) {
            follow.setText("unfollow");
        }
        else{
            follow.setText("follow");
        }

        follow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                MediaPlayer media = MediaPlayer.create(MainActivity.this,R.raw.start);
//                media.start();

                if (!userList.isFollowed()) {
                    Toast.makeText(getBaseContext(),"followed",Toast.LENGTH_SHORT).show();
                    follow.setText("unfollow");
                    userList.setFollowed(true);

                }
                else{
                    Toast.makeText(getBaseContext(),"unfollowed",Toast.LENGTH_SHORT).show();
                    follow.setText("follow");
                    userList.setFollowed(false);

                }
                DBHandler db = new DBHandler(MainActivity.this);
                db.updateUser(userList);
                Log.v(TAG,"UPDATED DB");


            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }

    @Override
    public void onClick(View v) {

    }
}