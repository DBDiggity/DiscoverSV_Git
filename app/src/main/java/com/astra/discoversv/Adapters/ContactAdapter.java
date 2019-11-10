package com.astra.discoversv.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astra.discoversv.Items.Contact;
import com.astra.discoversv.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactVH> {

    Context context;
    List<Contact> contacts;
    String type;

    public ContactAdapter(Context context, String type) {
        this.context = context;
        this.type = type;

        contacts = new Contact().initContacts(type);
    }

    class ContactVH extends RecyclerView.ViewHolder {

       TextView name, address, seating;
       ImageView phone;

       public ContactVH(@NonNull View itemView) {
           super(itemView);

           name = itemView.findViewById(R.id.contact_title);
           address = itemView.findViewById(R.id.contact_address);
           seating = itemView.findViewById(R.id.contact_seats);
           phone = itemView.findViewById(R.id.contact_phone);

       }
   }

    @NonNull
    @Override
    public ContactAdapter.ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.card_contact, parent, false);
        return new ContactVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactVH holder, int position) {
        Contact contact = contacts.get(position);
            holder.name.setText(contact.getName());
            holder.address.setText("Location: " + contact.getAddress());
            holder.seating.setText("# of Seats: " + contact.getDescription());
            holder.phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + contact.getNumber()));
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
