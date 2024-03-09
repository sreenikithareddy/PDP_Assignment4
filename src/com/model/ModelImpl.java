package com.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class ModelImpl implements Model {

  @Override
  public void createPortfolio(Map<String, Integer> stockMap, String portfolioName,Map<String,String> tickerMap)
      throws IOException {
    String directoryPath = "./portfolios";
    File portfolioDirectory = new File(directoryPath);
    if(!portfolioDirectory.exists())
    {
      boolean directoryCreated = portfolioDirectory.mkdir();
      if (!directoryCreated) {
        throw new IOException("Failed to create the directory: " + directoryPath);
      }
    }
    File portfolioFile = new File(portfolioDirectory,portfolioName + ".csv");

    try (FileWriter csvWriter = new FileWriter(portfolioFile, true)) {
      csvWriter.append("Portfolio: ").append(portfolioName).append("\n");

      for (Map.Entry<String, Integer> stock : stockMap.entrySet()) {
        //tickersymbol
        csvWriter.append(stock.getKey()).append(",");
        // company
        csvWriter.append(tickerMap.get(stock.getKey())).append(",");
        //total number of shares
        csvWriter.append(stock.getValue().toString()).append("\n");
      }

      csvWriter.append("\n");
      //encrypt the file here
    }

    catch (IOException e){
      System.out.println("Cannot be written into the file");
    }

  }

  // total evaluation
  @Override
  public Float getPortfolioValuation(String portfolioName, Date date) {
    //
    return null;
  }

  // examine portfolio
  @Override
  public Portfolio fetchPortfolio(String portfolioName) {
    // decrypt
    // fetch the details
    // give it to view
    return null;
  }


}
