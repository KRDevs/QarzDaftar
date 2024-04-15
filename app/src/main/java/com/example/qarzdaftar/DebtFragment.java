package com.example.qarzdaftar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DebtFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<User> userArrayList;

    // Required empty public constructor
    public DebtFragment() {
    }

    // Use this factory method to create a new instance of this fragment
    public static DebtFragment newInstance(String param1, String param2) {
        DebtFragment fragment = new DebtFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_debt, container, false);
        listView = view.findViewById(R.id.debt_list);

        // Initialize userArrayList with your data
        userArrayList = new ArrayList<>();
        userArrayList.add(new User("Komron Raximov", "12000", "12.04.2024"));
        userArrayList.add(new User("Og'abek Xusinov", "100000", "10.04.2024"));
        userArrayList.add(new User("Ziyodulla Abdukarimov", "150000", "14.04.2024"));
        userArrayList.add(new User("Elomon Jumanazarov", "10000000", "03.04.2024"));

        // Initialize listAdapter and set it to the ListView
        listAdapter = new ListAdapter(getActivity(), userArrayList);
        listView.setAdapter(listAdapter);

        return view;
    }
}
