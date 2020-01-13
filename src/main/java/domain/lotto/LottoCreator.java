package domain.lotto;

import domain.lotto.creatorPolicy.LottoCreatorPolicy;

public class LottoCreator {

  private final LottoCreatorPolicy policy;

  private LottoCreator(LottoCreatorPolicy policy) {
    this.policy = policy;
  }

  // COMMENT 여기 보면 of 뒤에 ( 전에 공백이 있져.. 다른것들은 없고요!
  // 맞춰주심이 좋을 듯 합니다 저는 메소드이름-( 사이에 공백을 쓰지 않는 편입니다.
  public static LottoCreator of (LottoCreatorPolicy policy) {
    return new LottoCreator(policy);
  }

  // COMMENT 아 아름답네요 Creator 는 policy 를 위임받아 policy 로부터 로또를 생성하는데
  // 생성 방법은 인터페이스로 숨겨져 있다
  public Lotto createLotto() {
    return policy.generate();
  }
}
