package dto;

import domain.lotto.Lotto;
import domain.lotto.LottoType;
import java.util.List;

// COMMENT 일급 컬렉션 좋은 접근입니다~
public class LottoResultDto {

  private final List<Lotto> lottoList;

  private LottoResultDto(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public static LottoResultDto of (List<Lotto> lottoList) {
    return new LottoResultDto(lottoList);
  }

  public void showStatus() {
    showCountStatus();
    showLottoStatus();
  }

  // COMMENT 여기서 셀려고 type이 있다.. 만약 type을 출력하고 싶으시다면 어쩔 수 없는 선택이었겠네요
  // 물론 저라면 처음에 자동으로 몇 개 할건지 물어보니 그걸로 출력해줬을 것 같네요
  // 이 로직을 계속 쓰시려면 lottoList ~ count를 함수로 분리해주세요
  // Predicate 을 변수로 받는 메소드로 뺄 수 있고오, getType == LottoType.XXX 는 Lotto에 들어가야 할 로직입니다
  private void showCountStatus() {
    System.out.println(String.format("Manual count : %d, Auto count : %d",
        lottoList.stream().filter(x-> x.getType() == LottoType.MANUAL).count(),
        lottoList.stream().filter(x-> x.getType() == LottoType.AUTO).count()
    ));
  }

  private void showLottoStatus() {
    for (Lotto lotto : lottoList) {
      System.out.println(lotto);
    }
  }
}
