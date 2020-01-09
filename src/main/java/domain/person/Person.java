package domain.person;

import domain.lotto.Lotto;
import java.util.ArrayList;
import java.util.List;

public class Person {

  private final Wallet wallet; // 소유 지갑
  private final List<Lotto> lottoList; // 소유 로또

  private Person(long amount) {
    this.wallet = Wallet.of(amount);
    this.lottoList = new ArrayList<>();
  }

  public static Person of(long amount) {
    return new Person(amount);
  }

  public Wallet getWallet() {
    return wallet;
  }

  public List<Lotto> getLottoList() {
    return lottoList;
  }
}
