public class TennisGame3 implements TennisGame {
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (isPGreaterThan4AndNotEqualTo6(p1, p2)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            return getScoreWhenP1EqualThanP2(p1,p2,p[p1],p[p2]);
        }
        if (p1 == p2) return "Deuce";

        return getScoreWhenP1LessP2EqualToOne(p1, p2, getStringScore(p1, p2));
    }

    private String getScoreWhenP1EqualThanP2(int p1, int p2, String s, String p) {
        return (p1 == p2) ? s + "-All" : s + "-" + p;
    }

    private String getScoreWhenP1LessP2EqualToOne(int p1, int p2, String s) {
        return ((subtractPoints(p1,p2)) * subtractPoints(p1,p2) == 1) ? "Advantage " + s : "Win for " + s;
    }

    private int subtractPoints(int p1, int p2) {
        return p1 - p2;
    }

    private boolean isPGreaterThan4AndNotEqualTo6(int p1, int p2) {
        return (isGreaterThanFour(p1,p2)) && (p1 + p2 != 6);
    }

    private boolean isGreaterThanFour(int p1, int p2) {
        return p1 < 4 && p2 < 4;
    }

    private String getStringScore(int p1, int p2) {
        return p1 > p2 ? p1N : p2N;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
    }
}
