package com.example.testmakerdev;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LectureListFragment extends AppCompatActivity {

    private List<Lecture> lecturesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_lecture_list);

        //@SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ListView listView =  (ListView) findViewById(R.id.listview_lectures);
        loadLectures();

        List<String> lectureNames = new ArrayList<>();
        for (Lecture l : lecturesList) {
            lectureNames.add(l.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lectureNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Lecture selected = lecturesList.get(position);
                Intent intent = new Intent(LectureListFragment.this, LectureActivity.class);
                intent.putExtra("lecture_name", selected.getName());
                intent.putExtra("lecture_path", selected.getPath());
                startActivity(intent);
            }
        });
    }

    private void loadLectures() {
        try {
            InputStream is = getAssets().open("Lecture list.csv");
            System.out.println("1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            // Пропустить заголовок
            reader.readLine();
            System.out.println("2");
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 3) {
                    // tokens[0] - subject (игнорируем)
                    lecturesList.add(new Lecture(tokens[1], tokens[2]));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}