package basket;

class BasketNotFoundException extends RuntimeException {

  BasketNotFoundException(Long id) {
    super("Could not find Basket " + id);
  }
}