/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class for analyzing collections of report cards
 * 
 * @author chris
 */
public class ReportCardStats {
    
    /**
     * Find the student with the highest average
     * 
     * @param reportCards The array of report cards to search
     * @return The name of the student with the highest average
     */
    public static String GetBestStudent(ReportCard[] reportCards) {
        int best = 0;
        for (int i = 0; i < reportCards.length; i++)
        {
            if (reportCards[i] != null)
            {
                if (reportCards[i].getAverage() >= reportCards[best].getAverage())
                {
                    best = i;
                }
            }
        }
        return reportCards[best].getName();
    }
    
    /**
     * Find the best subject for the given report card
     * 
     * @param reportCard The report card to evaluate
     * @return The name of the subject with the highest mark
     */
    public static String GetBestSubject(ReportCard reportCard) {
        int best = 0;
        CourseMark[] marks = reportCard.getMarks();
        for (int i = 0; i < 8; i++)
        {
            if (marks[i].getMark() >= marks[best].getMark())
            {
                best = i;
            }
        }
        return marks[best].getName();
    }
    
    /**
     * Calculate the average mark for a given subject
     * 
     * @param reportCards The array of report cards to search
     * @param subject The subject for average calculation
     * @return The average mark of the passed-in subject
     */
    public static double SubjectAverage(ReportCard[] reportCards, String subject) {
        int subjectNum = -1;
        for (int i = 0; i < 8; i++)
        {
            if (reportCards[0].getMarks()[i].getName().equals(subject))
            {
                subjectNum = i;
                break;
            }
        }
        int total = 0;
        for (int i = 0; i < reportCards.length; i++)
        {
            total += reportCards[i].getMarks()[subjectNum].getMark();
        }
        double average = (double)total / reportCards.length;
        return average;
    }
}
