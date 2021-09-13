package com.devsaidur.saidur.playnearnadmin.ui.home;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.devsaidur.saidur.playnearnadmin.Const;
import com.devsaidur.saidur.playnearnadmin.R;
import com.devsaidur.saidur.playnearnadmin.databinding.FragmentHomeBinding;
import com.devsaidur.saidur.playnearnadmin.ui.match.MatchModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding fragmentHomeBinding;
    Dialog pop_creatematch;
    AutoCompleteTextView act_matcat,act_mattyp,act_matdate,actv_mtchseat;
    TextInputEditText matfee,winprize,matid;
    RelativeLayout btn_createmtc;
    List<String> match_catList = new ArrayList<>();
    List<String> match_typeList = new ArrayList<>();
    List<String> match_seatList = new ArrayList<>();
    ArrayAdapter<String> catListAdapter;
    ArrayAdapter<String> typeListAdapter;
    ArrayAdapter<String> seatListAdapter;
    String match_type, match_cat,match_seat;


    FirebaseDatabase fdb;
    DatabaseReference dbr;
    ProgressDialog pd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        fragmentHomeBinding = FragmentHomeBinding.inflate(getLayoutInflater());
        View v = fragmentHomeBinding.getRoot();
        //inflater.inflate(R.layout.fragment_home, container, false);
        fdb=FirebaseDatabase.getInstance();
        dbr=fdb.getReference(Const.adminDash);

        matchDataLoad();
        mtData();
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        iniPopup();
        fragmentHomeBinding.fabMatch.setOnClickListener(v1 -> {
            pop_creatematch.show();
        });
        return v;
    }

    private void matchDataLoad() {
       // dbr.child()
    }

    private void mtData() {
        match_catList.add("Ludo_Star");
        match_catList.add("Ludo_King");
        match_catList.add("Cricket");
        match_catList.add("Monopoly");
        catListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, match_catList);

        match_seatList.add("2");
        match_seatList.add("3");
        match_seatList.add("4");
        match_seatList.add("5");
        seatListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, match_seatList);

        match_typeList.add("1 vs 1");
        match_typeList.add("1 vs 4");
        match_typeList.add("Single Player");
        match_typeList.add("Multiplayer");
        typeListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, match_typeList);

    }
    private void iniPopup() {

        pop_creatematch = new Dialog(getContext());
        pop_creatematch.setContentView(R.layout.popup_crtmatch);
        //popAddQty.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pop_creatematch.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        pop_creatematch.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        pop_creatematch.getWindow().getAttributes().gravity = Gravity.CENTER;

        // ini popup widgets
        act_matcat = pop_creatematch.findViewById(R.id.actv_mtchCat);
        act_mattyp = pop_creatematch.findViewById(R.id.actv_mtchType);
        act_matdate = pop_creatematch.findViewById(R.id.actv_mtchSdate);
        actv_mtchseat = pop_creatematch.findViewById(R.id.actv_mtchseat);
        matfee = pop_creatematch.findViewById(R.id.tiet_mtchFee);
        winprize = pop_creatematch.findViewById(R.id.tiet_mtchWinprize);
        matid = pop_creatematch.findViewById(R.id.tiet_mtchId);
        btn_createmtc = pop_creatematch.findViewById(R.id.btn_createmtc);

        act_matcat.setAdapter(catListAdapter);
        act_matcat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                match_cat = parent.getItemAtPosition(position).toString();
            }
        });


        act_mattyp.setAdapter(typeListAdapter);
        act_mattyp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                match_type = parent.getItemAtPosition(position).toString();
            }
        });

        actv_mtchseat.setAdapter(seatListAdapter);
        actv_mtchseat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                match_seat = parent.getItemAtPosition(position).toString();
            }
        });
        btn_createmtc.setOnClickListener(v -> {
            createMatch();

        });
    }

    private void createMatch() {
        pd=new ProgressDialog(getActivity());
        pd.setMessage("Match Creating");
        pd.setCanceledOnTouchOutside(false);
        pd.show();

        MatchModel mm=new MatchModel();
        mm.setMatch_cat(match_cat);
        mm.setMatch_fee(matfee.getText().toString());
        mm.setMatch_prize(winprize.getText().toString());
        mm.setMatch_type(match_type);
        mm.setMatch_seat(match_seat);
        mm.setMatch_id(matid.getText().toString());
        mm.setMatch_styme(act_matdate.getText().toString());

        for(int i=0;i<Integer.parseInt(match_seat);i++)
        {
            mm.getPlayer().setP(String.valueOf(i+1));
            Toast.makeText(getActivity(),"p"+String.valueOf(i+1), Toast.LENGTH_SHORT).show();
        }
        dbr.child("Matches").child(match_cat).child(matid.getText().toString()).setValue(mm).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pd.dismiss();
                pop_creatematch.dismiss();
                Toast.makeText(getActivity(), "Match Created", Toast.LENGTH_SHORT).show();
            }
        });
    }
}