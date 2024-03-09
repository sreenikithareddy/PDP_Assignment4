package com.controller.features;

import com.controller.constants.StockMarketConstants;
import com.model.Model;
import java.util.HashMap;
import java.util.Scanner;

public class CreatePortfolio extends AbstractFeature {

  private final Model model;

  private final HashMap<String, Integer> stockMap;

  public CreatePortfolio(Model model, HashMap<String, Integer> stockMap) {
    this.model = model;
    this.stockMap = stockMap;
  }

  @Override
  public void runFeature() {
    this.processInput(this.scanner);
    String name = getPortfolioName();
    model.createPortfolio(this.stockMap,name);
  }

  @Override
  protected void processInput(Scanner scanner) {
    stockMap.clear();
    while (true) {
      try {
        System.out.println(
            "Please enter the ticker symbol of the company (press F to finalize the stocks / press Q to abort creating portfolio) : ");
        String ticker = scanner.nextLine();
        if (ticker.trim().toLowerCase().equals("q")) {
          System.out.println("Exiting from create portfolio");
          break;
        } else if (ticker.trim().toLowerCase().equals("f")) {
          if (stockMap.isEmpty()) {
            System.out.println(
                "There are no stocks selected hence not creating any portfolio and going to main menu");
          }
          break;
        } else if (StockMarketConstants.tickerMap.containsKey(ticker)) {
          System.out.println("Please enter the quantity of the stock you wish to buy : ");
          int quantity = scanner.nextInt();
          stockMap.put(ticker, quantity);
        } else {
          System.out.println(
              "The ticker symbol given is not valid,Please enter the correct ticker symbol (press F/f to finalize) :");
        }
      } catch (Exception e) {
        System.out.println("An exception occured, please enter valid input");
      }
    }
  }

  private String getPortfolioName()
  {
    while (true)
    {
      try {
        System.out.println("Please enter a name for the portfolio : ");
        String name = scanner.nextLine();
        if (!name.isBlank() && !name.isEmpty())
        {
          return name;
        }
      }
      catch (Exception e)
      {
        System.out.println("An exception occured :" + e.getMessage() + "please enter a valid string name");
      }
    }
  }
}
