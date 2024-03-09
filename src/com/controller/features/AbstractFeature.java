package com.controller.features;

import com.controller.input.AcceptInput;
import java.util.Scanner;

public abstract class AbstractFeature extends AcceptInput implements IFeature {
  protected Scanner scanner;
}
