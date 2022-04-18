
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScoreByPoints(int tempScore, String scoreSpec) {
        switch(tempScore) {
            case 0:
                return scoreSpec.concat("Love");
            case 1:
                return scoreSpec.concat("Fifteen");
            case 2:
                return scoreSpec.concat("Thirty");
            default:
                return scoreSpec.concat("Forty");
        }
    }

    public String getScoreWhenScoreLessThanFour(int score1, int score2) {
        String score = "";
        int tempScore = 0;

        for (int i=1; i<3; i++) {
            if (i == 1) {
                tempScore = score1;
            } else {
                score = score.concat("-");
                tempScore = score2;
            }
            score = getScoreByPoints(tempScore, score);
        }
        return score;
    }

    public String getScoreWhenScoresGreaterThanFour(int score) {
        if (score >=2) return "Win for player1";
        switch (score) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return "Win for player2";
        }
    }

    private boolean isScoreGreaterThanFour(int score1, int score2) {
        return score1 >= 4 || score2 >= 4;
    }

    private String getScoreWhenScoresEquals(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return  "Deuce";
        }
    }

    private boolean isScoreEquals(int score1, int score2) {
        return  score1 == score2;
    }

    public String getScore() {
        if (isScoreEquals(m_score1, m_score2)) {
           return getScoreWhenScoresEquals(m_score1);
        }
        if (isScoreGreaterThanFour(m_score1,m_score2)) {
            return getScoreWhenScoresGreaterThanFour(m_score1 - m_score2);
        }
        return getScoreWhenScoreLessThanFour(m_score1, m_score2);
    }
}
