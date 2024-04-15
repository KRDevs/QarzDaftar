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

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context, ArrayList<User> userArrayList) {

        super(context, R.layout.debt_item, userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.debt_item, parent, false);
        }
        TextView name = convertView.findViewById(R.id.personName);
        TextView date = convertView.findViewById(R.id.personDebtDate);
        TextView debt = convertView.findViewById(R.id.personDebt);
        name.setText(user.name);
        date.setText(user.date);
        debt.setText(user.debt);

        return convertView;
    }
}
