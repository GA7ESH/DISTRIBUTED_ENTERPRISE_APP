/* Created by Ganesh Sargam*/
package edu.mga.henrybookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewInventory(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, GetInventoryReportActivity.class);
        startActivity(intent);
    }

    public void addInventory(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, AddInventoryActivity.class);
        startActivity(intent);
    }

    public void addBook(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivity(intent);
    }

    public void addBranch(View view) {
        // Do something in response to button
       Intent intent = new Intent(this, AddBranchActivity.class);
       startActivity(intent);
    }
}