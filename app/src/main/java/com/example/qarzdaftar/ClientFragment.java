package com.example.qarzdaftar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClientFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClientFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private ClientListAdapter clientListAdapter;
    private ArrayList<Clients> clientsArrayList;

    public ClientFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClientFragment newInstance(String param1, String param2) {
        ClientFragment fragment = new ClientFragment();
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
        View view = inflater.inflate(R.layout.fragment_client, container, false);
        listView = view.findViewById(R.id.client_list);

        // Initialize userArrayList with your data
        clientsArrayList = new ArrayList<>();
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));
        clientsArrayList.add(new Clients("Komron Raximov", "12000"));


        // Initialize listAdapter and set it to the ListView
        clientListAdapter = new ClientListAdapter(getActivity(), clientsArrayList);
        listView.setAdapter(clientListAdapter);

        return view;
    }
}