public class StringProcessing {
    public static String addCommasToNumericString(String digits){StringBuilder s=new StringBuilder();int first=digits.length()%3;if(first==0)first=3;s.append(digits.substring(0,first));for(int i=first;i<digits.length();i+=3)s.append(',').append(digits.substring(i,Math.min(i+3,digits.length())));return s.toString();}
    public static String removeAllOccurrences(String str,char ch){StringBuilder s=new StringBuilder();for(char c:str.toCharArray())if(c!=ch)s.append(c);return s.toString();}
}
