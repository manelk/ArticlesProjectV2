package com.example.articlesproject.ui.search;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SearchView;

import com.example.articlesproject.API.Model.ArticaleModel;
import com.example.articlesproject.API.Model.CategoryModel;
import com.example.articlesproject.API.services.IArticalesMethods;
import com.example.articlesproject.API.services.ICategoryModel;
import com.example.articlesproject.API.services.RetrofitClient;
import com.example.articlesproject.R;
import com.example.articlesproject.model.Article;
import com.example.articlesproject.ui.home.CategoryAdapter;
import com.example.articlesproject.ui.home.PopularAdapter;
import com.example.articlesproject.ui.home.RecentAdapter;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;
    private RecyclerView categoryRecycler, recommendedRecycler;
    private static final String TAG = "Main out ";
    private List<String> categories = new ArrayList<>();
    private List<Article> data = new ArrayList<>();

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.search_fragment, container, false);

       // SearchView searchView = root.findViewById(R.id.searchView_search);

        // Categories
        categoryRecycler = root.findViewById(R.id.rv_search_category);
        getCategories();

        //Recommended
        recommendedRecycler = root.findViewById(R.id.rv_search_recommended);
        getArticles();

        return  root;
    }

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
                RecommendedAdapter recommendedAdapter = new RecommendedAdapter(data);

                recommendedRecycler.setHasFixedSize(true);
                recommendedRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                recommendedRecycler.setAdapter(recommendedAdapter);
            }

            @Override
            public void onFailure(Call<ArticaleModel> call, Throwable t) {
                Log.e(TAG , "err " + t.getMessage()  );
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        // TODO: Use the ViewModel
    }

}