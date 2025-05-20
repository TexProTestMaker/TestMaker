package com.example.testmakerdev;

import java.io.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LectureActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        String lectureName = getIntent().getStringExtra("lecture_name");
        TextView textView = findViewById(R.id.lectureName);
        textView.setText(lectureName);
    }
}
/*
public class LectureActivity extends AppCompatActivity {

    private final String lectureName;
    private final String lecturePath;

    LectureActivity(String name, String path){
        this.lectureName = name;
        this.lecturePath = path;
    }
    public String getName() {
        return lectureName;
    }

    public String getPath() {
        return lecturePath;
    }

    private TextView lectureNameTextView;
    private PDFView pdfView;
    private TextView textView;
    private Button nextPageButton;
    private Button prevPageButton;
    private int currentPage = 0;
    private int totalPages = 0;

    private List<String> txtPages = new ArrayList<>();
    private static final int LINES_PER_PAGE = 30; // отрегулируй под размер экрана
    private static final String FILE_NAME = "MATLAB.pdf" ; // имя файла

    private boolean isPdf = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        lectureNameTextView = findViewById(R.id.lectureName);
        pdfView = findViewById(R.id.pdfView);
        textView = findViewById(R.id.textView);
        nextPageButton = findViewById(R.id.nextPageButton);
        prevPageButton = findViewById(R.id.prevPageButton);

        lectureNameTextView.setText(lectureName);
        Button backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LectureActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (FILE_NAME.endsWith(".pdf")) {
            isPdf = true;
            pdfView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);

            pdfView.fromAsset(FILE_NAME)
                    .defaultPage(currentPage)
                    .enableSwipe(false)
                    .onLoad(nbPages -> totalPages = nbPages)
                    .onPageChange((page, pageCount) -> currentPage = page)
                    .load();
        } else if (FILE_NAME.endsWith(".txt")) {
            isPdf = false;
            pdfView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);

            try {
                InputStream is = getAssets().open(FILE_NAME);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;
                int lineCount = 0;
                StringBuilder pageBuilder = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    pageBuilder.append(line).append('\n');
                    lineCount++;
                    if (lineCount >= LINES_PER_PAGE) {
                        txtPages.add(pageBuilder.toString());
                        pageBuilder.setLength(0);
                        lineCount = 0;
                    }
                }
                // Последняя страница
                if (pageBuilder.length() > 0) {
                    txtPages.add(pageBuilder.toString());
                }
                totalPages = txtPages.size();

                showTxtPage(currentPage);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // неподдерживаемый формат
        }

        prevPageButton.setOnClickListener(v -> {
            if (currentPage > 0) {
                currentPage--;
                if (isPdf) {
                    pdfView.jumpTo(currentPage, true);
                } else {
                    showTxtPage(currentPage);
                }
            }
        });

        nextPageButton.setOnClickListener(v -> {
            if (currentPage + 1 < totalPages) {
                currentPage++;
                if (isPdf) {
                    pdfView.jumpTo(currentPage, true);
                } else {
                    showTxtPage(currentPage);
                }
            }
        });
    }

    private void showTxtPage(int page) {
        if (page >= 0 && page < txtPages.size()) {
            textView.setText(txtPages.get(page));
        }
    }
}
*/