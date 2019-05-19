import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import org.junit.Test;

public class WalletShould {



  @Test
  public void return_0_when_the_stock_is_0() {
    // given
    Stock stock = new Stock(0, StockType.PETROLEUM);
    RateProvider rateProvider = new RateProvider();

    // when
    BigDecimal result = new Wallet(stock).value(Currency.EUR, rateProvider);

    // then
    assertThat(result).isEqualTo(BigDecimal.ZERO);
  }

  @Test
  public void return_5_when_the_stock_is_5_but_the_rate_provider_1() {
    // given
    Stock stock = new Stock(5, StockType.PETROLEUM);
    RateProvider rateProvider = mock(RateProvider.class);
    given(rateProvider.rate(StockType.PETROLEUM, Currency.EUR)).willReturn(BigDecimal.ONE);

    // when
    BigDecimal result = new Wallet(stock).value(Currency.EUR, rateProvider);

    // then
    assertThat(result).isEqualTo(BigDecimal.valueOf(5));
  }

  @Test
  public void return_15_when_the_stock_is_5_but_the_rate_provider_3() {
    // given
    Stock stock = new Stock(5, StockType.PETROLEUM);
    RateProvider rateProvider = mock(RateProvider.class);
    given(rateProvider.rate(StockType.PETROLEUM, Currency.EUR)).willReturn(BigDecimal.valueOf(3));

    // when
    BigDecimal result = new Wallet(stock).value(Currency.EUR, rateProvider);

    // then
    assertThat(result).isEqualTo(BigDecimal.valueOf(15));
  }

  @Test
  public void return_20_when_the_stock_is_10_but_the_rate_provider_2() {
    // given
    Stock stock = new Stock(10, StockType.PETROLEUM);
    RateProvider rateProvider = mock(RateProvider.class);
    given(rateProvider.rate(StockType.PETROLEUM, Currency.EUR)).willReturn(BigDecimal.valueOf(2));

    // when
    BigDecimal result = new Wallet(stock).value(Currency.EUR, rateProvider);

    // then
    assertThat(result).isEqualTo(BigDecimal.valueOf(20));
  }

  @Test
  public void return_() {
    // given

    // when

    // then
    assertThat(result)
  }
}
