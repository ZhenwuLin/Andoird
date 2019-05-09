package com.example.fragmentswitcherdemo;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class FirstFragment extends Fragment {
    private Button button;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button a =  (Button)view.findViewById(R.id.bigdata); //跳转到大数据百科
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.baike.bigdata.class);
                startActivity(intent);
            }
        });

        Button b =  (Button)view.findViewById(R.id.lot); //跳转到大数据百科
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.baike.lot.class);
                startActivity(intent);
            }
        });
        Button c =  (Button)view.findViewById(R.id.ai); //跳转到大数据百科
        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.baike.ai.class);
                startActivity(intent);
            }
        });
        Button d =  (Button)view.findViewById(R.id.blockchain); //跳转到大数据百科
        d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.baike.blockchain.class);
                startActivity(intent);
            }
        });
        Button e =  (Button)view.findViewById(R.id.cloud); //跳转到大数据百科
        e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.baike.cloud.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
