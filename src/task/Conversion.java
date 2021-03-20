package task;

public class Conversion {

    public static String convert(String s) {
        int numbers;
        char[] array = s.toCharArray();
        StringBuilder body = new StringBuilder();
        int bodyStart;

        while (s.contains("[")) {
            bodyStart = s.indexOf('[');
            numbers = Integer.parseInt(s.substring(0, bodyStart));
            for (int i = bodyStart + 1; i < array.length; i++) {
                if (Character.isDigit(array[i])) {
                    String result = convert(s.substring(i, s.length() - 1));
                    while (numbers > 0) {
                        body.append(result);
                        numbers--;
                    }
                    s = "";
                    break;
                }
                if (array[i] == ']') {
                    StringBuilder builder = new StringBuilder();
                    String subBody = s.substring(bodyStart + 1, i);
                    while (numbers > 0) {
                        builder.append(subBody);
                        numbers--;
                    }
                    body.append(builder.toString());
                    s = s.substring(i + 1);
                    array = s.toCharArray();
                    break;
                }
            }

        }
        body.append(s);
        return body.toString();
    }


    public static String convertA(String s) {
        String numbersStr;
        String body;
        int bodyStart;
        int bodyEnd;
        if (s.contains("[")) {

            bodyStart = s.indexOf('[');
            bodyEnd = s.lastIndexOf(']');
            numbersStr = s.substring(0, bodyStart);
            body = s.substring(bodyStart + 1, bodyEnd);
            body = convert(body);
        } else {
            return s;
        }
        int numbers = Integer.parseInt(numbersStr);
        StringBuilder builder = new StringBuilder();
        builder.append(body.repeat(Math.max(0, numbers)));
        if (bodyEnd != s.length() - 1) {
            builder.append(s.substring(bodyEnd + 1));
        }
        return builder.toString();
    }
}
