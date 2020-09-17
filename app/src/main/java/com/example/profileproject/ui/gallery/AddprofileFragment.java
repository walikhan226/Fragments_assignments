package com.example.profileproject.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.profileproject.R;
import com.example.profileproject.ui.home.ProfileFragment;

public class AddprofileFragment extends Fragment {



  public AddprofileFragment(){

    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addprofile, container, false);

final EditText text = (EditText) root.findViewById(R.id.nametxt);
    final    EditText text1 = (EditText) root.findViewById(R.id.rollnotxt);
     final   EditText text2 = (EditText) root.findViewById(R.id.descriptiontxt);

        Button btn = (Button) root.findViewById(R.id.addprofile);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ProfileFragment homeFragment = new ProfileFragment();


                Bundle bundle = new Bundle();
                bundle.putString("name", ""+text.getText());
                bundle.putString("rollno", ""+text1.getText());
                bundle.putString("dsc", ""+text2.getText());
                homeFragment.setArguments(bundle);


                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, homeFragment)
                        .commit();



            }
        });

        return root;
    }

    }
