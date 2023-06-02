package SystemUtil;

public class LCS_Helper {
    public String stringA;
    public String stringB;
    private static char[] chars_1;
    private static char[] chars_2;
    public static int[][] lcs;
    private int symbolNum=0;

    public LCS_Helper(String stringA, String stringB) {
        this.stringA = stringA;
        this.stringB = stringB;
        chars_1 = stringA.toCharArray();
        chars_2 = stringB.toCharArray();
        lcs = new int[stringA.length() + 1][stringB.length() + 1];
    }

    // 获取与A字符串的相似度
    public double GetSimilarity() {
        return (double) Get_LCS_Length() / (double) (stringA.length() - symbolNum);
    }

    // 获得两个字符串的最大子序列长度
    public int Get_LCS_Length() {
        for (int i = 0; i <= stringA.length(); i++)
            lcs[i][0] = 0;
        for (int j = 0; j <= stringB.length(); j++)
            lcs[0][j] = 0;
        for (int i = 0; i < stringA.length(); i++) {
            for (int j = 0; j < stringB.length(); j++) {
                if (chars_1[i] == chars_2[j])
                    lcs[i + 1][j + 1] = lcs[i][j] + IsSymbol(chars_1[i]);
                else
                    lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
            }
        }
        return lcs[stringA.length()][stringB.length()];
    }

    // 是符号返回0，否则返回1
    private int IsSymbol(char c) {
        final char[] symbols = {
                '，', '。', '？', '！', '：', '；', '…', '“', '”',
                ',', '.', '?', '!', ':', ';', '\'', '\"'
        };
        for (char symbol : symbols) {
            if (c == symbol) {
                symbolNum++;
                return 0;
            }
        }
        return 1;
    }
}
