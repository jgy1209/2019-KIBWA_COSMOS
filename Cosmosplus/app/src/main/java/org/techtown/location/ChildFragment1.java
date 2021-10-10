package org.techtown.location;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChildFragment1 extends Fragment  {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    //EditText editText;
    MyAdapter myAdapter;

    ArrayList<SweetInfo> sweetInfoArrayList = new ArrayList<>();

    public static ChildFragment1 newInstance() {
        return new ChildFragment1();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fv = inflater.inflate(R.layout.child_fragment1, container, false);

        mRecyclerView = fv.findViewById(R.id.sweet_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //editText = fv.findViewById(R.id.sweet_edit);
        //editText.addTextChangedListener(this);
        //ArrayList<SweetInfo> sweetInfoArrayList = new ArrayList<>();


        sweetInfoArrayList.add(new SweetInfo(R.drawable.moka, "카페모카", "4,800원"));
        sweetInfoArrayList.add(new SweetInfo(R.drawable.caramel, "카라멜 마끼아또", "5,300원"));
        sweetInfoArrayList.add(new SweetInfo(R.drawable.banila, "바닐라 라떼", "4,600원"));

        myAdapter = new MyAdapter(sweetInfoArrayList);

        mRecyclerView.setAdapter(myAdapter);

        return fv;
    }


}
