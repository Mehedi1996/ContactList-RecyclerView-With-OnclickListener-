package com.example.mehed.contact_listrecycleview;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    Context context;
    ClickListener listener;
    ArrayList<Contact>contactList;


        public ContactAdapter(Context context, ArrayList<Contact> contactList,ClickListener listener) {
        this.context = context; //ArrayList & Context k call korar jonno constructor create korci
        this.contactList = contactList;
        this.listener=listener;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.sample_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Contact contact=contactList.get(i);
        myViewHolder.name.setText(contact.getName());//Contract ArrayList thake data set kore
        myViewHolder.phone.setText(contact.getPhone());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nameTV);
            phone=itemView.findViewById(R.id.phoneTV);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onclick(contactList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface  ClickListener{
        public void onclick(Contact contact);

    }
}
