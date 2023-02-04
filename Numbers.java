import mypack.MyTools;

import java.io.*;
import java.util.ArrayList;

public class Numbers {

    private int auxSize;
    private int size;
    private int[] array;
    private static int cntSave = 0;

    public Numbers(int auxSize) throws Exception {
        this.auxSize = auxSize;
        this.array = new int[auxSize];
        doArray();
    }


    public int[] getArray() {
        return array;
    }

    protected int getNumber() throws Exception {
        return MyTools.rng(0,999999);
    }
    protected int[] doArray() throws Exception {

        for (int i = 0; i < auxSize; i++) {
            array[i] = getNumber();
        }
        return array;
    }
    protected void saveData() throws Exception {
        Main aux = new Main();


        ArrayList<String> infoNumbers =  new ArrayList<>();
        infoNumbers.add("lines nº: "+ aux.getCntLine()+"");
        infoNumbers.add("execution duration: "+ aux.getTimeExe()+"");
        infoNumbers.add("save nº: "+ aux.getDigit());

        BufferedWriter saveData =  new BufferedWriter(new FileWriter("number_class_info.txt", true));

        try{
            for (int i = 0; i < infoNumbers.size(); i++) {
                saveData.write(infoNumbers.get(i));
                saveData.write("\n");
            }
        }catch (FileNotFoundException msg){
            throw new FileNotFoundException("File does not exists");
        }finally {
            saveData.close();
        }
    }
}
