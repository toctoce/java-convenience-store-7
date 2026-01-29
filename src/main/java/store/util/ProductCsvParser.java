package store.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import store.common.StoreException;
import store.domain.product.Product;
import store.domain.promotion.Promotion;
import store.domain.promotion.Promotions;

public class ProductCsvParser {

    private static final String CSV_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String PRODUCT_REGEX = "[^,]+,[0-9]+,[0-9]+,[^,]+";

//    name,price,quantity,promotion
//    콜라,1000,10,탄산2+1

    public static final String FILENAME = "products.md";

    public static Promotions parseCSV(Promotions promotions) {
        List<List<String>> parsedLines = readCSV();
        List<Product> products = new ArrayList<>();
        for (List<String> parsedLine : parsedLines) {
            String name = parsedLine.get(0);
            int price = Integer.parseInt(parsedLine.get(1));
            int quantity = Integer.parseInt(parsedLine.get(2));
            Promotion promotion = promotions.findByName(parsedLine.get(3));
        }
        return null;
    }

    private static List<List<String>> readCSV() {
        try {
            URL resource = ProductCsvParser.class.getClassLoader().getResource(FILENAME);
            if (resource == null) {
                throw new StoreException("[ERROR] 올바르지 않은 CSV 형식입니다.");
            }
            File file = new File(resource.getPath());
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;
            List<List<String>> parsedLines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                parsedLines.add(parseLine(line));
            }
            return parsedLines;
        } catch (Exception e) {
            throw new StoreException("[ERROR] 올바르지 않은 CSV 형식입니다.");
        }
    }

    private static List<String> parseLine(String line) {
        if (!line.matches(PRODUCT_REGEX)) {
            throw new StoreException("[ERROR] 올바르지 않은 CSV 형식입니다.");
        }
        String[] parsedArr = line.split(CSV_REGEX, -1);
        return Arrays.asList(parsedArr);
    }
}