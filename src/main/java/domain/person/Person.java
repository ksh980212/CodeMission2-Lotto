package domain.person;

import domain.lotto.LottoPrize;
import domain.lotto.creatorPolicy.AutoCreatorPolicy;
import domain.lotto.Lotto;
import domain.lotto.LottoCreator;
import domain.lotto.creatorPolicy.ManualCreatorPolicy;
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

  /** API */
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

  public void buyManualLotto(List<Integer> list) {
    validateCanBuyManualLotto();
    LottoCreator creator = LottoCreator.of(ManualCreatorPolicy.of(list));
    lottoList.add(creator.createLotto());
    wallet.payMoney(LottoCreator.LOTTO_PRICE);
  }

  public List<LottoPrize> confirmLotto(List<Integer> lastWinningNumbers, int bonusNumber) {
    List<LottoPrize> lottoPrizeList = new ArrayList<>();
    for(Lotto lotto : lottoList) {
      lottoPrizeList.add(lotto.check(lastWinningNumbers, bonusNumber));
    }
    return lottoPrizeList;
  }

  private void validateCanBuyManualLotto() {
    if(wallet.getAmount() < LottoCreator.LOTTO_PRICE) {
      throw new IllegalArgumentException("Can't buy Manual Lotto exceed Amount");
    }
  }

  /** Getter */
  public LottoResultDto getLottoStatusDto() {
    return LottoResultDto.of(lottoList);
  }

  public List<Lotto> getLottoList() {
    return lottoList;
  }

  public Wallet getWallet() {
    return wallet;
  }
}
