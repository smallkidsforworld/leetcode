import javax.xml.bind.SchemaOutputResolver;

public class d925 {
    public static boolean isLongPressedName(String name, String typed) {
        int left = 0, right = 0, flag = 0;
        while (left < name.length() && right < typed.length()) {
            if (name.charAt(left) == typed.charAt(right)) {
                right++;
                left++;
            } else {
                if (name.charAt(left - 1) == typed.charAt(right))
                    right++;
                else
                    return false;
            }
        }
        while (right < typed.length())
            if (name.charAt(left - 1) == typed.charAt(right))
                right++;
        if (left == name.length() && right == typed.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("vtkgn", "vttkgnn"));
    }
}