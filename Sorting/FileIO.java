import java.io.*;

public class FileIo{

    public String[] getContents(File aFile, int num) {
//this method loads num lines of the file into an array and returns the array
        String[] array = new String[num];
        BufferedReader input = null;
        try {
            input = new BufferedReader( new FileReader(aFile) );
            String line = null;
            for(int i=0;i<array.length;i++){
                array[i]=input.readLine();
            }
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                if (input!= null) {
                    input.close();
                }
            }catch (IOException ex) {
                  ex.printStackTrace();
            }
        }
        return array;
     }

     public void setContents(File aFile, String[] array) throws FileNotFoundException, IOException {
//this method saves the array into the file
        Writer output = null;
        try {

            output = new BufferedWriter( new FileWriter(aFile) );
            for(int i=0;i<array.length;i++){
                output.write( array[i] );
                output.write(System.getProperty("line.separator"));
            }
        }finally {
            if (output != null) output.close();
        }
     }  
}
