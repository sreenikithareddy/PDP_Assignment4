package com.model;

import java.util.Date;
import java.util.Map;

public class ModelImpl implements Model {

  @Override
  public void createPortfolio(Map<String, Integer> stockMap, String portfolioName) {
  }

  @Override
  public Float getPortfolioValuation(String portfolioName, Date date) {
    return null;
  }

  @Override
  public Portfolio fetchPortfolio(String portfolioName) {
    return null;
  }
}
