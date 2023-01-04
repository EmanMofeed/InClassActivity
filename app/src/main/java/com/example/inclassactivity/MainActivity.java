package com.example.inclassactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText bookTitle , authorName, pages;
    private Switch switch1;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static final String DATA = "DATA";

    private ArrayList<Book> books = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        setupSharedPrefs();
    }


    public void setUpViews(){
        bookTitle =findViewById(R.id.edtBookTitle);
        authorName = findViewById(R.id.edtAuthorName);
        pages =findViewById(R.id.edtPages);
        switch1 = findViewById(R.id.switch1);

    }



    public void btnAddOnClick(View view) {
        String title = bookTitle.getText().toString();
        String author = authorName.getText().toString();
        int page =Integer.parseInt(pages.getText().toString());
        boolean isSelected = switch1.isChecked();
        books.add(new Book(title,author,page,isSelected));

    }
    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();
    }

    public void saveAllOnClick(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        Gson gson = new Gson();
        String bookString = gson.toJson(books);
        editor.putString(DATA,bookString);
        editor.commit();
        Toast.makeText(this, "Data Saved\n"+bookString, Toast.LENGTH_SHORT).show();

    }

}
