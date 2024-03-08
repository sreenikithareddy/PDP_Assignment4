package com.model;

public interface StockInterface {

  void setTickerSymbol(String tickerSymbol);

  void setQuantity(int quantity);

  void setStockName(String stockName);

  String getTickerSymbol();

  int getQuantity();

  String getStockName();
}
