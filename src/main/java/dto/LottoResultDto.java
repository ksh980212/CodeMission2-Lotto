package dto;

import domain.lotto.Lotto;
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
    System.out.println(String.format("buy Lotto Count : %d", lottoList.size()));
    for(int i = 0, end= lottoList.size(); i< end; i++ ) {
      System.out.println(lottoList.get(i));
    }
  }
}
