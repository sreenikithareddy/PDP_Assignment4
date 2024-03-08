package com.model;


import java.util.Date;
import java.util.Map;

public interface Model {

  void createPortfolio(Map<String,Integer> stockMap);

  Float getPortfolioValuation(Date date);

  Portfolio fetchPortfolio(String portfolioName);
}
