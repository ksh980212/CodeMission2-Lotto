package domain.lotto;

import domain.lotto.creatorPolicy.LottoCreatorPolicy;

public class LottoCreator {

  public final static int LOTTO_MIN_NUMBER = 1;
  public final static int LOTTO_MAX_NUMBER = 45;
  public final static int LOTTO_PRICE = 1000;

  private final LottoCreatorPolicy policy;

  private LottoCreator(LottoCreatorPolicy policy) {
    this.policy = policy;
  }

  public static LottoCreator of (LottoCreatorPolicy policy) {
    return new LottoCreator(policy);
  }

  public Lotto createLotto() {
    return policy.generate();
  }
}
