package com.model;


import java.util.Date;

public interface ModelInterface {

  void createPortfolio();

  Float getPortfolioValuation(Date date);

  void checkPortfolio(String portfolioName);
}
