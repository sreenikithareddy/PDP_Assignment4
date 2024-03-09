package com.model;

public interface IStock {

  void setTickerSymbol(String tickerSymbol);

  void setQuantity(int quantity);

  void setStockName(String stockName);

  String getTickerSymbol();

  int getQuantity();

  String getStockName();
}
