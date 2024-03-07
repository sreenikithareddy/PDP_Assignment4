package com.model;

import java.util.List;

public interface PortfolioInterface {

  void setStockList(List<StockInterface> stockList);

  List<StockInterface> getStockList();
}
