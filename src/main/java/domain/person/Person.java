package domain.person;

import domain.lotto.AutoCreatorPolicy;
import domain.lotto.Lotto;
import domain.lotto.LottoCreator;
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

  public void buyAutoLottoAllProperty() {
    while(wallet.canBuyLotto(LottoCreator.LOTTO_PRICE)) {
      buyAutoLotto(wallet);
    }
  }

  private void buyAutoLotto(Wallet wallet) {
    LottoCreator creator = LottoCreator.of(AutoCreatorPolicy.of());
    lottoList.add(creator.createLotto());
    wallet.payMoney(LottoCreator.LOTTO_PRICE);
  }

  public List<Lotto> getLottoList() {
    return lottoList;
  }
  public Wallet getWallet() {
    return wallet;
  }
}
