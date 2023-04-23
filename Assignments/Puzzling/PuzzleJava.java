import java.util.Random;
public class PuzzleJava {
    public int[] getTenRolls(){
        int[] myArray;
        myArray = new int[10];
        Random random = new Random();

        for(int i = 0; i <10;i++){
            myArray[i]=random.nextInt(20) + 1;
        }
        return myArray;
    }

    public char getRandomLetter(){
        char[] myArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Random random = new Random();
        int randomNumber = random.nextInt(26);
        char c =myArray[randomNumber];
        return c;
    }

    public String generatePassword(){
        String password = new String();
        for(int i = 0;i<8;i++) {
            password = password+this.getRandomLetter();
        }
        return password;
    }

    public String[] getNewPasswordSet(int len){
        String[] myArray;
        myArray = new String[len];
        for (int i=0;i<len;i++){
            myArray[i]=this.generatePassword();
        }
        return myArray;
    }
}