package utils;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println(getFirstName());
        System.out.println(getLastName());
        System.out.println(getEmail());
        System.out.println(getGender());
        System.out.println(getNumber());
        System.out.println(getSubjects());
        System.out.println(getHobbies());
        System.out.println(getAddress());
        System.out.println(getState()+" "+getCity(getState()));
    }

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getEmail(){
        return faker.internet().emailAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getNumber(){
        return faker.number().digits(10);
    }

    public static String getSubjects() {
        String[] subjects = {
                "Maths","Accounting","Arts","Social Studies","Physics","Chemistry",
                "Computer Science","Commerce","Economics","Civics","English","Hindi","Biology","History"};
        List<String> list = new ArrayList<>(Arrays.asList(subjects));
        Collections.shuffle(list);
        int count = new Random().nextInt(subjects.length + 1);
        return String.join(", ", list.subList(0, count));
    }

    public static String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        List<String> list = new ArrayList<>(Arrays.asList(hobbies));
        Collections.shuffle(list);
        int count = new Random().nextInt(hobbies.length + 1);
        return String.join(", ", list.subList(0, count));
    }

    public static String getPicture(){
        String[] pictures = {
                "cyberpunk_1.jpeg",
                "cyberpunk_2.jpeg",
                "cyberpunk_3.jpeg",
                "cyberpunk_4.jpeg"};
        return getRandomItemFromArray(pictures);
    }

    public static String getAddress(){
        return faker.address().streetAddress();
    }

    public static String getState(){
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(state);
    }

    public static String getCity(String state) {
        return switch (state) {
            case "NCR" -> getRandomItemFromArray(new String[]{"Delhi", "Gurgaon", "Noida"});
            case "Uttar Pradesh" -> getRandomItemFromArray(new String[]{"Agra", "Lucknow", "Merrut"});
            case "Haryana" -> getRandomItemFromArray(new String[]{"Karnal", "Panipat"});
            case "Rajasthan" -> getRandomItemFromArray(new String[]{"Jaipur", "Jaiselmer"});
            default -> throw new IllegalArgumentException("Unknown state: " + state);
        };

    }

}