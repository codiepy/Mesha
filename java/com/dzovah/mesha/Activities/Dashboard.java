package com.dzovah.mesha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.dzovah.mesha.R;
import com.dzovah.mesha.Methods.Utils.Quotes;
import com.dzovah.mesha.Methods.Dialogs.CreateAccountDialog;
import com.dzovah.mesha.Database.MeshaDatabase;
import com.dzovah.mesha.Database.Entities.AlphaAccount;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.dzovah.mesha.Activities.Adapters.AlphaAccountAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import java.util.List;

public class Dashboard extends AppCompatActivity {
    private MeshaDatabase database;
    private AlphaAccountAdapter accountAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        // Setup toolbar and drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_account) {
                startActivity(new Intent(Dashboard.this, AccountsSection.class));
            } else if (id == R.id.nav_logout) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Dashboard.this, SignInActivity.class));
                finish();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        
        // Get current user but don't redirect if null
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        
        database = MeshaDatabase.Get_database(getApplicationContext());
        initializeViews();
        loadAccounts();
    }

    private void initializeViews() {
        TextView tvQuoteOfTheDay = findViewById(R.id.tvQuoteOfTheDay);
        LottieAnimationView bubblesAnimationView = findViewById(R.id.bubbles);
        LottieAnimationView piechartAnimationView = findViewById(R.id.piechart);
        FloatingActionButton fabAddAccount = findViewById(R.id.fabAddAccount);

        bubblesAnimationView.playAnimation();
        piechartAnimationView.playAnimation();

        Quotes quotes = new Quotes();
        tvQuoteOfTheDay.setText("Quote: " + quotes.presentQuote());

        RecyclerView rvAccounts = findViewById(R.id.alpha_accounts_recyclerview);
        rvAccounts.setLayoutManager(new LinearLayoutManager(this));
        accountAdapter = new AlphaAccountAdapter(this);
        accountAdapter.setOnAccountActionListener(new AlphaAccountAdapter.OnAccountActionListener() {
            @Override
            public void onAccountClicked(AlphaAccount account, int position) {
                Intent intent = new Intent(Dashboard.this, AlphaAccountDetailActivity.class);
                intent.putExtra("alpha_account_id", account.getAlphaAccountId());
                startActivity(intent);
            }

            @Override
            public void onAccountUpdated() {
                loadAccounts();
            }
        });
        rvAccounts.setAdapter(accountAdapter);

        fabAddAccount.setOnClickListener(v -> showCreateAccountDialog());
    }

    private void loadAccounts() {
        try {
            MeshaDatabase.databaseWriteExecutor.execute(() -> {
                try {
                    List<AlphaAccount> accounts = database.alphaAccountDao().getAllAlphaAccounts();
                    runOnUiThread(() -> {
                        try {
                            accountAdapter.setAccounts(accounts);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Error displaying accounts", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(() -> 
                        Toast.makeText(this, "Error loading accounts", Toast.LENGTH_SHORT).show()
                    );
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to access database", Toast.LENGTH_SHORT).show();
        }
    }

    private void showCreateAccountDialog() {
        CreateAccountDialog dialog = new CreateAccountDialog(this, database);
        dialog.setOnAccountCreatedListener(account -> {
            try {
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
                loadAccounts(); // Reload accounts after creation
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error updating account list", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show(); // Show the dialog
    }
}