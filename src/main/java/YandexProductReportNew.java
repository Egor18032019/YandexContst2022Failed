import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class YandexProductReportNew {
    public static class Product{
        private int id;
        private String name;
        private int price;
        private LocalDate date;

        public Product(int id, String name, int price, LocalDate date) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "{"+
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", date=" + date +
                    "}";
        }
    }

    public static JSONParser parser = new JSONParser();
    public static void solution() throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        JSONArray arr = (JSONArray) parser.parse(br.readLine());
        List<Product> list = new ArrayList<>();
        for (Object o : arr) {
            JSONObject jsonObject = (JSONObject) o;
            Product prod = new Product(Integer.parseInt(jsonObject.get("id").toString()), (String) jsonObject.get("name"), Integer.parseInt(jsonObject.get("price").toString()), LocalDate.parse(jsonObject.get("date").toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            list.add(prod);
        }
        String c ;
        while ((c = br.readLine()) != null){
            String[] law = c.split(" ");
            if ("NAME_CONTAINS".equals(law[0])) {
                list = list.stream().filter(product -> product.getName().toLowerCase().contains(law[1].toLowerCase())).collect(Collectors.toList());
            } else if ("PRICE_GREATER_THAN".equals(law[0])) {
                list = list.stream().filter(product -> product.getPrice() >= Integer.parseInt(law[1])).collect(Collectors.toList());
            } else if ("PRICE_LESS_THAN".equals(law[0])) {
                list = list.stream().filter(product -> product.getPrice() <= Integer.parseInt(law[1])).collect(Collectors.toList());
            } else if ("DATE_BEFORE".equals(law[0])) {
                list = list.stream().filter(product -> product.getDate().isBefore(LocalDate.parse(law[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"))) || product.getDate().isEqual(LocalDate.parse(law[1], DateTimeFormatter.ofPattern("dd.MM.yyyy")))).collect(Collectors.toList());
            } else if ("DATE_AFTER".equals(law[0])) {
                list = list.stream().filter(product -> product.getDate().isAfter(LocalDate.parse(law[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"))) || product.getDate().isEqual(LocalDate.parse(law[1], DateTimeFormatter.ofPattern("dd.MM.yyyy")))).collect(Collectors.toList());
            }
        }
        list = list.stream().sorted(Comparator.comparingInt(Product::getId)).collect(Collectors.toList());
        JSONArray jsonArray = new JSONArray();
        for (Product product: list){
            JSONObject obj = new JSONObject();
            obj.put("name", product.getName());
            obj.put("id", product.getId());
            obj.put("price", product.getPrice());
            obj.put("date", product.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            jsonArray.add(obj);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        bw.write(jsonArray.toJSONString());
        br.close();
        bw.close();
    }
}
