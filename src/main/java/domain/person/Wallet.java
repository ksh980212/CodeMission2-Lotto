package domain.person;

public class Wallet {

  private long amount;

  private Wallet(long amount) {
    this.amount = amount;
  }

  public static Wallet of (long amount) {
    validatePositiveNumber(amount);
    return new Wallet(amount);
  }

  /** API */
  public void payMoney(int price) {
    amount -= price;
  }

  public boolean canBuyLotto(int price) {
    return amount >= price;
  }

  /** validate */
  private static void validatePositiveNumber(long amount) {
    if( amount < 0 ) {
      throw new IllegalArgumentException(String.format("%d is not positive number", amount));
    }
  }

  /** Getter */
  public long getAmount() {
    return amount;
  }


}
