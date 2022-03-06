import java.util.Objects;

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
        if (Objects.equals(playerName, "player1")) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScoreWhenScoresEquals(int score) {
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

    public String getScoreWhenScoresOlderToFour(int score) {
        if (score >=2) return  "Win for player1";

        switch (score) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return "Win for player2";
        }
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

    public String getScoreWhenScoreLessToFour(int score1, int score2) {
        String score = "";
        int tempScore = 0;

        for (int i=1; i<3; i++) {
            if (i == 1) {
                tempScore = score1;
            } else {
                score += "-";
                tempScore = score2;
            }
            score = getScoreByPoints(tempScore, score);
        }
        return score;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
          return getScoreWhenScoresEquals(m_score1);
        }
        if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreWhenScoresOlderToFour(m_score1 - m_score2);
        }
        return getScoreWhenScoreLessToFour(m_score1, m_score2);
    }
}
