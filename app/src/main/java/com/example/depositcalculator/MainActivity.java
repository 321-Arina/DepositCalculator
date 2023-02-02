package com.example.depositcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float apartmentPrice = 14_000; // стоимость телескопа
    int account = 1_000; // счёт пользователя
    float wage = 2_500; // стипендия в месяц
    float percentBank = 5; // годовая процентная ставка

    // метод подсчёта вклада за первый месяц
    private float summaZaPervMonth () {
        return account + ((account * percentBank / 12) / 100);
    }

    // метод подсчёта времени необходимого для накопления нужной суммы
    public int countMonth(float total, float stip, float percentBankYear) {

        float percentBankMonth = percentBankYear / 12; // подсчёт ежемесячного процента банка по вкладу
        int count = 1; // счётчик месяцев вклада

        // алгоритм расчёта вклада
        while (total<apartmentPrice) {
            count++; // добавление нового месяца
            total = total + stip; // добавление к общей сумме ежемесячной стипендии
            total = (total + (total*percentBankMonth)/100); // вычисление общей суммы с учётом процента

        }

        return count;
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView countOut; // поле вывода количества месяцев вклада


    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        countOut = findViewById(R.id.countOut); // вывод информации количества месяцев вклада

        // запонение экрана
        // вывод количества месяцев вклада
        countOut.setText("На телескоп будем копить " + countMonth(summaZaPervMonth(), wage, percentBank) + " месяцев");

    }
}