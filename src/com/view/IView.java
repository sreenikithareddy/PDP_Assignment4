package com.view;

import com.model.Portfolio;

public interface IView {

  void showPortfolioComposition(Portfolio portfolio);

  void showPortfolioValuation(Float value);
}
