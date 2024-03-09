package com.controller;

import com.controller.input.AcceptInput;
import com.model.Model;
import com.model.Portfolio;
import com.view.ViewInterface;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class StockDataControllerImpl extends AcceptInput implements StockDataController {

  private Scanner inputScanner;

  private Model model;

  private ViewInterface viewInterface;

  private HashMap<String, String> tickerMap;

  public StockDataControllerImpl(Model model, ViewInterface viewInterface) {
    this.inputScanner = new Scanner(System.in);
    this.model = model;
    this.viewInterface = viewInterface;
  }

  @Override
  public void go() {

    while (true) {

      System.out.println(
          "Please enter a choice from the following \n 1. create portfolio \n 2. examine portfolio \n 3. get valuation of portfolio \n 4.Quit the program :");
      int input = inputScanner.nextInt();

      switch (input) {
        case 1:
          HashMap<String, Integer> stockMap = new HashMap<>();
          System.out.println(
              "Please enter the list of stocks(ticker symbols) and the respective quantity that you wish to have in your portfolio");
          while (true) {
            System.out.println("Please enter the ticker symbol(enter either of symbols 'F/f' to finalise) :");
            String ticker = inputScanner.nextLine();
            if (ticker.toLowerCase().equals("f")) {
              break;
            }
            if (tickerMap.containsKey(ticker)) {
              System.out.println("Please enter the quantity");
              int quantity = inputScanner.nextInt();
              stockMap.put(ticker, quantity);
            } else {
              System.out.println(
                  "The ticker symbol you entered is not present, please enter a correct one");
            }
          }
          //model.createPortfolio(stockMap);
          break;

        case 2:
          // should fetch the list pf portfolios and print them here -- to be done
          System.out.println("Please enter the name of the portfolio that you wish to examine :");
          String portfolioName = inputScanner.nextLine();
          Portfolio p = model.fetchPortfolio(portfolioName);
          viewInterface.showPortfolioComposition(p);
          break;

        case 3:
          System.out.println(
              "Please enter a date on which you wish to check the valuation of the portfolio in YYYY-MM-DD format");
          String dateString = inputScanner.nextLine();
          Date date = new Date(dateString);
          //float x = model.getPortfolioValuation(date);
          //viewInterface.showPortfolioValuation(x);
          break;

        case 4:
          return;

        default:
          System.out.println("Please enter a valid option");
      }
    }
  }
}
