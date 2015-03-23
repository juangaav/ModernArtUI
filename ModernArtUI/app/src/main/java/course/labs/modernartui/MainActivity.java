package course.labs.modernartui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar);

        final FrameLayout red_fl       = (FrameLayout) findViewById(R.id.layout_red);
        final FrameLayout green_fl     = (FrameLayout) findViewById(R.id.layout_green);
        final FrameLayout purple_fl    = (FrameLayout) findViewById(R.id.layout_purple);
        final FrameLayout white_fl     = (FrameLayout) findViewById(R.id.layout_white);
        final FrameLayout lightblue_fl = (FrameLayout) findViewById(R.id.layout_lblue);

        int defaultredFlColor       = getBackgroundColor(red_fl);
        int defaultgreenFlColor     = getBackgroundColor(green_fl);
        int defaultpurpleFlColor    = getBackgroundColor(purple_fl);
        int defaultwhiteFlColor     = getBackgroundColor(white_fl);
        int defaultlightBlueFlColor = getBackgroundColor(lightblue_fl);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub

                red_fl.setBackgroundColor( getBackgroundColor(red_fl) + progress);
                green_fl.setBackgroundColor( getBackgroundColor(green_fl) + progress);
                purple_fl.setBackgroundColor( getBackgroundColor(purple_fl) + progress);
                white_fl.setBackgroundColor( getBackgroundColor(white_fl) + progress);
                lightblue_fl.setBackgroundColor( getBackgroundColor(lightblue_fl) + progress);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more_info) {
            DialogClass dialog = new DialogClass(this);
            dialog.showDialogFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    private int getBackgroundColor(View view){

        int color = Color.TRANSPARENT;
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();

        return color;

    }


}
