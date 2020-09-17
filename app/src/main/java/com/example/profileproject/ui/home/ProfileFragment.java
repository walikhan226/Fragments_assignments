package com.example.profileproject.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.profileproject.R;

import de.hdodenhof.circleimageview.CircleImageView;

public  class ProfileFragment extends Fragment {


 public ProfileFragment(){

    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }


    private HomeViewModel homeViewModel;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        final TextView text = (TextView) root.findViewById(R.id.namedisplay);
       final    TextView text1 = (TextView) root.findViewById(R.id.rollnodisplay);
        final   TextView text2 = (TextView) root.findViewById(R.id.descriptiondisplay);
    final CircleImageView image = root.findViewById(R.id.img1);

        Log.d("myTag", "myname");
        Bundle bundle;
        bundle = getArguments();
        if (bundle != null) {


            text.setText(bundle.getString("name"));
            text1.setText(bundle.getString("rollno"));
            text2.setText(bundle.getString("dsc"));
            Uri uriData = Uri.parse(bundle.getString("uri"));
            image.setImageURI(uriData);

        }else {

            Toast.makeText(getActivity(), "Null",
                    Toast.LENGTH_LONG).show();

        }






        return root;
    }
}