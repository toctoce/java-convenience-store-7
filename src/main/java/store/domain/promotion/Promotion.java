package store.domain.promotion;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;

public record Promotion(String name, int buyCount, int giveCont, LocalDate start, LocalDate end) {

    public static Promotion of(String name, int buyCount, int giveCount, LocalDate start, LocalDate end) {
        return new Promotion(name, buyCount, giveCount, start, end);
    }

    public boolean availableToday() {
        LocalDate now = DateTimes.now().toLocalDate();
        if (now.compareTo(start) < 0 || now.compareTo(end) > 0) {
            return false;
        }
        return true;
    }
}
