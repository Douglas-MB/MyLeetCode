import mypack.MyTools;

import java.io.*;

public class Main {
    BufferedReader readExistedFile = new BufferedReader(new FileReader("testNum.txt"));

    public Main() throws FileNotFoundException {
    }

    public void test() throws IOException {
        String aux;
        while ((aux = readExistedFile.readLine())!=null){
            System.out.println(aux);

        }

    }
    private static final long MILLI_DIV = 1000000;
     private static final float SEC_DIV = 1000f;
     private static int cntLine=0;
     private static int saveVer = 15;

     private static float timeExe= 0f;



    public int getCntLine() {
        return cntLine;
    }

    public float getTimeExe() {
        return timeExe;
    }

    public String getDigit() {
        return saveVer+"";
    }

    public static void main(String[] args) throws Exception {


         boolean overwrite = false;
         Main auxTest =  new Main();
         String a = auxTest.readExistedFile.readLine();
        System.out.println(a+"!");

         System.out.println();

         long start = System.nanoTime()/MILLI_DIV;
         Numbers test = new Numbers(MyTools.rng(1, 1));
         BufferedWriter write = new BufferedWriter(new FileWriter("testNum.txt", overwrite));


         int i = 0;
         String[] number =  new String[test.getArray().length+1];

         try {
             for (i = 0; i <number.length; i++) {

                 if(i == (number.length - 1)){
                     number[i] = saveVer +"";
                     write.write(number[i]+"\n");
                     System.out.println(number[i]+"!!");
                     break;
                 }
                 number[i] =  test.getArray()[i] + "\n";
                 System.out.println(number[i]+"!!");
                // i am saving in the same index
                 write.write(number[i]);

             }

             write.write("Save nº: " + ++saveVer);
             write.write("\n------------------------\n");

         } catch (ArrayIndexOutOfBoundsException msg) {
             throw new ArrayIndexOutOfBoundsException("The index " + i + "is out of bounds for the array of length "+ test.getArray().length);
         }finally {
             write.close();
         }

         BufferedReader read = new BufferedReader(new FileReader("testNum.txt"));


         try {
             String aux=" ";
             while ((aux = read.readLine()) != null){
                 ++cntLine;
                 System.out.println(aux);
             }


         }catch (FileNotFoundException msg){
             throw new FileNotFoundException("The file you trying to read does not exists");
         }finally {
             read.close();
         }
         long end = System.nanoTime()/MILLI_DIV;
         timeExe = (end - start)/SEC_DIV;

         test.saveData();

         System.out.println();
     }
}