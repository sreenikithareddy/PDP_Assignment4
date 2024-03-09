package com.controller.features;

import com.controller.input.AcceptInput;
import com.model.Model;
import com.view.IView;
import java.io.File;
import java.util.Scanner;

public abstract class AbstractFeature extends AcceptInput implements IFeature {

  protected Scanner scanner;

  protected Model model;

  protected IView view;

  public AbstractFeature(Model model, IView view, Scanner scanner) {
    this.model = model;
    this.view = view;
    this.scanner = scanner;
  }

  protected Boolean checkPortfolioDirectoryExists() {
    String directoryPath = "./portfolios";
    File portfolioDiretory = new File(directoryPath);
    return portfolioDiretory.exists();
  }

  protected Boolean checkPortfolioFileExists(String portfolioName) {
    String directoryPath = "./portfolios";
    File portfolioFile = new File(directoryPath, portfolioName + ".csv");
    return portfolioFile.exists();
  }

  protected String acceptPortfolioName(boolean isCreate) {
    while (true) {
      try {
        System.out.println("Please enter a name for the portfolio: ");
        String name = scanner.nextLine();

        // Check if the input string is blank or empty
        if (name.isBlank()) {
          System.out.println("Please enter a valid string name containing characters.");
          continue;
        }

        // Handling cases when the portfolio directory exists
        if (checkPortfolioDirectoryExists()) {
          boolean portfolioExists = checkPortfolioFileExists(name);

          if (isCreate) {
            if (portfolioExists) {
              System.out.println("File Name " + name
                  + " already exists. Please enter a new name for the portfolio:");
            } else {
              return name;
            }
          } else {
            if (portfolioExists) {
              return name;
            } else {
              System.out.println("There is no portfolio with the given name " + name
                  + ", please enter an existing portfolio name from the list.");
            }
          }
        } else {
          // Handling cases when the portfolio directory does not exist
          if (isCreate) {
            return name;
          } else {
            System.out.println(
                "No portfolios exist to fetch the required data. Please create a new portfolio.");
            return null;
          }
        }
      } catch (Exception e) {
        System.out.println(
            "An exception occurred: " + e.getMessage() + ". Please enter a valid string name.");
      }
    }
  }
}
