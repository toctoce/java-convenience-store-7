package store.domain;

import java.time.DayOfWeek;
import java.util.regex.Pattern;
import store.common.ErrorMessage;
import store.common.StoreException;

public record Date(int month, int dayOfMonth, DayOfWeek dayOfWeek) {

    // 파라미터 부분은 실제 타입으로 수정 필요
    /*
    public Date(파라미터) {
        this(month, dayOfMonth, dayOfWeek);
    }
    */

    public static Date from(String input) {
        validate(input);
        // return new Date(...);
        return null;
    }

    private static void validate(String input) {
        validateFormat(input);
        // validateA(파라미터);
    }

    private static void validateFormat(String input) {
        String REGEX = ".*";
        if (!Pattern.matches(REGEX, input)) {
            throw new StoreException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
