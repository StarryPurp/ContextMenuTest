package bstar128.example.hansung.contextmenutest;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button but2;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1=(Button)findViewById(R.id.but1);
        but2=(Button)findViewById(R.id.but2);
        linear=(LinearLayout)findViewById(R.id.linear) ;
        pic=(ImageView)findViewById(R.id.pic1) ;
        registerForContextMenu(but1);
        registerForContextMenu(but2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        if(v.getId()==R.id.but1){
            menu.setHeaderTitle("배경색 변경");
           // menu.setHeaderIcon(R.drawable.sombra);
            menuInflater.inflate(R.menu.menu1,menu);
        }

        if(v.getId()==R.id.but2){
            menuInflater.inflate(R.menu.menu2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.menu1_item_blue:
                linear.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menu1_item_pink:
                linear.setBackgroundColor(Color.rgb(255,178,217));
                return true;//rgb색상표로 가능!
            case R.id.menu1_item_yellow:
                linear.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu2_pic_rotation:
                pic.setRotation(pic.getRotation()+90);
                return true;
            case R.id.menu2_pic_size:
                pic.setScaleX(1.5f);
                pic.setScaleY(1.5f);//1.5배씩 배수로 커짐
                //pic.setScaleX(pic.getScaleX()*1.5f);
                return true;
            case R.id.menu2_pic_change:
                pic.setImageResource(R.drawable.apeach);
                return true;
        }

        return false;
    }
}

