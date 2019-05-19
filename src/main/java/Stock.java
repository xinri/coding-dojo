public class Stock {

  private final int quantity;
  private final StockType type;

  public Stock(int quantity, StockType type) {
    this.quantity = quantity;
    this.type = type;
  }

  public int getQuantity() {
    return quantity;
  }

  public StockType getStockType() {
    return type;
  }
}
