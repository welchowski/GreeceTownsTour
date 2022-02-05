package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout cl;
    Button pricetotal;
    ListView listView;
    TextView totalprice;
    private TowAdapter adapterTowns;
    private List<Towns> towns = new ArrayList<Towns>();
    int dayprice[] = {500, 400, 450, 600, 800};
    int totalpricevalue;
    String[] countries = {"Афіни", "Делфі", "Олімпія", "Скирос", "Занкіф"};
    String[] descriptin = {"Афіни переповнюються грецькою культурою і вражаючими місцями, як Парфенон і храм Зевса. Також не забудьте відвідати район Плака. Цей маленький передмістя Афін розташований трохи нижче Акрополя і є прекрасним місцем. Прогуляйтеся по брукованих вулицях і відвідайте ремісничі магазини і ресторани.\n" +
            "\n" +
            "Афіни – це місто, яке кидає виклик часу і є ще одним з неймовірних місць для відвідування у Греції. Коли ви відвідуєте Афіни, ви будете зіпсовані на вибір, коли мова йде про справжню їжу. Переконайтеся в тому, щоб ознайомитися з цими кращими ресторанами в Афінах , і приготуйтеся спостерігати за тим, як ваша лінія талії зростає."
            , "Дельфійський оракул був вписаний в грецьку історію, і жриця Аполлона пролунав у віки. Храм Аполлона все ще стоїть і є одним з найяскравіших місць в Дельфах. Поряд з храмом Аполлона є також Афіна Прієна, театр і стародавній стадіон.\n" +
            "\n" +
            "Прогуляйтеся між руїнами і перенесіть себе назад до того часу, коли Дельфи повторили крики оракулу, а царі поклонилися перед храмом Аполлона. Delphi є звичайно одне з кращих місць відвідати у Греції.",
            "Олімпія, батьківщина Олімпійських ігор, є ще одним з місць для відвідування в Греції, яка вирубана в історію. Розташований в освяченої Долині богів, ще можна побачити стародавній стадіон і полігони олімпійців.\nПоряд з Олімпією, долина також має неймовірні стежки для піших і гірських велосипедів і знаходиться недалеко від чудової красивої долини річки Альфос. Все це об’єднало, робить Олімпію та Долину Богов одним з кращих місць для відвідування в Греції."
            , "Розташований в центрі Егейського моря Скірос відомий своїми прекрасними пляжами, нерівними береговими лініями і приморськими селами. Занурений у традиціях та все ще відносно незайманих, Skyros є відмінним вибором для ідилічного відпочинку.\n" +
            "\n" +
            "Там, де на півночі розташовані всі сільськогосподарські угіддя і сосновий ліс, на півдні характерні посушливі гори і скелясті берегові лінії. Скиросу вдалося довго літати під радаром і не приваблює маси туристів, як багато інших грецьких островів.",
            "Домівка для деяких з кращих нічних клубів грецьких островів, Закінф є одним з найкрасивіших місць у всьому Середземномор’ї. Бірюзова вода, білі піщані пляжі і величезні крейдяно-білі скелі, всі дарують Закінту свою красу.\n" +
                    "\n" +
                    "Острів також є домом для одного з найбільш сфотографованих місць у Греції, неймовірно красивої бухти Корабельної аварії. Інакше відомий як Navagio пляж, це тільки робить Закінф мусить відвідати призначення. Центр острова менш вивчений, ніж берегова лінія, з ялинами і оливковими гаями, що додають чарівності острова."};

    int[] img = {R.drawable.afiny, R.drawable.delphi, R.drawable.olympia, R.drawable.skyros, R.drawable.zankif};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        cl = findViewById(R.id.clmain);
        pricetotal = findViewById(R.id.button2);
        cl.setBackgroundResource(R.drawable.beechfor);
        setInitData();
        totalprice = findViewById(R.id.totalprice);
        listView = findViewById(R.id.countriesList);
        adapterTowns = new TowAdapter(this, R.layout.list_item, towns);
        listView.setAdapter(adapterTowns);

        pricetotal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                totalpricevalue = 0;
                for (int i = 0; i < towns.size(); i++) {
                    totalpricevalue = totalpricevalue + towns.get(i).getPricetotal();
                }
                totalprice.setText("Загальна вартість: " + totalpricevalue + " грн");
                adapterTowns.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            final Intent intent = new Intent(MainActivity.this, DetailCountry.class);

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("name", countries[position]);
                intent.putExtra("description", descriptin[position]);
                intent.putExtra("img", Integer.toString(img[position]));
                startActivity(intent);
            }
        });
    }

    public void setInitData() {
        towns.add(new Towns(countries[0], descriptin[0], img[0], dayprice[0]));
        towns.add(new Towns(countries[1], descriptin[1], img[1], dayprice[1]));
        towns.add(new Towns(countries[2], descriptin[2], img[2], dayprice[2]));
        towns.add(new Towns(countries[3], descriptin[3], img[3], dayprice[3]));
        towns.add(new Towns(countries[4], descriptin[4], img[4], dayprice[4]));
    }
}

