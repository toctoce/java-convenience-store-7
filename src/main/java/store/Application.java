package store;

import store.domain.promotion.Promotions;
import store.util.PromotionCsvParser;


public class Application {
    public static void main(String[] args) {

        Promotions promotions = PromotionCsvParser.parseCSV();
        System.out.println("promotions = " + promotions);
//        AppConfig appConfig = new AppConfig();
//        appConfig.controller().run();
    }
}
