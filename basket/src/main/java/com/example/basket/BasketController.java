package basket;

import java.util.List;

import org.json.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BasketController {

  private final BasketRepository repository;

  BasketController(BasketRepository repository) {
    this.repository = repository;
  }

  // Create new basket
  @PostMapping("/baskets")
  Basket newBasket(@RequestBody Basket newBasket) {
    return repository.save(newBasket);
  }

  // Retrieve specific basket
  @GetMapping("/baskets/{id}")
  String one(@PathVariable Long id) {

    Basket basket = repository.findById(id)
      .orElseThrow(() -> new BasketNotFoundException(id));

    return basket.getBasketItems();
  }

  // Add to basket
  @PutMapping("/baskets/{id}")
  Basket replaceBasket(@RequestBody Basket newBasket, @PathVariable Long id) {

    return repository.findById(id)
      .map(Basket -> {
        String basketItems = Basket.getBasketItems();
        JSONArray basketArray = new JSONArray(basketItems);
        basketArray.put(newBasket.getBasketItems());
        Basket.setBasketItems(basketArray.toString());
        return repository.save(Basket);
      })
      .orElseThrow(() -> new BasketNotFoundException(id));
  }

  // Edit quantity
  @PutMapping("/baskets/quantity/{id}/{arrayIndex}/{quantity}")
  Basket replaceBasket(@RequestBody Basket newBasket, @PathVariable Long id, @PathVariable Integer arrayIndex, @PathVariable Integer quantity) {

    return repository.findById(id)
      .map(Basket -> {
        String basketItems = Basket.getBasketItems();
        JSONArray basketArray = new JSONArray(basketItems);
        JSONObject basketObject = basketArray.getJSONObject(arrayIndex);
        basketObject.put("quantity", quantity);
        basketArray.put(arrayIndex,basketObject);
        Basket.setBasketItems(basketArray.toString());
        return repository.save(Basket);
      })
      .orElseThrow(() -> new BasketNotFoundException(id));
  }

  // Remove from basket
  @DeleteMapping("/baskets/{id}/{arrayIndex}")
  Basket deleteBasket(@PathVariable Long id, @PathVariable Integer arrayIndex ) {
    return repository.findById(id)
      .map(Basket -> {
        String basketItems = Basket.getBasketItems();
        JSONArray basketArray = new JSONArray(basketItems);
        basketArray.remove(arrayIndex);
        Basket.setBasketItems(basketArray.toString());
        return repository.save(Basket);
      })
      .orElseThrow(() -> new BasketNotFoundException(id));
    
  }
}