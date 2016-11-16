import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
  public static void main(String[] args) {
    String message = "Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!";
		String message2 = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";

    System.out.println(messageConverter(message));
    System.out.println(messageConverter(message2));
  }

  public static String messageConverter(String message) {
    Pattern pattern = Pattern.compile("[a-z]");
    Matcher matcher;
    String decodedMessage = "";
    for (int i = 0;i < message.length(); i++) {
        matcher = pattern.matcher(Character.toString(message.charAt(i)));
        if(matcher.matches()) {
          String convertedLetter = charConverter(message.charAt(i));
          decodedMessage += convertedLetter;
        }else {
          decodedMessage += Character.toString(message.charAt(i));
        }
    }
    return decodedMessage;
  }

  public static String charConverter(char c) {
    int num = (int) c;
    num = 97 + (25 - (num - 97));
    c = (char) num;
    return Character.toString(c);
  }
}
