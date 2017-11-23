class Solution13 {
    public static int romanToInt(String s) {
int result=vas(s.charAt(0));
if (s==null)
    return -1;

for(int i=1;i<s.length();i++){
    int be=vas(s.charAt(i-1));
    int af=vas(s.charAt(i));
    if (be<af)
        result+=af-2*be;
    else
        result+=af;
}
return result;
    }
    public static int vas(char v ){
switch (v){
    case 'I' :return 1;
    case 'V' :return 5;
    case 'X' :return 10;
    case 'L' :return 50;
    case 'C' :return 100;
    case 'D' : return 500;
    case 'M' : return 1000;
}
return 0;
    }
    public static  void main(String...args){
        System.out.print(romanToInt("DCXXI"));
    }
}