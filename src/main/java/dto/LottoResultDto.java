package dto;

import domain.lotto.Lotto;
import domain.lotto.LottoType;
import java.util.List;

public class LottoResultDto {

  private final List<Lotto> lottoList;

  private LottoResultDto(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public static LottoResultDto of (List<Lotto> lottoList) {
    return new LottoResultDto(lottoList);
  }

  public void showStatus() {
    System.out.println(String.format("Manual count : %d, Auto count : %d",
        lottoList.stream().filter(x-> x.getType() == LottoType.MANUAL).count(),
        lottoList.stream().filter(x-> x.getType() == LottoType.AUTO).count()
    ));
    for (Lotto lotto : lottoList) {
      System.out.println(lotto);
    }
  }
}
