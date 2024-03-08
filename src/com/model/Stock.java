package com.model;

public class Stock implements StockInterface {

  private String tickerSymbol;

  private String stockName;

  private int quantity;

  @Override
  public void setTickerSymbol(String tickerSymbol) {
    this.tickerSymbol = tickerSymbol;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public void setStockName(String stockName) {
    this.stockName = stockName;
  }

  @Override
  public String getTickerSymbol() {
    return this.tickerSymbol;
  }

  @Override
  public int getQuantity() {
    return this.quantity;
  }

  @Override
  public String getStockName() {
    return this.stockName;
  }
}
