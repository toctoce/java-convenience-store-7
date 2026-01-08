package store.domain.promotion;

import java.util.List;

public record Promotions(List<Promotion> promotions) {

    public static Promotions of(List<Promotion> promotions) {
        return new Promotions(promotions);
    }
}
