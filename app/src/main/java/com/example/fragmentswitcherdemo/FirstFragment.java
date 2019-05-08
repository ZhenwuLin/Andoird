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

        Button a = (Button) view.findViewById(R.id.bigdata_1); //跳转到大数据百科
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.baike.bigdata.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
