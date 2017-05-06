package amudhan.unittest.model.entities;

import org.testng.Assert;
import org.testng.annotations.Test;

import amudhan.shopper.model.entities.PaymentType;


public class PaymentTypeTest {

  @Test(description = "Test to find the string representation of a PaymentType enum")
  public void getPaymentTypeValueTest() {
    String paymentTypeValue = PaymentType.getPaymentTypeValue(PaymentType.CASH_ON_DELIVERY);
    Assert.assertTrue("Cash on delivery".equalsIgnoreCase(paymentTypeValue));
  }

  @Test(description = "Test to find a PaymentType enum by its textual representation")
  public void getPaymentTypeTest() {
    String paymentTypeValue = "Debit card";
    PaymentType pt1 = PaymentType.getPaymentType(paymentTypeValue);
    Assert.assertEquals(pt1, PaymentType.DEBIT_CARD);
    String wrongPaymentTypeValue = "DebitCard";
    PaymentType pt2 = PaymentType.getPaymentType(wrongPaymentTypeValue);
    Assert.assertNull(pt2);
  }
}
