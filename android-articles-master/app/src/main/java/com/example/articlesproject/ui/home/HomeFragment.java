package com.example.articlesproject.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articlesproject.API.Model.ArticaleModel;
import com.example.articlesproject.API.Model.CategoryModel;
import com.example.articlesproject.API.services.IArticalesMethods;
import com.example.articlesproject.API.services.ICategoryModel;
import com.example.articlesproject.API.services.RetrofitClient;
import com.example.articlesproject.model.Article;
import com.example.articlesproject.R;
import com.example.articlesproject.databinding.HomeFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private HomeFragmentBinding binding;
    private RecyclerView categoryRecycler, popular_recycler_view, recent_recycler_view;
    private static final String TAG = "Main out ";
    private List<String> categories = new ArrayList<>();
    private List<Article> data = new ArrayList<>();

    /** Get All Categories **/
    protected void getCategories(){
        ICategoryModel methods = RetrofitClient.getRetrofitInstance().create(ICategoryModel.class);
        Call<CategoryModel> call = methods.getAllCategories();

        call.enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                Log.e(TAG , "status " + response.message() );
                ArrayList<CategoryModel.Category> listCategorie = response.body().getCategoriesList();
                for(CategoryModel.Category cat : listCategorie) {
                    categories.add(cat.getName());
                }
                Log.e(TAG , "status " + categories);
                CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
                categoryRecycler.setHasFixedSize(true);
                categoryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                categoryRecycler.setAdapter(categoryAdapter);
            }
            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                Log.e(TAG , "err " + t.getMessage()  );
            }
        });
    }
    /** Get All Articles **/
    protected void getArticles(){
        IArticalesMethods methods = RetrofitClient.getRetrofitInstance().create(IArticalesMethods.class);
        Call<ArticaleModel> call = methods.getAllArticales();

        call.enqueue(new Callback<ArticaleModel>() {
            @Override
            public void onResponse(Call<ArticaleModel> call, Response<ArticaleModel> response) {
                Log.e(TAG , "status " + response.code() );
                ArrayList<ArticaleModel.Article> listArticales = response.body().getArticalesList();
                for(ArticaleModel.Article art : listArticales) {
                    Log.e(TAG , "status " +  art.getUser().getFirstName());
                    data.add(new Article(art.getTitle(), art.getUser().getFirstName()+" "+art.getUser().getLastName(), "14h", art.getCategorie().getName(), art.getNb_starts().toString(), R.drawable.rachella_cover_image, R.drawable.rachella_angel_profile,  art.getDescription(), R.drawable.rachella_body_image));
                }
                PopularAdapter popularAdapter = new PopularAdapter(data);
                popular_recycler_view.setHasFixedSize(true);
                popular_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                popular_recycler_view.setAdapter(popularAdapter);

                RecentAdapter recentAdapter = new RecentAdapter(data);
                recent_recycler_view.setHasFixedSize(true);
                recent_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
                recent_recycler_view.setAdapter(recentAdapter);
            }

            @Override
            public void onFailure(Call<ArticaleModel> call, Throwable t) {
                Log.e(TAG , "err " + t.getMessage()  );
            }
        });
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // Categories
        getCategories();
        categoryRecycler = root.findViewById(R.id.rv_category);

        // Popular
        popular_recycler_view = root.findViewById(R.id.rv_popular);
        getArticles();

        // Recent articles
        recent_recycler_view = root.findViewById(R.id.rv_recent);
        getArticles();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}