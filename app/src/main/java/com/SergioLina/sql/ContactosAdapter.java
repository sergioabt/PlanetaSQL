package com.SergioLina.sql;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by braya on 25/10/2017.
 */

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ContactosViewHolder>{

    Context context;
    private ArrayList<User> userList;

    public ContactosAdapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public ContactosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ContactosViewHolder contactosViewHolder = new ContactosViewHolder(itemView);
        return contactosViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactosViewHolder holder, int position) {

        User item = userList.get(position);
        holder.bindContactos(item,context);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ContactosViewHolder extends RecyclerView.ViewHolder{

        private TextView tId, tNameL,tNameA, tPhone, tName;

        public ContactosViewHolder(View itemView) {
            super(itemView);

            tId = itemView.findViewById(R.id.tID);
            tNameL = itemView.findViewById(R.id.tNameL);
            tNameA = itemView.findViewById(R.id.tNameA);
            tPhone = itemView.findViewById(R.id.tPhone);
            tName = itemView.findViewById(R.id.tName);

        }

        public void bindContactos(User user, Context context){
            tId.setText(user.getUid());
            tName.setText(user.getName());
            tPhone.setText(user.getPhone());
            tNameL.setText(user.getNameL());
            tNameA.setText(user.getNameA());

        }

    }

}
