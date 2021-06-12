package sg.edu.np.prac2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    static ArrayList<User> staticInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TAG, "Create");

        DBHandler db = new DBHandler(this);


        staticInfoList = db.GetUsers();


        RecyclerView userRecyclerView = findViewById(R.id.recylerview);
        userAdapter userAdapter = new userAdapter(staticInfoList);
        LinearLayoutManager cLayoutManager = new LinearLayoutManager(this);
        userRecyclerView.setLayoutManager(cLayoutManager);
        userRecyclerView.setItemAnimator(new DefaultItemAnimator());
        userRecyclerView.setAdapter(userAdapter);

//        View imageClick = findViewById(R.id.userImageView);
//        imageClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertBox();
////            MediaPlayer media = MediaPlayer.create(ListActivity.this,R.raw.sus);
////            media.start();
//
//            }
//        });
    }



//    private void alertBox(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(findViewById(R.id.userName));
//        builder.setTitle("Profile");
//        builder.setCancelable(false);
//        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(ListActivity.this,MainActivity.class);
//                intent.putExtra("userList",userInfoList);
//                startActivity(intent);
//            }
//        });
//        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        AlertDialog alert = builder.create();
//        alert.show();
//    }
}