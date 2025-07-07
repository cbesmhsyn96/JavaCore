package letters;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Defines {
    protected static String []a = {
            "    *    ",
            "   * *   ",
            "  *   *  ",
            " * * * * ",
            "*       *"
    };

    protected static String []b ={
            "* * * * *  ",
            "*         *",
            "* * * * *  ",
            "*         *",
            "* * * * *  "
    };

    protected static String[] c = {
            " *********** ",
            " *           ",
            " *           ",
            " *           ",
            " *********** "
    };

    protected static String[] che = {
            " *********** ",
            " *           ",
            " *           ",
            " *********** ",
            "      **     "
    };


    protected static String[] d = {
            " ***********   ",
            " *           * ",
            " *           * ",
            " *           * ",
            " ***********   "
    };

    protected static String[] e = {
            " *********** ",
            " *           ",
            " ********    ",
            " *           ",
            " *********** "
    };

    protected static String[] f = {
            " *********** ",
            " *           ",
            " ********    ",
            " *           ",
            " *           "
    };

    protected static String[] g = {
            " *********** ",
            " *           ",
            " *********** ",
            " *         * ",
            " *********** "
    };

    protected static String[] softG = {
            "     ***     ",
            " *********** ",
            " *          ",
            " ***********",
            " *********** "
    };


    protected static String[] h = {
            " *         * ",
            " *         * ",
            " *********** ",
            " *         * ",
            " *         * "
    };

    protected static String[] i = {
            "    *****    ",
            "      *      ",
            "      *      ",
            "      *      ",
            "    *****    "
    };

    protected static String[] iLetter = {
            "      *      ",
            "    *****    ",
            "      *      ",
            "      *      ",
            "    *****    "
    };


    protected static String[] j = {
            "     *****   ",
            "       *     ",
            "       *     ",
            "  *    *     ",
            "   ****      "
    };

    protected static String[] k = {
            " *      *    ",
            " *    *      ",
            " ****        ",
            " *    *      ",
            " *      *    "
    };

    protected static String[] l = {
            " *           ",
            " *           ",
            " *           ",
            " *           ",
            " *********   "
    };

    protected static String[] m = {
            " *       *  ",
            " **     **  ",
            " * *   * *  ",
            " *  * *  *  ",
            " *   *   *  "
    };

    protected static String[] n = {
            " **       * ",
            " *  *     * ",
            " *    *   * ",
            " *     *  * ",
            " *       ** "
    };

    protected static String[] o = {
            "  *******  ",
            " *       * ",
            " *       * ",
            " *       * ",
            "  *******  "
    };

    protected static String[] oLetter = {
            "   *   *   ",
            "  *******  ",
            " *       * ",
            " *       * ",
            "  *******  "
    };

    protected static String[] p = {
            " ********  ",
            " *       * ",
            " ********  ",
            " *         ",
            " *         "
    };

    protected static String[] q = {
            "  *******  ",
            " *       * ",
            " *    *  * ",
            "   *****   ",
            "       *   "
    };

    protected static String[] r = {
            " ********  ",
            " *       * ",
            " ********  ",
            " *     *   ",
            " *      *  "
    };

    protected static String[] s = {
            "  ******** ",
            " *         ",
            "  *******  ",
            "         * ",
            " ********  "
    };

    protected static String[] she = {
            "  *******  ",
            "  *******  ",
            "         * ",
            "  *******  ",
            "    **     "
    };

    protected static String[] t = {
            " *********** ",
            "      *      ",
            "      *      ",
            "      *      ",
            "      *      "
    };

    protected static String[] u = {
            " *       * ",
            " *       * ",
            " *       * ",
            " *       * ",
            "  *******  "
    };

    protected static String[] uLetter = {
            " *       * ",
            "           ",
            " *       * ",
            " *       * ",
            "  *******  "
    };

    protected static String[] v = {
            " *       * ",
            " *       * ",
            "  *     *  ",
            "   *   *   ",
            "    ***    "
    };

    protected static String[] w = {
            " *       * ",
            " *   *   * ",
            " *  * *  * ",
            " * *   * * ",
            " *       * "
    };

    protected static String[] x = {
            " *       * ",
            "  *     *  ",
            "    * *    ",
            "  *     *  ",
            " *       * "
    };

    protected static String[] y = {
            " *     * ",
            "  *   *  ",
            "   ***   ",
            "    *    ",
            "    *    "
    };

    protected static String[] z = {
            " ********* ",
            "       *   ",
            "     *     ",
            "   *       ",
            " ********* "
    };

    protected static String[] whiteSpace = {
            "           ",
            "           ",
            "           ",
            "           ",
            "           ",
    };
    protected static HashMap<Character,String[]> stars = new HashMap<>();
    protected static Scanner scanner = new Scanner(System.in);
    protected static Pattern inputPattern = Pattern.compile("^[a-zışöüç\\s]+$");
}
