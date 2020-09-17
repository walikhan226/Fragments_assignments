package com.example.profileproject.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.profileproject.R;
import com.example.profileproject.ui.home.HomeFragment;

public class GalleryFragment extends Fragment {



  public   GalleryFragment(){

    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

final EditText text = (EditText) root.findViewById(R.id.nametxt);
    final    EditText text1 = (EditText) root.findViewById(R.id.rollnotxt);
     final   EditText text2 = (EditText) root.findViewById(R.id.descriptiontxt);

        Button btn = (Button) root.findViewById(R.id.addprofile);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name",text.getText().toString());
                bundle.putString("rollno",text1.getText().toString());
                bundle.putString("description",text2.getText().toString());

                String nam = bundle.getString("name");
                Toast.makeText(getContext(), nam, Toast.LENGTH_SHORT).show();
                homeFragment.setArguments(bundle);
//FragmentManager manager = FragmentManager();


            }
        });

        return root;
    }

    }
