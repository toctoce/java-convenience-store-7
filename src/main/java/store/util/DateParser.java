package store.util;

import java.time.LocalDate;
import store.common.StoreException;

public class DateParser {
    public static final String DATE_REGEX = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";

    public static LocalDate parse(String time) {
        if (!time.matches(DATE_REGEX)) {
            throw new StoreException("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
        }
        String[] split = time.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int date = Integer.parseInt(split[2]);

        try {
            return LocalDate.of(year, month, date);
        } catch (Exception e) {
            throw new StoreException("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
        }
    }
}
