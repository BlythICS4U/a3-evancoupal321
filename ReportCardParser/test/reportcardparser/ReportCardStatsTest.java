/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class ReportCardStatsTest {

        IReportCardParser[] reportCardParsers = {
        new ReportCardParserType1("ReportCardsWindows/ReportType1_1.txt"),
        new ReportCardParserType1("ReportCardsWindows/ReportType1_2.txt"),
        new ReportCardParserType1("ReportCardsWindows/ReportType1_3.txt"),
        new ReportCardParserType2("ReportCardsWindows/ReportType2_1.txt"),
        new ReportCardParserType2("ReportCardsWindows/ReportType2_2.txt"),
        new ReportCardParserType2("ReportCardsWindows/ReportType2_3.txt"),
        new ReportCardParserType3("ReportCardsWindows/ReportType3_1.txt"),
        new ReportCardParserType3("ReportCardsWindows/ReportType3_2.txt"),
        new ReportCardParserType3("ReportCardsWindows/ReportType3_3.txt")
        };
    /**
     * Test of GetBestStudent method, of class ReportCardStats.
     */
    @Test
    public void testGetBestStudent()
    {
        String result;
        ReportCard[] reportCards = new ReportCard[reportCardParsers.length];
        for (int i = 0; i < reportCardParsers.length; i++) {
            reportCards[i] = reportCardParsers[i].parse();
            result = ReportCardStats.GetBestStudent(reportCards);
            if (i < 1)
            {
                assertEquals(reportCards[0].getName(), result);
            }
            else if (i < 3)
            {
                assertEquals(reportCards[1].getName(), result);
            }
            else if (i < 6)
            {
                assertEquals(reportCards[3].getName(), result);
            }
            else if (i < 8)
            {
                assertEquals(reportCards[6].getName(), result);
            }
            else
            {
                assertEquals(reportCards[8].getName(), result);
            }
        }
    }

    /**
     * Test of GetBestSubject method, of class ReportCardStats.
     */
    @Test
    public void testGetBestSubject()
    {
        String result;
        ReportCard[] reportCards = new ReportCard[reportCardParsers.length];
        for (int i = 0; i < reportCardParsers.length; i++) {
            reportCards[i] = reportCardParsers[i].parse();
            result = ReportCardStats.GetBestSubject(reportCards[i]);
            switch (i)
            {
                case 0:
                    assertEquals(reportCards[i].getMarks()[2].getName(), result);
                    break;
                case 1:
                    assertEquals(reportCards[i].getMarks()[5].getName(), result);
                    break;
                case 2:
                    assertEquals(reportCards[i].getMarks()[0].getName(), result);
                    break;
                case 3:
                    assertEquals(reportCards[i].getMarks()[1].getName(), result);
                    break;
                case 4:
                    assertEquals(reportCards[i].getMarks()[7].getName(), result);
                    break;
                case 5:
                    assertEquals(reportCards[i].getMarks()[6].getName(), result);
                    break;
                case 6:
                    assertEquals(reportCards[i].getMarks()[1].getName(), result);
                    break;
                case 7:
                    assertEquals(reportCards[i].getMarks()[5].getName(), result);
                    break;
                case 8:
                    assertEquals(reportCards[i].getMarks()[2].getName(), result);
                    break;
                    
            }
        }
        
    }

    /**
     * Test of SubjectAverage method, of class ReportCardStats.
     */
    @Test
    public void testSubjectAverage()
    {
        double result;
        ReportCard[] reportCards = new ReportCard[reportCardParsers.length];
        for (int i = 0; i < reportCardParsers.length; i++) {
            reportCards[i] = reportCardParsers[i].parse();
        }
        result = ReportCardStats.SubjectAverage(reportCards, "Business Studies"); //CALCULATE MYSELF w/ CALCULATOR
        assertEquals(81.55555555555556, result, 0.0);
        result = ReportCardStats.SubjectAverage(reportCards, "Principles of Mathematics");
        assertEquals(80.77777777777777, result, 0.0);
        result = ReportCardStats.SubjectAverage(reportCards, "Chemistry");
        assertEquals(80.88888888888889, result, 0.0);
        result = ReportCardStats.SubjectAverage(reportCards, "Biology");
        assertEquals(78.33333333333333, result, 0.0);        
    }
}





