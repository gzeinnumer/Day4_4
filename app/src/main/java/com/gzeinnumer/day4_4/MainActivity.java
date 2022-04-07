package com.gzeinnumer.day4_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //todo 5
    private ArrayList<User> list = new ArrayList<>();
    private RecyclerView rvData ;
    private RvAdapter adapter;
    private EditText edSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 6
        rvData = findViewById(R.id.rv);
        edSearch = findViewById(R.id.ed_search);

        list = User.generateDataItem();
        list.add(new User("Zein", "Zein aja"));
        adapter = new RvAdapter(getApplicationContext(), list);
        rvData.setAdapter(adapter);
        rvData.hasFixedSize();
        rvData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(editable.toString());
            }
        });
    }

    //todo 8
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        filterFunction(menu);

        return true;
    }

    private void filterFunction(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.showSearchTitle);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}