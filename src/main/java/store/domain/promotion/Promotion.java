package store.domain.promotion;

import java.time.LocalDate;

public record Promotion(String name, int buyCount, int giveCont, LocalDate start, LocalDate end) {

    public static Promotion of(String name, int buyCount, int giveCount, LocalDate start, LocalDate end) {
        return new Promotion(name, buyCount, giveCount, start, end);
    }
}
