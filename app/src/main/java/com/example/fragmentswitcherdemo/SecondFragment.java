package com.example.fragmentswitcherdemo;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class SecondFragment extends Fragment {
private Button button;
private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View view =inflater.inflate(R.layout.fragment_second, container, false);//infinit logo
        TextView main_title=view.findViewById(R.id.main_title);
        String main_str="<font color='#F56929'>    I</font><color='#3D2B2A'>n</font><font color='#AEF160'>" +
                "f</font><font color='#4F61D1'>i</font><font color='#AC85F3'>n</font><font color='#2DDDF3'>" +
                "i</font><font color='#EE1E03'>t</fond>";
        main_title.setText(Html.fromHtml(main_str));

        Button b =(Button)view.findViewById(R.id.button1); //跳转到搜索页面
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }


}
