# aw07

+ 加入购物车
![](assets/add-products.png)

+ 创建订单
![](assets/create-order.png)

+ 查询物流
![](assets/check-delivery.png)

Please extend your MicroPOS system by adding a delivery service shown as the following figure.

![](assets/10-pos.svg)

When an order is placed by a user, the order serivce sends out an event into some AMQP MOM (such as RabbitMQ). The delivery service will be notified and a new delivery entry will be generated automatically. User can query the delivery status for his orders.

Use [Spring Cloud Stream](https://spring.io/projects/spring-cloud-stream) to make the scenerio happen. Of coz you can refer to the [demo](https://github.com/sa-spring/stream-loan) for technical details.