package store.util;

import static store.util.DateParser.DATE_REGEX;

import java.time.LocalDate;
import store.common.StoreException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import store.domain.promotion.Promotion;
import store.domain.promotion.Promotions;

public class PromotionCsvParser {

    private static final String CSV_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String PROMOTION_REGEX = "[^,]+,[0-9]+,[0-9]+," + DATE_REGEX + "," + DATE_REGEX;

    public static final String FILENAME = "promotions.md";

    public static Promotions parseCSV() {
        List<List<String>> parsedLines = readCSV();
        List<Promotion> promotions = new ArrayList<>();
        for (List<String> parsedLine : parsedLines) {
            String name = parsedLine.get(0);
            int buyCount = Integer.parseInt(parsedLine.get(1));
            int giveCount = Integer.parseInt(parsedLine.get(2));
            LocalDate start = DateParser.parse(parsedLine.get(3));
            LocalDate end = DateParser.parse(parsedLine.get(4));
            promotions.add(Promotion.of(name, buyCount, giveCount, start, end));
        }
        return Promotions.of(promotions);
    }

    public static List<List<String>> readCSV() {
        try {
            URL resource = PromotionCsvParser.class.getClassLoader().getResource(FILENAME);
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
        if (!line.matches(PROMOTION_REGEX)) {
            throw new StoreException("[ERROR] 올바르지 않은 CSV 형식입니다.");
        }
        String[] parsedArr = line.split(CSV_REGEX, -1);
        return Arrays.asList(parsedArr);
    }
}