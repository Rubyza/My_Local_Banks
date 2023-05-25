package sg.edu.rp.c346.id22019799.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;

    String bankClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展銀行");
            tvOCBC.setText("華僑銀行公司");
            tvUOB.setText("大华银行有限公司");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // item id is is 0(2nd parameter) display position is 3rd parameter
        menu.add(0, 0, 0, "Website");

        // item id is is 1(2nd parameter)
        menu.add(0, 1, 1, "Contact Bank");

        if (v == tvDBS) {
            bankClicked = "dbs";
        } else if (v == tvOCBC) {
            bankClicked = "ocbc";
        } else if (v == tvUOB) {
            bankClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //dbs
        if (bankClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "Loading Website...", Toast.LENGTH_SHORT).show();
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com/"));
                startActivity(intentWeb);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 63272265));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }
        //ocbc
        else if (bankClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "Loading Website...", Toast.LENGTH_SHORT).show();
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/"));
                startActivity(intentWeb);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 63633333));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }
        //uob
        else if (bankClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "Loading Website...", Toast.LENGTH_SHORT).show();
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/"));
                startActivity(intentWeb);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 62532122));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation;
    }
}

