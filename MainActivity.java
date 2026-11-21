package com.gulati.itcpractice;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout root;
    int score = 0;

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        showHome();
    }

    TextView text(String s, int size) {
        TextView t = new TextView(this);
        t.setText(s); t.setTextSize(size); t.setTextColor(0xFF172B4D);
        t.setPadding(8, 12, 8, 12);
        return t;
    }

    void base(String title) {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 28, 24, 24);
        root.setBackgroundColor(0xFFF4F7FB);
        setContentView(root);
        TextView heading = text(title, 25);
        heading.setTypeface(null, Typeface.BOLD);
        root.addView(heading);
    }

    void addButton(String label, Runnable action) {
        Button b = new Button(this);
        b.setText(label);
        root.addView(b);
        b.setOnClickListener(v -> action.run());
    }

    void showHome() {
        base("Gulati ITC Practice");
        root.addView(text("Your personal taxi exam practice app", 16));
        addButton("Horizontal Streets", () -> showSection("Horizontal Streets"));
        addButton("Vertical Streets", () -> showSection("Vertical Streets"));
        addButton("Arabic Words", () -> showSection("Arabic Words"));
        addButton("Mock Test", () -> showSection("Mock Test"));
        root.addView(text("Question bank will be added only after checking the Aman Taxi PDF. No made-up questions.", 14));
    }

    void showSection(String section) {
        base(section);
        root.addView(text("Practice section is ready. Verified questions from your uploaded book still need to be transcribed and checked before they appear here.", 17));
        addButton("Back to Home", this::showHome);
    }
}
