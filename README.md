# basketSpringBoot

#### Dependencies
JDK 1.8 or later

Gradle 4+

#### Screen recordings:
Showing implementation: https://www.dropbox.com/s/pjvvp5nzn6qxlk2/workingImplementaitonUsingPostman.mp4?dl=0
Showing tests: https://www.dropbox.com/s/au4l6lxdawdlrvg/runningTests.mp4?dl=0

#### Explanation of endpoints in BasketController.java

@PostMapping("/baskets")
    • Usage: create new basket
    • Example body: 
        ◦ {"userId": 13,"basketItems": "[{productId:12,quantity:2}]"}

@GetMapping("/baskets/{id}")
    • Usage: retrieve a single basket with specific database id

@PutMapping("/baskets/{id}")
    • Usage: add new item to existing basket

@PutMapping("/baskets/quantity/{id}/{arrayIndex}/{quantity}")
    • Usage: updates quantity of basket item

@DeleteMapping("/baskets/{id}/{arrayIndex}")
    • Usage: removes item from basket
