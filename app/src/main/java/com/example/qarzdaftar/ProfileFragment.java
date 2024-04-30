package com.example.qarzdaftar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.qarzdaftar.R;

public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Access the TableLayout
        TableLayout tableLayout = view.findViewById(R.id.tableLayout);

        // Create and add headers row
        TableRow headersRow = new TableRow(getActivity());
        String[] headers = {"Column 1", "Column 2", "Column 3", "Column 4"};
        for (String header : headers) {
            TextView textView = new TextView(getActivity());
            textView.setText(header);
            textView.setPadding(10, 0, 10, 0);
            headersRow.addView(textView);
        }
        tableLayout.addView(headersRow);

        // Example data rows
        String[][] data = {
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"Data 5", "Data 6", "Data 7", "Data 8"},
                // Add more data as needed
        };

        // Add data rows dynamically
        for (String[] rowData : data) {
            TableRow dataRow = new TableRow(getActivity());
            for (String datum : rowData) {
                TextView textView = new TextView(getActivity());
                textView.setText(datum);
                textView.setPadding(10, 0, 10, 0);
                dataRow.addView(textView);
            }
            tableLayout.addView(dataRow);
        }

        return view;
    }
}
