public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    private boolean isP1AndP2Equal = P1point == P2point;
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public String getScore(){
        String score = "";

        if(isP1AndP2Equal) {
            score =  getScoreWhenPointsAreEquals(P1point);
        }

        if(isGreaterThanZero(P1point, P2point)) {
            String[] resp = getResponseWHenPoint1orPoint2GreaterThanZero(P1point, P2point,P1res, P2res, score);
            P1res = resp[0];
            P2res = resp[1];
            score = resp[2];
        }

        if(isPoint1OrPoint2GreaterThan4(P1point, P2point)) {
            String[] res = getResponseAndScoreWhenP1orP2LessThanFour(P1point,P2point,P1res,P2res, score);
            P1res = res[0];
            P2res = res[1];
            score = res[2];
        }

        if( isP1GreaterThanP2AndP2GreatherThan3OrP2GreaterThanP1AndP1GreaterThan3(P1point, P2point)) {
            score = getScoreWhenPointGreaterOrEqualThan3(P1point, P2point);
        }

        if(isPGreaterThan4AndSubtractP1AndP2GreaterThan2(P1point, P2point) ) {
            score = getScoreWhenPointGreaterOrEqualThan4(P1point, P2point);
        }
        return score;
    }

    private String getScoreWhenScoreIsEqualAndP1LessToFour(int p1) {
        if (p1==0)
            return "Love-All";
        if (p1==1)
            return "Fifteen-All";

        return "Thirty-All";
    }

    private String[] getResponseWhenP1GreaterThanZeroAndP2EqualsToZero(int p1) {
        switch (p1) {
            case 1:
                return new String[]{"Fifteen", "Love"};
            case 2:
                return new String[]{"Thirty", "Love"};
            case 3:
                return new String[]{"Forty", "Love"};
            default:
                return new String[]{"", "Love"};
        }
    }

    private String[] getResponseWhenP1GreaterThanP2AndLessThanZero(int point1, int point2, String res1, String res2 ) {
        if (point1 == 2)
            res1 = "Thirty";
        if (point1 == 3)
            res1 = "Forty";
        if (point2 == 1)
            res2 = "Fifteen";
        if (point2 == 2)
            res2 = "Thirty";
        return new String[]{res1, res2};
    }

    private String getScoreWhenPointsAreEquals(int p1point) {
        if(p1point >= 3) {
            return "Deuce";
        }
        return getScoreWhenScoreIsEqualAndP1LessToFour(P1point);
    }

    private String[] getResponseWHenPoint1orPoint2GreaterThanZero(int p1point, int p2point, String p1res, String p2res, String score) {
        if (p2point == 0 ) {
            String[] pires = getResponseWhenP1GreaterThanZeroAndP2EqualsToZero(p1point);
            return new String[]{pires[0], pires[1], pires[0] + "-" + pires[1]};
        }
        if (p1point == 0 ) {
            String[] pires = getResponseWhenP1GreaterThanZeroAndP2EqualsToZero(p2point);
            return new String[] {pires[1], pires[0],pires[1] + "-" + pires[0] };
        }
        return new String[] { p1res, p2res, score };
    }

    private String[] getResponseAndScoreWhenP1orP2LessThanFour(int p1point, int p2point, String p1res, String p2res, String score) {
        if (p1point > p2point)
        {
            String[] listRes = getResponseWhenP1GreaterThanP2AndLessThanZero(p1point, p2point, p1res, p2res);
            return new String[]{listRes[0], listRes[1], listRes[0] + "-" + listRes[1] };
        }
        if(p2point > p1point) {
            String[] listRes = getResponseWhenP1GreaterThanP2AndLessThanZero(p2point, p1point, p2res, p1res);
            return new String[]{listRes[1], listRes[0], listRes[1] + "-" + listRes[0] };
        }
        return new String[] { p1res, p2res, score };
    }

    private String getScoreWhenPointGreaterOrEqualThan3(int p1point, int p2point) {
        if (p1point > p2point ) {
            return "Advantage player1";
        }
        return  "Advantage player2";
    }

    private String getScoreWhenPointGreaterOrEqualThan4(int p1point, int p2point) {
        if (p1point>=4 && p2point>=0 && (p1point-p2point)>=2) {
            return "Win for player1";
        }
        return  "Win for player2";
    }

    private boolean isP1GreaterThanP2AndP2GreatherThan3OrP2GreaterThanP1AndP1GreaterThan3(int p1point, int p2point) {
        return p1point > p2point && p2point >= 3 || p2point > p1point &&  p1point >= 3;
    }

    private boolean isSubstractGreatherThan2(int p1point, int p2point) {
        return ( p1point>=4 && p2point>=0 && (p1point-p2point)>=2);
    }

    private boolean isPGreaterThan4AndSubtractP1AndP2GreaterThan2(int p1point, int p2point) {
        return isSubstractGreatherThan2(P1point, P2point) || isSubstractGreatherThan2(P2point, P1point);
    }

    private boolean isPoint1OrPoint2GreaterThan4(int p1point, int p2point) {
        return p1point < 4 || p2point < 4;
    }

    private boolean isGreaterThanZero(int p1point, int p2point) {
        return p1point > 0 || p2point > 0;
    }

    public void SetP1Score(int number){
        for (int i = 0; i < number; i++) {
            P1Score();
        }
    }

    public void SetP2Score(int number){
        for (int i = 0; i < number; i++) {
            P2Score();
        }
    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    @Override
    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}