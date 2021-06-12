package sg.edu.np.prac2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userViewHolder> {
        ArrayList<User> data;
        public userAdapter(ArrayList<User> input){
        data = input;
    }
    public userViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item;
        if (viewType == 0){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_recyclerview,parent,false);
        }
        else item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_recyclerview2,parent,false);

        return new userViewHolder(item,data);
    }
    public void onBindViewHolder(userViewHolder holder, int position){
        User userList = data.get(position);
        if (holder.image2 != null){
            holder.image2.setImageResource(R.drawable.dog);

        }
        holder.image.setImageResource(R.drawable.dog);
        holder.txtName.setText(userList.getName() + userList.getId());
        holder.txtDesc.setText("Description: " + userList.getDescription());




    }


    @Override
    public int getItemCount(){
        return data.size();
    }
    @Override
    public int getItemViewType(int position) {
        User userList = data.get(position);
        int id = userList.getId();
        if (id%10 == 7){
            return 1;
        }
        else return 0;
    }



}
