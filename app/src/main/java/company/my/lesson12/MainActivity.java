package company.my.lesson12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Ссылка на главный контейнер для добавления Button и TextView
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.mainContainer);
    }

    // Функция для установления системного меню на верхнем правом углу Toolbar-a
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Указываем привязать файл main_menu.xml который расположен в папке res/menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Вызывается при нажатии на пункт меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Получаем значение атрибута нажатого пункта меню
        int id = item.getItemId();

        // Сравниваем атрибут id и выполняем необходимые действия в зависимости от выбранного пункта меню
        switch(id)
        {
            case R.id.addSomething:
                // Код для пункта 1
                Toast.makeText(this, "Hello from first menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.drive:
                // Код для пункта 2
                Button btn = new Button(this);
                btn.setText("My Button");
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "I am a button", Toast.LENGTH_SHORT).show();
                    }
                });
                ll.addView(btn);
                break;
            case R.id.favorite:
                // Код для пункта 3
                TextView text = new TextView(this);
                text.setText("Some text");
                ll.addView(text);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
