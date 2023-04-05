/* M0_Lab1.java
 * This program practices working with JOptionPane and importing an image into the
 * JOptionPane dialog box. This program will choose a random activity and location
 * in the Carribean islands and display the end result to the user. The user can
 * continue to randomize the two options until they are satisfied.
 * Benedict Lee
 * 13 June 2022
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

public class ChooseAPrize 
{
    public static void main(String[] args) 
    {
        String[] islands = { "Bermuda", "Bahama", "Jamaica", "Aruba", 
                        "Martinique", "Antigua" };
        
        String[] activities = {"parasailing","surfing", "snorkeling", 
                        "DeepSeaFishing", "sailBoarding", "sharkSpotting", 
                        "JetSkiing","scubaing", "shipwreck"};
        
        String introductoryImageFile = "icons/prizedraw.jpeg";
        ImageIcon icon = new ImageIcon(introductoryImageFile);
        
        String introduction = "<html>This program will randomly generate a grand prize "
                + "<br>that includes a free trip to the Carribeans alongside<br> a two "
                + "day pass for one activity that is available on<br>the island.<br><br>"
                + "Select \"OK\" to continue";
        
        JOptionPane.showMessageDialog(null, introduction, "RANDOM PRIZE SELECTOR, "
                + "CREATED BY BENEDICT LEE", 0, icon);
        
        Random randomGenerator = new Random();
        int choice = 0; 
        
        while(choice==0)
        {
        int islandsIndex = randomGenerator.nextInt(islands.length);
        int activityIndex = randomGenerator.nextInt(activities.length);    
        
        String activityFile = "icons/"+activities[activityIndex]+".png";
        File iconFile = new File(activityFile);
        
        if (!iconFile.exists())
        {
            System.out.println("\nCannot see the file - "+activityFile);
        } else
        {
            System.out.println("Can see the file - "+activityFile);
        }
        
        String[] prizeResultOptions = {"Get Another Trip!", "Quit"};
        
        icon = new ImageIcon(activityFile);
        String text = "\n<html><h1> on "+islands[islandsIndex]+"</h1>";
        
        choice = JOptionPane.showOptionDialog(null, text, "Your Prize presented "
                + "by Benedict", 0, 1, icon, prizeResultOptions, prizeResultOptions[0]);
        }
        
        String endMessage = "<html>Thank you for your participation!<br>"
                + "Enjoy your prize!<br><br>This program will now exit.";
        String endImage = "icons/Trip.png";
        icon = new ImageIcon(endImage);
        JOptionPane.showMessageDialog(null, endMessage, "Congratulations!", 0, icon);
                
    }
    
}
