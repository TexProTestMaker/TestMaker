package com.example.testmakerdev;

import java.io.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import java.io.File;

public class LectureActivity extends AppCompatActivity {
    private TextView lectureNameTextView;
    private PDFView pdfView;
    private TextView textView;
    private Button nextPageButton;
    private Button prevPageButton;
    private int currentPage = 0;
    private int totalPages = 0;

    private static final String FILE_NAME = "test.txt"; // имя вашего PDF в assets или во внутренней памяти

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        lectureNameTextView = findViewById(R.id.lectureName);
        pdfView = findViewById(R.id.pdfView);
        textView=findViewById(R.id.textView);
        nextPageButton = findViewById(R.id.nextPageButton);
        prevPageButton = findViewById(R.id.prevPageButton);

        lectureNameTextView.setText("Matlab");
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
                pdfView.setVisibility(View.VISIBLE); // показать pdfView
                textView.setVisibility(View.GONE);   // спрятать textView

                pdfView.fromAsset(FILE_NAME)
                        .defaultPage(currentPage)
                        .enableSwipe(false)
                        .onLoad(nbPages -> totalPages = nbPages)
                        .onPageChange((page, pageCount) -> currentPage = page)
                        .load();
            } else if (FILE_NAME.endsWith(".txt")) {
                pdfView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);

                try {
                    InputStream is = getAssets().open(FILE_NAME);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line).append('\n');
                    }
                    textView.setText(builder.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Неподдерживаемый формат
            }

        prevPageButton.setOnClickListener(v -> {
            if (currentPage > 0) {
                currentPage--;
                pdfView.jumpTo(currentPage, true);
            }

        });
        nextPageButton.setOnClickListener(v -> {
            if (currentPage + 1 < totalPages) {
                currentPage++;
                pdfView.jumpTo(currentPage, true);
            }
        });
    }
}
