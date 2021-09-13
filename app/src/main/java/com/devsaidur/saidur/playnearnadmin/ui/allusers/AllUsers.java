package com.devsaidur.saidur.playnearnadmin.ui.allusers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devsaidur.saidur.playnearnadmin.Const;
import com.devsaidur.saidur.playnearnadmin.R;
import com.devsaidur.saidur.playnearnadmin.databinding.FragmentAllUsersBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllUsers extends Fragment {

    public AllUsers() {
        // Required empty public constructor
    }

    private FragmentAllUsersBinding fragmentAllUsersBinding;
    AllUsersAdapter allUsersAdapter;
    List<AllUserModel> alluserList = new ArrayList<AllUserModel>();

    FirebaseDatabase fdb;
    DatabaseReference dbr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentAllUsersBinding = FragmentAllUsersBinding.inflate(getLayoutInflater());
        View v = fragmentAllUsersBinding.getRoot();
        //return inflater.inflate(R.layout.fragment_all_users, container, false);
        fdb=FirebaseDatabase.getInstance();
        dbr=fdb.getReference(Const.userDash);

        alluserDatafromDB();

        return v;
    }

    private void alluserDatafromDB() {
        dbr.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot!=null)
                {
                    for (DataSnapshot ds:snapshot.getChildren()){
                        AllUserModel am=ds.getValue(AllUserModel.class);
                        //alluserList.add(ds.getValue().toString());
                        alluserList.add(am);
                        allUsersAdapter = new AllUsersAdapter(getActivity(), alluserList);
                        fragmentAllUsersBinding.rvAllusers.setLayoutManager(new GridLayoutManager(getActivity(),2));
                        fragmentAllUsersBinding.rvAllusers.setAdapter(allUsersAdapter);
                        Log.d("TAG", "onDataChange: "+am.account.getCurrent_bal());
                        //am.account.getCurrent_bal();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}