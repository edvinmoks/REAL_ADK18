import java.io.*;
import java.lang.*;
import java.util.*;

public class Build{



    static String[] letters = {" ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};
    public static void main(String[] args){

      try {






        StringBuilder builder = new StringBuilder();
      //BufferedReader buf = new BufferedReader(new FileReader("tempdata.txt"));
      /*
      String testw = "ad";
      String testa = "ade";
      String testa2 = "adekvat";
      String testa3 = "adekvata";
      int testaintw = hashWord(testw);
      int testaint = hashWord(testa);
      int testaint2 = hashWord(testa);
      int testaint3 = hashWord(testa);
      System.out.println(testaintw);
      System.out.println(testaint);
      System.out.println(testaint2);
      System.out.println(testaint3);
*/
      BufferedReader reader = new BufferedReader(new FileReader("ut.txt"));
      BufferedWriter writerWordList = new BufferedWriter(new FileWriter(new File("wordList.txt")));
      ArrayList<String> wordList = new ArrayList<String>();
      HashMap<String,String> hm = new HashMap<String,String>();
      Properties properties = new Properties();


            //System.out.println("line: " + line);


      int indexCounter = 0;
      long wordCount = 0;


      String tempLine = "";
      String prevWord = "";

      String line = reader.readLine(); //Reads first line from arrayIndex
      String[] word = line.split(" ");
      //writer.write(word+" "+Integer.toString(indexCounter));
      while(line != null){
        indexCounter++;

        //String[] tempWord = line.split(" ");
        if(word[0].equals(prevWord)){ //Checks if current word is the same as the previous word
          wordCount++;
          }

        else{

            //System.out.println("tempword: " + tempWord[0]);
            String firstThree = word[0].substring(0,Math.min(word[0].length(),3)); //Get first three letters of the word
            //System.out.println("firstThree: " + firstThree);
            //tempLine = firstThree+" "+Integer.toString(indexCounter)+"\n";
            //System.out.println("tempLine: " + tempLine);
            //writer.write(tempLine); // skriver till filen

            if(hashWord(firstThree) != hashWord(prevWord)){ //kollar om ord är annorlunda från den andra, isåfall lägg in i hashtabell

              hm.put(String.valueOf(hashWord(firstThree)),String.valueOf(indexCounter)); //Lägger till unika ord
              //.seek(x)
              //word = firstThree;
              //wordCount = 0;
            //System.out.println("wordList: " + wordList);
            }
            //wordList.add(word[0] + " " + wordCount);
            //String tempLine = word+" "+Integer.toString(indexCounter)+"\n";

              writerWordList.write(word[0] + " " + wordCount +"\n");
              wordCount = 0;


      }

      indexCounter++;
      prevWord = word[0];
      line = reader.readLine();
      if(line==null) {
          break;
      }
      word = line.split(" ");

    }


    //wordCount = 0;
    //wordList.add(word[0] + " " + wordCount);

      reader.close();
      reader.close();
      writerWordList.flush();
      writerWordList.close();


      for (HashMap.Entry<String,String> entry : hm.entrySet()) {

          properties.put(entry.getKey(), entry.getValue());
          }

      properties.store(new FileOutputStream("data.properties"), null);
/*
      indexCounter= 0;
      long st = System.currentTimeMillis();

      String fw = reader.readLine();
      String[] fw1 = fw.split(" ");
      String fw2 = fw1[0];
      hm.put(fw2,indexCounter);
      while((line = reader.readLine()) != null ){
        indexCounter++;
        String[] tempWord = line.split(" ");
        String firstThree = tempWord[0].substring(0,Math.min(tempWord[0].length(),3));
        if(!firstThree.equals(fw2)){

          hm.put(firstThree,indexCounter);
          fw2= firstThree;}



      }
      long et = System.currentTimeMillis();
      System.out.println(et-st);

*/

/*

      //Skapar en array av alla index i filen L;
      ArrayList<String> tokenizer = new ArrayList<String>();
      BufferedReader reader2 = new BufferedReader(new FileReader("ut.txt"));
      //BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File("indexArray.txt")));
      String line2;
      int counter2 = 0;
      String[] tempWord2;
      while((line2 = reader2.readLine()) != null ){
        tempWord2 = line2.split(" ");

        tokenizer.add(tempWord2[1]);

      }
      //System.out.println("tokenizer: "+tokenizer.get(0));



      reader2.close();

*/



      //Läsa position, skapa mening
/*
      RandomAccessFile raf = new RandomAccessFile("/info/adk18/labb1/korpus", "r");
      int tf = Integer.parseInt(tokenizer.get(0));
      raf.seek(tf-15);
      byte[] tp = {raf.readByte()};
      String bs = new String(tp,"ISO-8859-1");
      for(int i=0; i <=30; i++){
        byte[] tpa = {raf.readByte()};
        bs += new String(tpa,"ISO-8859-1");

      };
      System.out.println(bs);
*/

      //Write hashMap to file








    }
      catch (IOException e){
                System.out.println("there was an error");

  }



}

//END MAIN
public static int hashWord(String word) {
  int i = 0;
  int hashValue = 0;
  while(i < word.length() && i < 3) {
    hashValue += Math.pow(30,2-i) * getLetterValue(word.substring(i,i+1));
    i++;
  }
  return hashValue;
}

/**
* Returns the corresponding value to each letter.
*/
public static int getLetterValue(String letter) {
  for(int i = 0; i < letters.length; i++) {
    if(letter.equals(letters[i])) {
      return i;
    }
  }
  return 0;
}


}
