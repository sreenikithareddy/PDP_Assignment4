package com.model;

import java.util.List;

public interface IPortfolio {

  void setStockList(List<IStock> stockList);

  List<IStock> getStockList();
}
