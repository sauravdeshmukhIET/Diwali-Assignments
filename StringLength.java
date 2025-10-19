package MaxLength;

public class StringLength {

    public static void main(String[] args) {
        String[] words = {"CdacActs","DacCourse","IETinstituteForDAC"};

        int maxLength = findLongestLength(words);

        System.out.println("The length of the longest string is: " + maxLength);
    }
    public static int findLongestLength(String[] arr) {
        int max = 0;

        for (String str : arr) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        return max;
    }
}
