package kitchenpos.products.tobe.domain;

import kitchenpos.products.tobe.vo.DisplayedName;
import kitchenpos.products.tobe.vo.Price;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DisplayedName displayedName;

    @Embedded
    private Price price;

    protected Product() {
    }

    public Product(String name, int price) {
        this(null, name, price);
    }

    public Product(Long id, String name, int price) {
        this.id = id;
        this.displayedName = new DisplayedName(name);
        this.price = new Price(price);
    }

    public void changePrice(int price) {
        this.price = new Price(price);
    }

    public Long getId() {
        return id;
    }

    public DisplayedName getDisplayedName() {
        return displayedName;
    }

    public BigDecimal getPrice() {
        return price.getPrice();
    }
}
