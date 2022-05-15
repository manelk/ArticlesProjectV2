package com.example.articlesproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.articlesproject.DetailsActivity;
import com.example.articlesproject.R;
import com.example.articlesproject.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private HomeFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = HomeFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final View firstArticle = binding.getRoot().findViewById(R.id.first_article);

        firstArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(getContext(), DetailsActivity.class);
                startActivity(detailIntent);
            }
        });

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}