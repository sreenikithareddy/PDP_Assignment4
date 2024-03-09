package com.controller;

import com.controller.features.AbstractFeature;
import com.controller.features.CreatePortfolio;
import com.controller.features.ValuatePortfolio;
import com.controller.input.AcceptInput;
import com.model.Model;
import com.model.Portfolio;
import com.view.IView;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class StockDataControllerImpl extends AcceptInput implements StockDataController {

  private Scanner inputScanner;

  private Model model;

  private IView viewInterface;

  private HashMap<String, AbstractFeature> featureMap;

  public StockDataControllerImpl(Model model, IView viewInterface) {
    this.inputScanner = new Scanner(System.in);
    this.model = model;
    this.viewInterface = viewInterface;
    this.featureMap = new HashMap<>();
    this.loadFeatures();
  }

  private void loadFeatures() {
    AbstractFeature createPortfolio = new CreatePortfolio(this.model, this.viewInterface,
        inputScanner);
    AbstractFeature valuatePortfolio = new ValuatePortfolio(this.model, this.viewInterface,
        this.inputScanner);

    featureMap.put("create", createPortfolio);
    featureMap.put("valuate", valuatePortfolio);
  }

  @Override
  public void go() throws IOException {
    while (true) {
      System.out.println(
          "Please enter a choice from the following \n 1. create portfolio (create) \n 2. examine portfolio (examine) \n 3. get valuation of portfolio (valuate) \n 4.Quit the program (Q) :");
      String input = inputScanner.nextLine();
      if (input.trim().toLowerCase().equals("q")) {
        break;
      } else if (featureMap.containsKey(input)) {
        featureMap.get(input).runFeature();
      }
    }
  }
}
