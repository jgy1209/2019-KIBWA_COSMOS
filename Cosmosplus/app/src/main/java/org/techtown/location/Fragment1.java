package org.techtown.location;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
public class Fragment1 extends Fragment implements View.OnClickListener {

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fv = inflater.inflate(R.layout.fragment1, container, false);
        // Inflate the layout for this fragment

        Button button1, button2, button3;
        button1 = (Button) fv.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) fv.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) fv.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        return fv;
    }


    @Override
    public void onClick(View view) {

        Fragment fg;
        switch (view.getId()) {
            case R.id.button1:
                fg = ChildFragment1.newInstance();
                setChildFragment(fg);
                break;
            case R.id.button2:
                fg = ChildFragment2.newInstance();
                setChildFragment(fg);
                break;
            case R.id.button3:
                fg = ChildFragment3.newInstance();
                setChildFragment(fg);
                break;
        }
    }

    private void setChildFragment(Fragment child) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if(!child.isAdded()) {
            childFt.replace(R.id.child_fragment_container, child);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }


}
