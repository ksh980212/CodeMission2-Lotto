package domain.person;

import domain.lotto.AutoCreatorPolicy;
import domain.lotto.Lotto;
import domain.lotto.LottoCreator;
import dto.LottoPrizeDto;
import dto.LottoResultDto;
import java.util.ArrayList;
import java.util.List;

public class Person {

  private final Wallet wallet;
  private final List<Lotto> lottoList;

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

  public void confirmLotto(List<Integer> lastWinningNumbers) {
    for(Lotto lotto : lottoList) {
      lotto.check(lastWinningNumbers);
    }
  }

  public void checkBonusLotto(int bonusNumber) {
    for(Lotto lotto : lottoList) {
      lotto.checkBonus(bonusNumber);
    }
  }

  private void buyAutoLotto(Wallet wallet) {
    LottoCreator creator = LottoCreator.of(AutoCreatorPolicy.of());
    lottoList.add(creator.createLotto());
    wallet.payMoney(LottoCreator.LOTTO_PRICE);
  }

  public LottoResultDto getLottoStatusDto() {
    return LottoResultDto.of(lottoList);
  }

  public LottoPrizeDto getLottoPrizeDto() {
    return LottoPrizeDto.of(lottoList);
  }

  public List<Lotto> getLottoList() {
    return lottoList;
  }
  public Wallet getWallet() {
    return wallet;
  }
}
