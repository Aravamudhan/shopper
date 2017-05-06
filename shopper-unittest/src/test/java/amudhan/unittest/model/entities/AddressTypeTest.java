package amudhan.unittest.model.entities;

import org.testng.Assert;
import org.testng.annotations.Test;

import amudhan.shopper.model.entities.AddressType;

public class AddressTypeTest {

  @Test(description = "Test to find the string representation of an AddressType enum")
  public void getAddressTypeValueTest() {
    String addressTypeValue1 = AddressType.getAddressTypeValue(AddressType.HOME);
    Assert.assertTrue("Home".equalsIgnoreCase(addressTypeValue1));
  }

  @Test(
      description = "Test to find an enum of type AddressType based on an addresstype represented by as a string")
  public void getAddressTypeTest() {
    AddressType addressType1 = AddressType.getAddressType("other");
    Assert.assertEquals(addressType1, AddressType.OTHER);
    AddressType addressType2 = AddressType.getAddressType("homes");
    Assert.assertNull(addressType2);
  }
}
