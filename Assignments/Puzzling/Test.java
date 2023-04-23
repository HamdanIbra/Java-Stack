public class Test {
    public static void main(String[] args) {
        PuzzleJava appTest = new PuzzleJava();
        System.out.println(appTest.getTenRolls());
        System.out.println(appTest.getRandomLetter());
        System.out.println(appTest.generatePassword());
        String[] array=appTest.getNewPasswordSet(5);
        for (String str : array) {
            System.out.println(str);
        }
    }
}