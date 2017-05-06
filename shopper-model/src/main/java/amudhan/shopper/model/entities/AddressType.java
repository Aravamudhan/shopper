package amudhan.shopper.model.entities;

import java.util.EnumSet;

public enum AddressType {

  HOME("home"), WORK("work"), PUBLIC("public"), OTHER("other");

  private final String addressTypeValue;

  private AddressType(String addressTypeValue) {
    this.addressTypeValue = addressTypeValue;
  }

  /**
   * Given an enum of type AddressType, its string representation is returned<br/>
   * 
   * @param addressType
   * @return
   */
  public static String getAddressTypeValue(AddressType addressType) {
    String addressTypeText = null;
    if (addressType != null) {
      addressTypeText = addressType.addressTypeValue;
    }
    return addressTypeText;
  }

  /**
   * Given a string this method returns its matching enum<br/>
   * 
   * @param addressTypeText
   * @return
   */
  public static AddressType getAddressType(String addressTypeText) {
    AddressType addressType = null;
    if (addressTypeText != null) {
      for (AddressType at : EnumSet.allOf(AddressType.class)) {
        if (at.addressTypeValue.equalsIgnoreCase(addressTypeText)) {
          addressType = at;
          break;
        }
      }
    }
    return addressType;
  }

  @Override
  public String toString() {
    return addressTypeValue;
  }
}
