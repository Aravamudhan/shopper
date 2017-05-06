package amudhan.shopper.model.entities;

import java.util.EnumSet;

/**
 * An enum that encompasses different types of payments
 * 
 * @author amudhan
 *
 */
public enum PaymentType {

  CREDIT_CARD("credit card"), DEBIT_CARD("debit card"), NET_BANKING(
      "net banking"), CASH_ON_DELIVERY("cash on delivery");

  private final String paymentTypeValue;

  private PaymentType(String paymentTypeValue) {
    this.paymentTypeValue = paymentTypeValue;
  }

  /**
   * Given an enum of type PaymentType, its string representation is returned<br/>
   * 
   * @param paymentType
   * @return
   */
  public static String getPaymentTypeValue(PaymentType paymentType) {
    String paymentTypeText = null;
    if (paymentType != null) {
      paymentTypeText = paymentType.paymentTypeValue;
    }
    return paymentTypeText;
  }

  /**
   * Given a string this method returns its matching enum<br/>
   * 
   * @param paymentTypeText
   * @return
   */
  public static PaymentType getPaymentType(String paymentTypeText) {
    PaymentType paymentType = null;
    if (paymentTypeText != null) {
      for (PaymentType pt : EnumSet.allOf(PaymentType.class)) {
        if (pt.paymentTypeValue.equalsIgnoreCase(paymentTypeText.trim())) {
          paymentType = pt;
          break;
        }
      }
    }
    return paymentType;
  }

  @Override
  public String toString() {
    return paymentTypeValue;
  }


}
