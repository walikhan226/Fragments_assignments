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


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;

import com.karumi.dexter.listener.single.PermissionListener;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;


public class AddprofileFragment extends Fragment {


    CircleImageView image;
    Uri imageUri;
    private static final int GALLER_ACTION_PICK_CODE =100;
  public AddprofileFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void runTimepermission() {
        Dexter.withContext(getContext())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                galleryIntent();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

            }
        }).check();
    }

    private void galleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,GALLER_ACTION_PICK_CODE);
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



                try {

                    ProfileFragment homeFragment = new ProfileFragment();




                    Bundle bundle = new Bundle();
                    bundle.putString("name", ""+text.getText());
                    bundle.putString("rollno", ""+text1.getText());
                    bundle.putString("dsc", ""+text2.getText());
                    bundle.putString("uri",imageUri.toString());
                    homeFragment.setArguments(bundle);


                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, homeFragment)
                            .commit();


                }catch (Exception ex){
                    Toast.makeText(getActivity(), "Some fields are missing",
                            Toast.LENGTH_LONG).show();


                }



            }
        });



        image = root.findViewById(R.id.img);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runTimepermission();
            }
        });

        return root;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == GALLER_ACTION_PICK_CODE){
                imageUri = data.getData();
                image.setImageURI(imageUri);
            }
        }
    }



    }
