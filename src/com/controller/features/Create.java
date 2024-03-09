package com.controller.features;

import com.controller.constants.StockMarketConstants;
import com.model.Model;
import java.util.HashMap;
import java.util.Scanner;

public class Create extends AbstractFeature {

  private final Model model;

  private final HashMap<String, Integer> stockMap;

  public Create(Model model, HashMap<String, Integer> stockMap) {
    this.model = model;
    this.stockMap = stockMap;
  }

  @Override
  public void runFeature() {
    this.processInput(this.scanner);
    model.createPortfolio(this.stockMap);
  }

  @Override
  protected void processInput(Scanner scanner) {
    stockMap.clear();
    while (true) {
      try {
        System.out.println(
            "Please enter the ticker symbol of the company (press F/f to finalize) : ");
        String ticker = scanner.nextLine();
        if (ticker.trim().toLowerCase().equals("f")) {
          if (stockMap.isEmpty())
          {
            System.out.println("There are no stocks selected hence not creating any portfolio and going to main menu");
          }
          break;
        }
        if (StockMarketConstants.tickerMap.containsKey(ticker)) {
          System.out.println("Please enter the quantity of the stock you wish to buy : ");
          int quantity = scanner.nextInt();
          stockMap.put(ticker,quantity);
        } else {
          System.out.println(
              "The ticker symbol given is not valid,Please enter the correct ticker symbol (press F/f to finalize) :");
        }
      } catch (Exception e) {
        System.out.println("An exception occured, please enter valid input");
      }
    }
  }
}
