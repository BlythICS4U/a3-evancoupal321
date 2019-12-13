/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.*;

/**
 *
 * @author Evan
 */
public abstract class AbstractReportCardParser implements IReportCardParser
{
    private String filePath;
    
    public AbstractReportCardParser(String filePath)
    {
        this.filePath = filePath;
    }
    
    @Override
    public ReportCard parse()
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(filePath));
            return parse(br);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace(System.out);
        }
        finally
        {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace(System.out);
            }
        }
        return null;
    }
    abstract ReportCard parse(BufferedReader br);
}
