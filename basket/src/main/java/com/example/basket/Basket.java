package basket;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Basket {

  private @Id @GeneratedValue Long id;
  private Integer userId;
  private String basketItems;

  Basket() {}

  Basket(Integer userId, String basketItems) {
    this.userId = userId;
    this.basketItems = basketItems;
  }

  public String getBasketItems() {

    return basketItems;

}

}