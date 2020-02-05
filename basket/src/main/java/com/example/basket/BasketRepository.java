package basket;

import org.springframework.data.jpa.repository.JpaRepository;

interface BasketRepository extends JpaRepository<Basket, Long> {
    
}