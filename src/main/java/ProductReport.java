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
        String JSON = in.nextLine();
//                .split(" ");
        String[] PRICE_LESS_THAN = in.nextLine().trim().split(" ");
        int priceLess = Integer.parseInt(PRICE_LESS_THAN[1]);
        String[] DATE_AFTER = in.nextLine().trim().split(" ");
        LocalDate dateAfter = convertStrToLocalDate(DATE_AFTER[1]);
        String NAME_CONTAINS = in.nextLine().trim();
        String name = NAME_CONTAINS.replaceAll("NAME_CONTAINS", "").trim();
        String[] PRICE_GREATER_THAN = in.nextLine().trim().split(" ");
        int priceGreater = Integer.parseInt(PRICE_GREATER_THAN[1]);
        String[] DATE_BEFORE = in.nextLine().trim().split(" ");
        LocalDate dateBefore = convertStrToLocalDate(DATE_BEFORE[1]);

        in.close();

        List<Product> productsList = getProductListFromJson(JSON);
        List<Product> productsOut = productsList.stream()
                .filter(
                        i ->
                                i.getName().toLowerCase().contains(
                                        name.toLowerCase()
                                ) &&
                                        i.isAfterOrEqual(dateAfter) &&
                                        i.isBeforeOrEqual(dateBefore) &&
                                        i.getPrice() >= priceGreater &&
                                        i.getPrice() <= priceLess
//                                        i.getDate().isAfter(dateAfter) &&
//                                        i.getDate().isBefore(dateBefore)
                )
                .sorted(Comparator.comparingInt(Product::getId))
                .collect(Collectors.toList());

        JSONArray  jsonArrayOut = new JSONArray();
        for (Product product : productsOut) {
            LinkedHashMap<String, Object> jsonObjectOut = new LinkedHashMap<String, Object>();
            jsonObjectOut.put("id", product.getId());
            jsonObjectOut.put("name", product.getName());
            jsonObjectOut.put("price", product.getPrice());
            jsonObjectOut.put("date", convertLocalDateToStr(product.getDate()));
            jsonArrayOut.add(jsonObjectOut);
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

        public boolean isAfterOrEqual(LocalDate after){
            if(date.isAfter(after)){
                return true;
            }else {
                return date.isEqual(after);
            }
        }
        public boolean isBeforeOrEqual(LocalDate before){
            if(date.isBefore(before)){
                return true;
            }else {
                return date.isEqual(before);
            }
        }


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
