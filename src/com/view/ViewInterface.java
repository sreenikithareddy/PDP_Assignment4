package com.view;

import com.model.Portfolio;

public interface ViewInterface {

  void showPortfolioComposition(Portfolio portfolio);

  void showPortfolioValuation(Portfolio portfolio,Float value);
}
