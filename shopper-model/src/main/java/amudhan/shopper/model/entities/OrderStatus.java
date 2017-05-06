package amudhan.shopper.model.entities;

import java.util.EnumSet;

public enum OrderStatus {

  PENDING("pending"), ORDER_PLACED("order placed"), SHIPPED("shipped"), DELIVERED(
      "delivered"), CANCELED("canceled");

  private final String orderStatusValue;

  private OrderStatus(String orderStatusValue) {
    this.orderStatusValue = orderStatusValue;
  }

  /**
   * Given an enum of type Orderstatus, its string representation is returned<br/>
   * 
   * @param orderStatus
   * @return
   */
  public static String getOrderStatusValue(OrderStatus orderStatus) {
    String orderStatusText = null;
    if (orderStatus != null) {
      orderStatusText = orderStatus.orderStatusValue;
    }
    return orderStatusText;
  }

  /**
   * Given a string this method returns its matching enum<br/>
   * 
   * @param orderStatusText
   * @return
   */
  public static OrderStatus getOrderStatus(String orderStatusText) {
    OrderStatus orderStatus = null;
    if (orderStatusText != null) {
      for (OrderStatus os : EnumSet.allOf(OrderStatus.class)) {
        if (orderStatusText.equalsIgnoreCase(os.orderStatusValue)) {
          orderStatus = os;
          break;
        }
      }
    }
    return orderStatus;
  }

}
