package store.domain.promotion;

import java.util.List;
import store.common.StoreException;

public record Promotions(List<Promotion> promotions) {

    public static Promotions of(List<Promotion> promotions) {
        return new Promotions(promotions);
    }

    public Promotion findByName(String name) {
        return promotions.stream()
                .filter(promotion -> promotion.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new StoreException("[ERROR] 잘못된 프로모션 이름입니다."));
    }
}
