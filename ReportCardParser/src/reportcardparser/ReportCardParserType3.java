/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.*;
import java.util.*;
/**
 * Class to handle parsing of a Type 3 report card
 * 
 * @author chris
 */
public class ReportCardParserType3 extends AbstractReportCardParser {

    /**
     * Constructor
     * 
     * @param filePath Path to the report card file
     */
    public ReportCardParserType3(String filePath) {
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
            //Declare Variables
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
            
            currentLine = br.readLine(); //Date of Birth line
            st = new StringTokenizer(currentLine);
            st.nextToken(); //Skips "Date of Birth:" tokens
            st.nextToken();
            st.nextToken();
            dob = st.nextToken(); //Sets date of birth
            
            br.readLine(); //Blank line
            
            //More variables for mark parsing
            CourseMark[] marks = new CourseMark[8]; //Array of course marks
            String[] courseName = br.readLine().split("\\t+"); //Array of course names
            String[] markLine = br.readLine().split("\\t+"); //Array of string marks
            int[] mark = new int[8]; //Array of integer marks
            int total = 0; //Total, for average
            for (int i = 0; i < 8; i++)
            {
                mark[i] = Integer.parseInt(markLine[i]); //Convert string mark to integer mark
                total += mark[i]; //Add mark to total
                marks[i] = new CourseMark(courseName[i], mark[i]); //Add CourseMark to the array using the parsed values
            }
            double average = (double)total / marks.length; //Calculate average
            return new ReportCard(name, dob, marks, average); //Return finished report card
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace(System.out);
            }
        }
        return null;
    }

}
