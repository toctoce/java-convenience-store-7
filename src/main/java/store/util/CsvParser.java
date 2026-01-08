package store.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvParser {

    public static <T> List<T> parse(String content, Function<String[], T> mapper) {
        if (content == null || content.isBlank()) {
            return List.of();
        }

        String[] lines = content.split("\n"); // 줄바꿈으로 행 분리

        return Arrays.stream(lines)
                .skip(1) // 헤더 스킵
                .map(line -> line.split(",", -1)) // 콤마로 열 분리 (-1은 빈 값도 포함)
                .map(CsvParser::trimColumns) // 공백 제거 (선택 사항)
                .map(mapper) // 사용자가 정의한 객체 생성 로직 수행
                .collect(Collectors.toList());
    }

    // 각 컬럼의 앞뒤 공백 제거 유틸
    private static String[] trimColumns(String[] columns) {
        return Arrays.stream(columns)
                .map(String::trim)
                .toArray(String[]::new);
    }
}
