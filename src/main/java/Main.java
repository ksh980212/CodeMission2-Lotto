import controller.LottoController;

public class Main {

  public static void main(String[] args) {
    try {
      LottoController.buyLottoAndConfirm();
    }
    catch(IllegalArgumentException e){
      System.out.println("Error occur" + e.getMessage());
    }
  }
}
