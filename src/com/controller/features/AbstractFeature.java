package com.controller.features;

import com.controller.input.AcceptInput;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractFeature extends AcceptInput implements IFeature {

  protected Scanner scanner;

  protected List<String> fetchPortfolioList() {
    LinkedList<String> portfolioNames = new LinkedList<>();
    try {
      File currDir = new File("");
      String absolutePath = currDir.getAbsolutePath();
      File portfolioDir = new File(absolutePath, "portfolios");

      File[] portfolios = portfolioDir.listFiles();

      for (File file : portfolios) {
        portfolioNames.add(file.getName());
      }
    } catch (Exception e) {
      System.out.println("An exception occured : " + e.getMessage());
    }
    return portfolioNames;
  }

  // need to implement the quit functionality for the user in this method.
  protected String getPortfolioName() {
    List<String> portfolioList = this.fetchPortfolioList();
    while (true) {
      try {
        System.out.println("Please enter a name for the portfolio : ");
        String name = scanner.nextLine();
        if (!portfolioList.isEmpty() && portfolioList.contains(name.trim()))
        {
          System.out.println("There is already a file existing with the name "+ name +"hence, please use a different name");
        }
        else if (name.isBlank() && name.isEmpty()) {
         System.out.println("Please enter a valid string name containing characters");
        }
        else
        {
          return name;
        }
      } catch (Exception e) {
        System.out.println(
            "An exception occured :" + e.getMessage() + "please enter a valid string name");
      }
    }
  }
}
