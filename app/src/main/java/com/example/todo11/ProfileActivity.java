package com.example.todo11;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ProfileActivity extends AppCompatActivity {

    private Button btnDiaSignOut;
    private Button btnEditInfo;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        // Initialize buttons
        btnDiaSignOut = findViewById(R.id.SignOut);
        btnEditInfo = findViewById(R.id.EditInfo);
        back = findViewById(R.id.back);

        // Set up sign out button click listener
        btnDiaSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignOutDialog(); // Show the dialog
            }
        });

        // Set up edit info button click listener
        btnEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditProfileDialog(); // Show the edit profile dialog
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
            }
        });

    }

    // Method to show the sign out dialog
    private void showSignOutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialoglogout, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnDialogCancel = dialogView.findViewById(R.id.btnDialogCancel);
        Button btnDiaSignOut = dialogView.findViewById(R.id.btnDiaSignOut);

        // Set click listener for Cancel button
        btnDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        // Set click listener for Sign Out button
        btnDiaSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Dismiss the dialog
                signOut(); // Call the sign out method
            }
        });
    }

    // Method to show the edit profile dialog
    private void showEditProfileDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.editprofiledialog, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        EditText editTextUsername = dialogView.findViewById(R.id.editTextUsername);
        EditText editTextNewEmail = dialogView.findViewById(R.id.editTextNewEmail);
        Button buttonSave = dialogView.findViewById(R.id.buttonSave);

        // Set click listener for Save button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the save action here
                String newUsername = editTextUsername.getText().toString();
                String newEmail = editTextNewEmail.getText().toString();

                // Update the user info accordingly
                // For example, you might want to save this data in shared preferences or database

                // Show toast message
                Toast.makeText(ProfileActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

                dialog.dismiss(); // Dismiss the dialog
            }
        });
    }

    // Method to handle sign out
    private void signOut() {
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
