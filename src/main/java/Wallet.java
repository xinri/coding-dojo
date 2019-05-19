import java.math.BigDecimal;

public class Wallet {

  private Stock stock;

  public Wallet(Stock stock) {
    this.stock = stock;
  }

  public BigDecimal value(Currency currency, RateProvider rateProvider) {
    if (stock.getQuantity() == 0)
      return BigDecimal.ZERO;

    return rateProvider.rate(stock.getStockType(), currency)
        .multiply(BigDecimal.valueOf(stock.getQuantity()));
  }
}
