package com.example.articlesproject.ui.profile;

import static android.content.Context.MODE_PRIVATE;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.articlesproject.LoginActivity;
import com.example.articlesproject.MainActivity;
import com.example.articlesproject.R;
import com.example.articlesproject.ui.user.UserActivity;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.profile_fragment, container, false);
        LinearLayoutCompat  my_account_row = (LinearLayoutCompat) root.findViewById(R.id.my_account_row);
        LinearLayoutCompat  logout = (LinearLayoutCompat) root.findViewById(R.id.logout_row);

//      logout

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = root.getContext().getSharedPreferences("MySharedPref",MODE_PRIVATE);

                // Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                // Storing the key and its value as the data fetched from edittext
                myEdit.clear();

                myEdit.commit();

//                Got to Login
                Intent loginIntent = new Intent(root.getContext(), LoginActivity.class);
                startActivity(loginIntent);

                getActivity().finish();

            }
        });



// my account
      my_account_row.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent intent = new Intent(getContext(), UserActivity.class);

              intent.putExtra("name", "Christina");
              startActivity(intent);

          }
      });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}