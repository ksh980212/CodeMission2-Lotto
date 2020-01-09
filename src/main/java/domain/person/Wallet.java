package domain.person;

public class Wallet {

  private long amount; // 소유 금액

  private Wallet(long amount) {
    this.amount = amount;
  }

  public static Wallet of (long amount) {
    validatePositiveNumber(amount);
    return new Wallet(amount);
  }

  public long getAmount() {
    return amount;
  }

  private static void validatePositiveNumber(long amount) {
    if( amount < 0 ) {
      throw new IllegalArgumentException(String.format("%d is not positive number", amount));
    }
  }
}
