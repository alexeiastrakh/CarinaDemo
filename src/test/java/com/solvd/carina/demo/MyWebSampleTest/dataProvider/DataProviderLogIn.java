package com.solvd.carina.demo.MyWebSampleTest.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderLogIn {
    @DataProvider(name = "login scenarios")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "", "", "Заполните это поле.", "Заполните это поле." },
                { "qwerty@gmailcom", "", "", "Заполните это поле." },
                { "", "123q", "Заполните это поле.", "" },
                {"qwerty@", "123q", "Введите часть адреса после символа \"@\". " +
                        "Адрес \"incorrectEmail@\" неполный.", "" },
                { "qwertygmail.com", "Qwerty_01", "Адрес должен содержать знак \"@\". " +
                "В адресе \"qwertygmail.com\" знака \"@\" нет.", "" },
                { "qwerty@gmail.com", "123q", "",  "Введите данные в указанном формате." },
                { "@gmail.com", "Qwerty_01", "Введите часть адреса к знаку \"@\". " +
                "Электронный адрес \"@gmail.com\" неполный.", "" },
        };
    }
}


