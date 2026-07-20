https://github.com/user-attachments/assets/a915af51-3879-4afd-a153-df0d1c9517c8


Requirement Gathering / Clarification:

Design Patterns Used:
- Singleton: RestaurantManager, OrderManager
- Factory: IOrderFactory (NowOrderFactory, ScheduleOrderFactory)
- Strategy: IPaymentStrategy (CreditCard, NetBanking, UPI)

Objects:

- Zomato (Orchestration class)

- Cart
  1. Restaurant* r
  2. Vector<MenuItem> items
  3. addToCart(MenuItem it)
  4. totalCost()
  5. isEmpty()

- User <<Model>>
  1. int userId
  2. String name
  3. String address
  4. Cart cart

- RestaurantManager <<Singleton>>
  1. vector<Restaurant> restaurants
  2. addRestaurant(Restaurant r)
  3. searchByLoc(loc)

- Restaurant <<Model>>
  1. int restaurantId
  2. String name
  3. String loc
  4. vector<MenuItem> menu

- MenuItem <<Model>>
  1. String code
  2. String name
  3. int price
  (getters & setters)

- IOrderFactory <<Interface>>
  1. createOrder()
  - ScheduleOrderFactory: stores scheduleTime; createOrder(type)
  - NowOrderFactory: createOrder(type)

- Order
  1. int id
  2. User user
  3. Restaurant* rest
  4. vector<MenuItem> items
  5. PaymentStrategy strategy
  6. getType()
  - DeliveryOrder: String address; getType()
  - PickupOrder: String resAddress; getType()

- OrderManager <<Singleton>>
  1. vector<Order> orderList
  2. addOrder(order)
  3. listOrder()

- IPaymentStrategy <<Interface>>
  1. pay()
  - CreditCard: pay()
  - NetBanking: pay()
  - UPI: pay()

- NotificationService
  1. Order order
  2. notifyUser()

Relationships:
- User has-a Cart; Cart has-a Restaurant and a list of MenuItem
- RestaurantManager aggregates (1..n) Restaurant; Restaurant aggregates (1..n) MenuItem
- Order references Restaurant, list of MenuItem, and a PaymentStrategy
- OrderManager aggregates (1..n) Order
- DeliveryOrder / PickupOrder extend Order; created via IOrderFactory implementations
- CreditCard / NetBanking / UPI implement IPaymentStrategy
- NotificationService notifies User about an Order
- Zomato acts as the orchestration/facade class tying Cart, Restaurant, MenuItem, and NotificationService together

(No code yet — design captured from provided whiteboard snapshot, awaiting further instructions before implementation.)
