package domain.lotto;

import domain.lotto.creatorPolicy.LottoCreatorPolicy;

public class LottoCreator {

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
