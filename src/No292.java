/**
 * @author JJ
 * @date 2020/8/5 - 16:34
 */
public class No292 {

    /**
     * 一个找规律的题，挺有意思的：
     * 当我拿完还剩1、2、3个时，必败，故我拿前有4个时必败，
     * 所以只要在我拿前有5、6、7个时，就可以必胜
     * （5个时拿走一个，6拿2，7拿3，使对手转入拿前4个的必败状态），
     * 所以我拿前还有8个时必败（使对手转入必胜的拿前5、6、7状态）... ...
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {

        if(n%4==0){
            return false;
        }else{
            return true;
        }
    }
}
