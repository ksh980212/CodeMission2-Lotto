package domain.person;

import domain.lotto.LottoConstant;
import domain.lotto.LottoPrize;
import domain.lotto.creatorPolicy.AutoCreatorPolicy;
import domain.lotto.Lotto;
import domain.lotto.LottoCreator;
import domain.lotto.creatorPolicy.ManualCreatorPolicy;
import dto.LottoResultDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    while(wallet.canBuyLotto(LottoConstant.LOTTO_PRICE)) {
      buyAutoLotto(wallet);
    }
  }

  private void buyAutoLotto(Wallet wallet) {
    LottoCreator creator = LottoCreator.of( AutoCreatorPolicy.of() );
    lottoList.add(creator.createLotto());
    wallet.payMoney(LottoConstant.LOTTO_PRICE);
  }

  public void buyManualLotto(List<Integer> list) {
    validateCanBuyManualLotto();
    LottoCreator creator = LottoCreator.of(ManualCreatorPolicy.of(list));
    lottoList.add(creator.createLotto());
    wallet.payMoney(LottoConstant.LOTTO_PRICE);
  }

  public List<LottoPrize> confirmLotto(List<Integer> lastWinningNumbers, int bonusNumber) {
    validateDuplicateWinningNumbers(lastWinningNumbers, bonusNumber);
    List<LottoPrize> lottoPrizeList = new ArrayList<>();
    for(Lotto lotto : lottoList) {
      lottoPrizeList.add(lotto.check(lastWinningNumbers, bonusNumber));
    }
    return lottoPrizeList;
  }

  /** validate */
  private void validateCanBuyManualLotto() {
    if(wallet.getAmount() < LottoConstant.LOTTO_PRICE) {
      throw new IllegalArgumentException("Can't buy Manual Lotto exceed Amount");
    }
  }

  private void validateDuplicateWinningNumbers(List<Integer> lastWinningNumbers, int bonusNumber) {
    Set<Integer> set = new HashSet<>(lastWinningNumbers);
    set.add(bonusNumber);
    if( set.size() != ( 6 + 1 ) ) {
      throw new IllegalArgumentException("Duplicate Winning numbers or should be 6 + 1");
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
