/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srrrillumination;
//java.util.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Logan
 */
public class YScanner {
    String grammarReader (File filename) throws FileNotFoundException{
        String s = "";
        Scanner scanner = new Scanner(filename);
        while(scanner.hasNextLine()){
            final String key = scanner.nextLine();
            if(key.contains("Grammar")){
                while(scanner.hasNextLine()){
                    String temp = scanner.nextLine();
                    if(!(temp.contains("Terminals,"))){
                    s = s + temp + "\n";
                    }
                    else{
                        break;
                    }
                
                }
                break;
            }
        }       
                
                
                
      return s;
    }
    String conflictFinder (File filename) throws FileNotFoundException{
        String s= "";
        Scanner scanner = new Scanner(filename);
        while(scanner.hasNextLine()){
            String key = scanner.nextLine();
            if(key.matches("^State [0-9]+conflicts.*")){
                Pattern state = Pattern.compile("^State [0-9]+");
                Matcher matcher = state.matcher(key);
                if(matcher.find()){
                    key = matcher.group(0);
                }
                while(scanner.hasNextLine()){
                    //System.out.println(key);
                    String temp = scanner.nextLine();
                    if(temp.matches( key)){
                    s=s + temp + "\n";
                    scanner.nextLine();
                    while(scanner.hasNextLine()){
                              String temp1 = scanner.nextLine();
                        if(!(temp.contains("State"))){
                            s=s+temp1 + "\n";
                        }
                        else{
                            break;
                        }
                    }
                    
                    
                    }
                    
                
                }
                break;
            }
        }       
        
        
        
        return s;
    }
}
