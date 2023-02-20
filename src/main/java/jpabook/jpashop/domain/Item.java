package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
// 조인전략
@Inheritance(strategy = InheritanceType.JOINED)
// 단일테이블전략
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 구현 클래스마다 테이블 전략
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
