package sg.edu.np.prac2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class userViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ArrayList<User> data;

    TextView txtName;
    TextView txtDesc;
    ImageView image;
    ImageView image2;


    public userViewHolder(View itemView,ArrayList<User> input){
        super(itemView);
        txtName = itemView.findViewById(R.id.userName);
        txtDesc = itemView.findViewById(R.id.userDesc);
        image = itemView.findViewById(R.id.userImageView);
        image2 = itemView.findViewById(R.id.userImageView2);
        itemView.setOnClickListener(this);
        data = input;
    }



    @Override
    public void onClick(View v) {
        User userList = data.get(getAdapterPosition());
        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
        builder.setMessage(userList.getName() + userList.getId());
        builder.setTitle("Profile");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
//                intent.putExtra("image",userList.getImage());
//                intent.putExtra("username",userList.getName());
//                intent.putExtra("id",userList.getId());
//                intent.putExtra("desc",userList.getDescription());
//                intent.putExtra("fllw", userList.isFollowed());
                intent.putExtra("UserObj", (Serializable) userList);
                intent.putExtra("adapter",getAdapterPosition());
                v.getContext().startActivity(intent);
            }
        }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
