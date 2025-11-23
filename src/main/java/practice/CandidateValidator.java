package practice;

import model.Candidate;

import java.util.function.Predicate;


public class CandidateValidator implements Predicate<Candidate> {


    private static long calculateYears(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        if (years.length != 2) {
            return 0;
        }
        try {
            int startYear = Integer.parseInt(years[0].trim());
            int endYear = Integer.parseInt(years[1].trim());
            return endYear - startYear;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && calculateYears(candidate.getPeriodsInUkr()) >= 10;
    }
}
