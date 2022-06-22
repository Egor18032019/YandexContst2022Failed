import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ProductReport {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String json = in.nextLine();
        String[] NAME_CONTAINS = in.nextLine().trim().split(" ");
        String name = NAME_CONTAINS[1];
        String[] PRICE_GREATER_THAN = in.nextLine().trim().split(" ");
        int priceGreater = Integer.parseInt(PRICE_GREATER_THAN[1]);
        String[] PRICE_LESS_THAN = in.nextLine().trim().split(" ");
        int priceLess = Integer.parseInt(PRICE_LESS_THAN[1]);
        String[] DATE_AFTER = in.nextLine().trim().split(" ");
        LocalDate dateAfter = convertStrToLocalDate(DATE_AFTER[1]);
        String[] DATE_BEFORE = in.nextLine().trim().split(" ");
        LocalDate dateBefore = convertStrToLocalDate(DATE_BEFORE[1]);

        List<Product> productsList = getProductListFromJson(json);


        List<Product> productsOut = productsList.stream()
                .filter(
                        i ->
                                i.getName().toLowerCase().contains(name.toLowerCase()) &&
                                        i.getPrice() >= priceGreater &&
                                        i.getPrice() <= priceLess &&
                                        i.getDate().isAfter(dateAfter) &&
                                        i.getDate().isBefore(dateBefore)).sorted(Comparator.comparingInt(Product::getId)).collect(Collectors.toList());

        JSONArray jsonArrayOut = new JSONArray();
        for (Product product : productsOut) {
            LinkedHashMap<String, Object> jsonObjectOut = new LinkedHashMap<String, Object>();
            jsonObjectOut.put("id", product.getId());
            jsonObjectOut.put("name", product.getName());
            jsonObjectOut.put("price", product.getPrice());
            jsonObjectOut.put("date", convertLocalDateToStr(product.getDate()));
            jsonArrayOut.add(jsonObjectOut);
        }
        System.out.println(jsonArrayOut.toString());
    }
/*
[{"id": 1, "name": "Asus notebook","price": 1564,"date": "23.09.2021"},
{"id": 2, "name": "Earpods", "price": 2200, "date": "10.01.2022"},
{"id": 3, "name": "Keyboard", "price": 2500, "date": "05.06.2020"},
{"id": 4, "name": "Dell notebook","price": 2300,"date": "23.09.2021"}]
NAME_CONTAINS notebook
PRICE_GREATER_THAN 2000
PRICE_LESS_THAN 2400
DATE_AFTER 12.09.2021
DATE_BEFORE 02.01.2022

 */


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
                product.id = (int) (long) jsonObject.get("id");
                product.name = (String) jsonObject.get("name");
                product.price = (long) jsonObject.get("price");
                product.date = convertStrToLocalDate((String) jsonObject.get("date"));
                productsList.add(product);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return productsList;
    }

    public static LocalDate convertStrToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static String convertLocalDateToStr(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    static class Product {
        public int getId() {
            return id;
        }

        private int id;

        public String getName() {
            return name;
        }

        private String name;

        public long getPrice() {
            return price;
        }

        private long price;

        public LocalDate getDate() {
            return date;
        }

        private LocalDate date;

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", date=" + date +
                    '}';
        }
    }
}
