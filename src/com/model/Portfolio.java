package com.model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio implements IPortfolio {

  private List<IStock> stockList;

  @Override
  public void setStockList(List<IStock> stockList) {
    this.stockList = new ArrayList<>(stockList);
  }

  @Override
  public List<IStock> getStockList() {
    return this.stockList;
  }
}
