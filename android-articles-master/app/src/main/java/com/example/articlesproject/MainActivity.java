package com.example.articlesproject;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;
import com.example.articlesproject.API.Model.ArticaleModel;
import com.example.articlesproject.API.Model.AuthModel;
import com.example.articlesproject.API.Model.CategoryModel;
import com.example.articlesproject.API.Model.DataArticaleCategorie;
import com.example.articlesproject.API.Model.DataAuthModel;

import com.example.articlesproject.API.services.IArticalesMethods;
import com.example.articlesproject.API.services.IAuthMethods;
import com.example.articlesproject.API.services.ICategoryModel;
import com.example.articlesproject.API.services.RetrofitClient;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.articlesproject.databinding.ActivityMainBinding;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main out ";
    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notification_channel", "notification_channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribed Successfully";
                        if (!task.isSuccessful()) {
                            msg = "Subscription failed";
                        }
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }

                });
        //************************* Test login *******************************

       /* IAuthMethods methods = RetrofitClient.getRetrofitInstance().create(IAuthMethods.class);
        Call<AuthModel> call = methods.login(new DataAuthModel("israa@gmail.com","123"));

        call.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                Log.e(TAG , "status " + response.code()  );

                AuthModel.SecretInfo user = response.body().getSecretInfo();
                Log.e(TAG , "user  " + user.getEmail());
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {
                Log.e(TAG , "err " + t.getMessage()  );
            }
        });*/



        //  ***********************    Test get Articles by category  **********************************
    /*    IArticalesMethods methods = RetrofitClient.getRetrofitInstance().create(IArticalesMethods.class);
        Call<ArticaleModel> call = methods.getArticalesByCategories(new DataArticaleCategorie("627d590233ba744c679b3748"));
        call.enqueue(new Callback<ArticaleModel>() {
            @Override
            public void onResponse(Call<ArticaleModel> call, Response<ArticaleModel> response) {
                Log.e(TAG, "message");
                Log.e(TAG , "status11" + response.code()  );
                ArrayList<ArticaleModel.Article> listArticales = response.body().getArticalesList();
                for(ArticaleModel.Article art : listArticales) {
                    Log.e(TAG , "status12" + art.getTitle()  );
                }
            }

            @Override
            public void onFailure(Call<ArticaleModel> call, Throwable t) {
                Log.e(TAG , "err " + t.getMessage()  );
            }
        });*/

//Hide Action bar
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DrawerLayout drawerLayout = binding.drawerLayout;
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search,   R.id.navigation_bookmarks, R.id.navigation_profile)
                .setOpenableLayout(drawerLayout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }



}