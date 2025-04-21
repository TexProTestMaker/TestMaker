package com.example.testmakerdev;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class LectureActivity extends AppCompatActivity {
    private TextView lectureNameTextView;
    private PDFView pdfView;
    private Button nextPageButton;
    private int currentPage = 0;
    private int totalPages = 0;

    private static final String PDF_FILE_NAME = "test_lecture_MATLAB.pdf"; // имя вашего PDF в assets или во внутренней памяти

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        lectureNameTextView = findViewById(R.id.lectureName);
        pdfView = findViewById(R.id.pdfView);
        nextPageButton = findViewById(R.id.nextPageButton);

        lectureNameTextView.setText("Matlab");

        // Если PDF лежит в assets:
        pdfView.fromAsset(PDF_FILE_NAME)
                .defaultPage(currentPage)
                .enableSwipe(false) // отключаем свайпы, чтобы только кнопкой листать
                .onLoad(nbPages -> totalPages = nbPages)
                .onPageChange((page, pageCount) -> currentPage = page)
                .load();

        nextPageButton.setOnClickListener(v -> {
            if (currentPage + 1 < totalPages) {
                currentPage++;
                pdfView.jumpTo(currentPage, true);
            }
        });
    }
}




/*

package com.example.testmakerdev;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class LectureActivity extends AppCompatActivity {
    private TextView lectureNameTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        lectureNameTextView = findViewById(R.id.lectureName);
        lectureNameTextView.setText("Здесь будет название лекции...");
    }

}
*/