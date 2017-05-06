package amudhan.unittest.model.entities;

import org.testng.Assert;
import org.testng.annotations.Test;

import amudhan.shopper.model.entities.OrderStatus;

public class OrderStatusTest {

  @Test(description = "Test to find the string representation of an OrderStatus enum")
  public void getOrderStatusValueTest() {
    String orderStatusText = OrderStatus.getOrderStatusValue(OrderStatus.ORDER_PLACED);
    Assert.assertEquals(orderStatusText, "order placed");
    Assert.assertNotEquals(orderStatusText, "orderplaced");
  }

  @Test(
      description = "Test to find an enum of type OrderStatus based on an orderStatus represented by as a string")
  public void getOrderStatusTest() {
    OrderStatus orderStatus1 = OrderStatus.getOrderStatus("order placed");
    Assert.assertEquals(orderStatus1, OrderStatus.ORDER_PLACED);
    OrderStatus orderStatus2 = OrderStatus.getOrderStatus("orders placed");
    Assert.assertNull(orderStatus2);
  }

}
