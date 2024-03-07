package com.model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio implements PortfolioInterface {

  private List<StockInterface> stockList;

  @Override
  public void setStockList(List<StockInterface> stockList) {
    this.stockList = new ArrayList<>(stockList);
  }

  @Override
  public List<StockInterface> getStockList() {
    return this.stockList;
  }
}
