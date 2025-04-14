package ru.netology.domain;


import lombok.Value;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    private static final Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    public static String generateCity(Faker faker) {
        String city = faker.address().city();
        return city;
    }

    public static String generateName(Faker faker) {
        String name = (faker.name().firstName() + " " + faker.name().lastName());
        return name;
    }

    public static String generatePhone(Faker faker) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {

        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker localFaker = new Faker(new Locale(locale));
            return new UserInfo(
                    generateCity(localFaker),
                    generateName(localFaker),
                    generatePhone(localFaker));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
