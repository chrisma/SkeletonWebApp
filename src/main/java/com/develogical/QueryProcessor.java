package com.develogical;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    if (query.toLowerCase().contains("what is your name")) {
      return "Christoph";
    }

    if (query.toLowerCase().contains("which of the following numbers is the largest")) {
      // Create a pattern to match the numbers at the end
      Pattern pattern = Pattern.compile("\\d+");
        
      // Create a matcher with the input string
      Matcher matcher = pattern.matcher(query);
      
      int largestNumber = Integer.MIN_VALUE; // Initialize with the smallest possible integer value
      
      // Find the largest number
      while (matcher.find()) {
          int number = Integer.parseInt(matcher.group());
          if (number > largestNumber) {
              largestNumber = number;
          }
      }
      return Integer.toString(largestNumber);
    }

    if (query.toLowerCase().contains("multiplied by")) {
      // Create a pattern to match the numbers
      Pattern pattern = Pattern.compile("\\d+");
        
      // Create a matcher with the input string
      Matcher matcher = pattern.matcher(query);
      
      int firstNumber = 0;
      int secondNumber = 0;
      
      // Find the first two numbers
      if (matcher.find()) {
          firstNumber = Integer.parseInt(matcher.group());
      }
      if (matcher.find()) {
          secondNumber = Integer.parseInt(matcher.group());
      }
      
      int result = firstNumber * secondNumber;
      return Integer.toString(result);
    }

    return "";
  }
}
