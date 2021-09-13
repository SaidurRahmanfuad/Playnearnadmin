package com.devsaidur.saidur.playnearnadmin.ui.allusers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devsaidur.saidur.playnearnadmin.R;

import java.util.ArrayList;
import java.util.List;

public class AllUsersAdapter extends RecyclerView.Adapter<AllUsersAdapter.AUVH> {

    private Context context;
    private List<AllUserModel> noticeList;


    public AllUsersAdapter(Context context, List<AllUserModel> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @NonNull
    @Override
    public AUVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_alluser_layout, parent, false);
        AUVH dvh = new AUVH(v);
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AUVH holder, int position) {
        AllUserModel nm = noticeList.get(position);
        Account ac=new Account();

        holder.usernameShowTv.setText(nm.getUserName());
        holder.usermobileShowTv.setText(nm.getUserPhone());
        holder.useremailShowTv.setText(nm.getUserEmail());
      //  holder.userlevelShowTv.setText(nm.get());
        holder.userbalShowTv.setText(nm.getAccount().getCurrent_bal());
       // holder.userbalShowTv.setText(ac.getCurrent_bal());
//        Picasso.get().load(nm.getImage()).into(holder.notice_Image);
        //Picasso.get().load(Const.Base_Url + Const.Image_path + nm.getImage()).into(holder.notice_Image);
       /* if(nm.getImage().equals("no file"))
        {
            holder.notice_Image.setVisibility(View.GONE);
        }
        else {
            holder.notice_Image.setVisibility(View.VISIBLE);
            //Picasso.get().load(Constant.ImageBaseUrl+Constant.BlogImgPath+bloog.getBlogImage()).into(holder.notice_Image);
            Picasso.get().load(nm.getImage()).into(holder.notice_Image);
           // Picasso.get().load(nm.ge()).into(holder.notice_Image);
        }*/
    }

    @Override
    public int getItemCount() {
        return noticeList.size();
    }

    public class AUVH extends RecyclerView.ViewHolder {
        TextView usernameShowTv, usermobileShowTv, useremailShowTv,userlevelShowTv,userbalShowTv;
        ImageView user_Image;


        public AUVH(@NonNull View v) {
            super(v);
            usernameShowTv = v.findViewById(R.id.userName);
            usermobileShowTv = v.findViewById(R.id.userMobile);
            useremailShowTv = v.findViewById(R.id.userEmail);
            userlevelShowTv = v.findViewById(R.id.userlevel);
            userbalShowTv = v.findViewById(R.id.userbal);
            user_Image = v.findViewById(R.id.userImg);


        }
    }
}
