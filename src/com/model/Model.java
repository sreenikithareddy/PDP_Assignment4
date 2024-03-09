package com.model;


import java.io.IOException;
import java.util.Date;
import java.util.Map;

public interface Model {

  /**
   * Function utilized to create a new stock portfolio.
   *
   * @param stockMap a map of ticker symbols and quantity of each stock to be added as part of a
   *                 portfolio.
   */
  void createPortfolio(Map<String, Integer> stockMap,String portfolioName,Map<String,String> tickerMap)
      throws IOException;

  /**
   * Function utilized to get the valuation of a portfolio.
   *
   * @param date accepts a parameter of type date to imply the date on which the valuation is to be
   *             calculated.
   * @return a float representing the valuation.
   */
  Float getPortfolioValuation(String portfolioName, Date date);

  Portfolio fetchPortfolio(String portfolioName);

}
