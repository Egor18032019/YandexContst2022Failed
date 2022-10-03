import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class YandexProductReport {

    private static BufferedReader bufferedReader = null;
    static Map<Integer, JSONObject> xranilishe = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        xranilishe = new HashMap<Integer, JSONObject>();
        String JSON = bufferedReader.readLine();
        int priceLess = 0;
        String name = null;
        int priceGreater = 0;
        DateForReq dateAfter = new DateForReq();
        DateForReq dateBefore = new DateForReq();
        for (int i = 1; i < 5; i++) {
            String[] stroke = bufferedReader.readLine().split(" ");
            if (stroke[0].equals("PRICE_LESS_THAN")) {
                priceLess = Integer.parseInt(stroke[1]);
            }
            if (stroke[0].equals("PRICE_GREATER_THAN")) {
                priceGreater = Integer.parseInt(stroke[1]);
            }
            if (stroke[0].equals("NAME_CONTAINS")) {
                name = stroke[1];
            }
            if (stroke[0].equals("DATE_AFTER")) {
                String[] dateForAfter = stroke[1].split("\\.");
                dateAfter = new DateForReq(dateForAfter[0], dateForAfter[1], dateForAfter[2]);
            }
            if (stroke[0].equals("DATE_BEFORE")) {
                String[] dateForBefore = stroke[1].split("\\.");
                dateAfter = new DateForReq(dateForBefore[0], dateForBefore[1], dateForBefore[2]);
            }


        }


        bufferedReader.close();


        List<Product> productsList = getProductListFromJson(JSON);
        String finalName = name;
        int finalPriceGreater = priceGreater;
        int finalPriceLess = priceLess;
        DateForReq finalDateAfter = dateAfter;
        List<Product> productsOut = productsList.stream()
                .filter(
                        i ->
                                i.getName().toLowerCase().contains(
                                        finalName.toLowerCase()
                                ) &&
                                        i.isAfterOrEqual(finalDateAfter) &&
                                        i.isBeforeOrEqual(dateBefore) &&
                                        i.getPrice() >= finalPriceGreater &&
                                        i.getPrice() <= finalPriceLess

                )
                .sorted(Comparator.comparingInt(Product::getId))
                .collect(Collectors.toList());
        JSONArray jsonArrayOut = new JSONArray();

        for (Product product : productsOut) {


            jsonArrayOut.add(xranilishe.get(product.id));
        }
        System.out.println(jsonArrayOut.toString()); // 43-51

    }

    public static List<Product> getProductListFromJson(String json) {
        List<Product> productsList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object obj = parser.parse(json);
            JSONArray jsonarray = (JSONArray) obj;
            for (int i = 0; i < jsonarray.size(); i++) {
                jsonObject = (JSONObject) jsonarray.get(i);
                Product product = new Product();
                int id = (int) (long) jsonObject.get("id");
                product.id = id;
                product.name = (String) jsonObject.get("name");
                product.price = (long) jsonObject.get("price");
                String date = (String) jsonObject.get("date");
                String[] dateArr = date.split("\\.");
                product.day = Integer.parseInt(dateArr[0]);
                product.month = Integer.parseInt(dateArr[1]);
                product.year = Integer.parseInt(dateArr[2]);

                productsList.add(product);
                xranilishe.put(id, jsonObject);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return productsList;
    }


    static class Product {
        private int id;
        private String name;
        private long price;
        private int year;
        private int month;
        private int day;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public long getPrice() {
            return price;
        }

        public boolean isBeforeOrEqual(DateForReq before) {
            // «Товар поступил в продажу не позднее чем» (критерий ‘DATE_BEFORE’);
            if (before.year <= year) return true;
            if (before.month <= month) return true;
            if (before.day <= day) return true;


            return false;
        }

        public boolean isAfterOrEqual(DateForReq after) {
            // «Товар поступил в продажу не ранее чем» (критерий ‘DATE_AFTER’);
            if (after.year >= year) return true;
            if (after.month >= month) return true;
            if (after.day >= day) return true;

            return false;
        }

        public String getDate() {

            return day + "." + month + "." + year;
        }

    }

    static class DateForReq {
        private final int day;
        private final int month;
        private final int year;

        public DateForReq() {
            this.day = 0;
            this.month = 0;
            this.year = 0;
        }

        public DateForReq(String day, String month, String year) {
            this.day = Integer.parseInt(day);
            this.month = Integer.parseInt(month);
            this.year = Integer.parseInt(year);
        }
    }
}
/*
[{"id": 1, "name": "Asus notebook","price": 1564,"date": "23.09.2021"},{"price": 2500, "id": 3, "date": "05.06.2020", "name": "Keyboardpods" }, {"date": "23.09.2021", "name": "Airpods","id": 5, "price": 2300}, {"name": "EaRPoDs", "id": 2, "date": "01.01.2022", "price": 2200}, { "id": 4, "date": "23.09.2021", "name": "Dell notebook",  "price": 2300}]
PRICE_LESS_THAN 2200
DATE_AFTER 23.09.2021
NAME_CONTAINS pods
PRICE_GREATER_THAN 2200
DATE_BEFORE 02.01.2022

 */