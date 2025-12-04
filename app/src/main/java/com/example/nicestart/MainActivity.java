package com.example.nicestart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.webkit.WebView;

import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;
=======

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
>>>>>>> master

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        WebView mycontext = findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);

        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        String html = "<html>" +
                "<head><style>" +
                "html, body {margin: 0; padding: 0;height:100%;overflow:hidden}" +
                "img{width:100%;height:100%;object-fit:cover;}" +
                "</style></head>" +
                "<body>" +
                "<img src='https://thispersondoesnotexist.com' />" +
                "</body></html>";

        miVisorWeb.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
        swipeLayout = findViewById(R.id.my_swipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.goLogin) {
            showAlertDialogButtonClicked(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item copied"
                    , Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast = Toast.makeText(this, "Downloading Item",
                    Toast.LENGTH_LONG);
            toast.show();
        }
        return false;
    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("¿Quieres ir al login?");
        builder.setMessage("Selecciona si quieres cambiar a la pantalla de login.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
