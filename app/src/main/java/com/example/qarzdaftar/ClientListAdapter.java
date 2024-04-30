package com.example.qarzdaftar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ClientListAdapter extends ArrayAdapter<Clients> {

    public ClientListAdapter(Context context, ArrayList<Clients> clientsArrayList) {

        super(context, R.layout.client_item, clientsArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Clients clients = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.client_item, parent, false);
        }
        TextView name = convertView.findViewById(R.id.clientName);
        TextView phone = convertView.findViewById(R.id.clientPhone);
        name.setText(clients.name);
        phone.setText(clients.phoneNumber);


        return convertView;
    }
}

