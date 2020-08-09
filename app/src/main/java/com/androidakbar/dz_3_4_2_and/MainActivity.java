package com.androidakbar.dz_3_4_2_and;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Toolbar appToolbar;
    private Spinner spnLanguage;
    private Spinner spnTheme;
    private String selectedLanguage;
    private int selectMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MarginUtils.onActivityCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        ((Button)findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale(selectedLanguage);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                MarginUtils.changeToTheme(MainActivity.this, selectMargin);
            }
        });
    }

    private void initView() {
        appToolbar = findViewById(R.id.app_toolbar);
        appToolbar.setTitle(R.string.name_dz);
        appToolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryText));

        spnLanguage = findViewById(R.id.spn_language);
        initSpnLanguage();

        spnTheme = findViewById(R.id.spn_margin);
        initSpnMargin();

    }

    private void initSpnMargin() {
        ArrayAdapter<CharSequence> adpTheme = ArrayAdapter.createFromResource(MainActivity.this, R.array.sa_margin, R.layout.support_simple_spinner_dropdown_item);
        spnTheme.setAdapter(adpTheme);

        spnTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] margin = getResources().getStringArray(R.array.sa_margin);
                if (margin[i].equals(getResources().getString(R.string.str_name_margin_small))) {
                    selectMargin = R.style.MarginSmall;
                } else if (margin[i].equals(getResources().getString(R.string.str_name_theme_middle))) {
                    selectMargin = R.style.MarginMiddle;
                } else {
                    selectMargin = R.style.MarginLarge;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initSpnLanguage() {
        ArrayAdapter<CharSequence> adpLanguage = ArrayAdapter.createFromResource(MainActivity.this, R.array.sa_language, R.layout.support_simple_spinner_dropdown_item);
        spnLanguage.setAdapter(adpLanguage);

        spnLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] languages = getResources().getStringArray(R.array.sa_language);
                if (languages[i].equals(getResources().getString(R.string.str_name_local_ru))) {
                    selectedLanguage = "ru";
                } else {
                    selectedLanguage = "en";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}