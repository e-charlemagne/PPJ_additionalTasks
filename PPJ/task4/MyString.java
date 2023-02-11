package task4;

public class MyString {
    private String str;

    public MyString() {
        str = "";
    }
    public MyString(String s){
        str = s;
    }
    public int getLength(){
        return str.length();
    }
    public char getChar(int n){
        if (n < 0 || n >=str.length()){
            throw new IllegalArgumentException("Invalid index: " + n);
        }
        return  str.charAt(n);
    }
    public void append(String s){
        str+=s;
    }
    public void append(int repetition ,String s){
        for(int i = 0 ; i < repetition ; i++){
            str+=s;
        }
    }
    public void prepend(String s){
        str = s+ str;
    }
    public void insert(int pos, String s){
        if (pos< 0 || pos> str.length()){
            throw new IllegalArgumentException("Invalid position: " + pos);
        }
        str = str.substring(0,pos) + s + str.substring(pos);
    }
    public void reset (String s){
        str = s;
    }
    @Override
    public String toString(){
        return str;
    }

    public static void main(String[] args) {
        MyString s = new MyString("Hello");
        System.out.println(s.getLength());
        System.out.println(s.getChar(1));

        s.append(" World!");
        System.out.println(s.toString());


        s.append(2, "!");
        System.out.println(s.toString());


        s.prepend("Hey, ");
        System.out.println(s.toString());


        s.insert(5, "my ");
        System.out.println(s.toString());


        s.reset("Bye!");
        System.out.println(s.toString());


// IllegalArgumentException
        s.getChar(10);
        s.insert(-1, "test");
        s.insert(100, "test");

        s.insert(3,"Inserted");
        System.out.println(s.toString());
    }
}
