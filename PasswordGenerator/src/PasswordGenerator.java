public class PasswordGenerator {
    private String[] words;
    private int[] numbers;
    private char[] letters;
    public PasswordGenerator(String[] words, int[] numbers){
        this.words = words;
        this.numbers = numbers;
    }
    public PasswordGenerator(char[] letters, int[] numbers){
        this.letters = letters;
        this.numbers = numbers;
    }
    public String GeneratePass(int numWordsorLetters, int numNumb){
        int num;
        String password = "";
        int indexNum;
        int indexLetter;
        int count = 0;
        int numTimesLetter = 0;
        int numTimesNumber = 0;
        int numTimesWord = 0;
        int indexWord;
        if (this.letters != null){
            while (count < numWordsorLetters+numNumb){
                num = (int)(Math.random()*2) + 1;
                if (num == 1){
                    if (numTimesLetter < numWordsorLetters){
                        indexLetter = (int)(Math.random()*letters.length);
                        password += letters[indexLetter];
                        count++;
                        numTimesLetter++;
                    }
                }
                if (num == 2){
                    if (numTimesNumber < numNumb){
                        indexNum = (int)(Math.random()*numbers.length);
                        password += numbers[indexNum];
                        count++;
                        numTimesNumber++;
                    }
                }
            }
        }
        else{
            while (count < numWordsorLetters+numNumb){
                num = (int)(Math.random()*2) + 1;
                if (num == 1){
                    if (numTimesWord < numWordsorLetters){
                        indexWord = (int)(Math.random()*words.length);
                        password += words[indexWord];
                        count++;
                        numTimesWord++;
                    }
                }
                if (num == 2){
                    if (numTimesNumber < numNumb){
                        indexNum = (int)(Math.random()*numbers.length);
                        password += numbers[indexNum];
                        count++;
                        numTimesNumber++;
                    }
                }
            }
        }
        
        return password;
    }

}
