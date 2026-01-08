package store.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import store.domain.promotion.Promotion;
import store.domain.promotion.Promotions;

class PromotionCsvParserTest {

    @Test
    void 프로모션_Csv_파서() {
        Promotions promotions = PromotionCsvParser.parseCSV();
        Promotion promotion1 = promotions.promotions().get(0);
        assertThat(promotion1.name()).isEqualTo("탄산2+1");
        assertThat(promotion1.buyCount()).isEqualTo(2);
        assertThat(promotion1.giveCont()).isEqualTo(1);
        assertThat(promotion1.start()).isEqualTo(LocalDate.of(2024, 1, 1));
        assertThat(promotion1.end()).isEqualTo(LocalDate.of(2024, 12, 31));
        assertThat(promotions.promotions().size()).isEqualTo(3);
    }
}