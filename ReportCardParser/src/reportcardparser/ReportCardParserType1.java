/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.*;
import java.util.*;
/**
 * Class to handle parsing of a Type 1 report card
 * 
 * @author chris
 */
public class ReportCardParserType1 extends AbstractReportCardParser {


    /**
     * Constructor
     * 
     * @param filePath Path to the report card file
     */
    public ReportCardParserType1(String filePath) {
        super(filePath);
    }

    /**
     * Parse the configured report card file
     * 
     * @param br BufferedReader to read the file
     * @return ReportCard object containing the data from the configured report card file
     */
    @Override
    public ReportCard parse(BufferedReader br) {
        try
        {
            //Declare variables
            String name = "", dob; //Student's name and date of birth
            
            String currentLine = br.readLine(); //Name line
            StringTokenizer st = new StringTokenizer(currentLine);
            st.nextToken(); //Skips "Name:" token
            while (st.hasMoreTokens()) //Adds remaining tokens as student's name
            {
                name += st.nextToken();
                name += " ";
            }
            name = name.trim();
            
            currentLine = br.readLine(); //Date of birth line
            st = new StringTokenizer(currentLine);
            st.nextToken(); //Skips "DOB:" token
            dob = st.nextToken(); //Sets DOB
            
            currentLine = br.readLine(); //Blank line
            
            //More variable for mark parsing
            int total = 0; //Total, for average
            CourseMark[] marks = new CourseMark[8]; //Array of course marks
            String[] courseName = new String[8]; //Array of course names
            int[] mark = new int[8]; //Array of marks
            String currentToken; //The current token
            
            for (int i = 0; i < 8; i++)
            {
                courseName[i] = "";
                currentLine = br.readLine(); //Reads line
                st = new StringTokenizer(currentLine);
                while(true)
                {
                    currentToken = st.nextToken(); //Reads token
                    try
                    {
                        mark[i] = Integer.parseInt(currentToken); //If the token is a number, set the mark and break
                        break;
                    }
                    catch (NumberFormatException nfe) //If not, move to here and add the token to the course name
                    {
                        courseName[i] += currentToken;
                        courseName[i] += " ";
                    }
                }
                courseName[i] = courseName[i].trim();
                marks[i] = new CourseMark(courseName[i], mark[i]); //Add CourseMark to the array using the parsed values
                total += mark[i]; //Add the mark to the total
            }
            
            double average = (double) total / marks.length; //Calculate average
            return new ReportCard(name, dob, marks, average); //Return finished report card
            
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace(System.out);
        }
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        return null;
    }
    
}
