package store.domain.product;

import store.domain.promotion.Promotion;

public record Product(String name, int price, Promotion promotion) {
}
