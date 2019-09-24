package coursesRegistration.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FileProcessor throws FileNotFoundException {
	String courseArray[][] = new String[9][3];
    int m=0;
   File file = new File("courseInfo.txt");
	 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	 String line;
	 while ((line = br.readLine()) != null) {
	  courseArray[m][0]=Character.toString(line.charAt(0));
	  line=line.replaceAll("[^0-9]+"," ");                   //https://stackoverflow.com/questions/13440506/find-all-numbers-in-the-string
	  String lineArray[]= line.split(" ");
	   for(int i=1;i< lineArray.length;i++){
	    courseArray[m][i]= lineArray[i];
    }
     m++;
    }
  }
     catch (IOException e1) {
      e1.printStackTrace();
    }
	ArrayList<String> arr = new ArrayList<>();
    File file1 = new File("student_coursePrefs.txt");
     try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
     String line;
     while ((line = br.readLine()) != null) {
      arr.add(line);
    }
  }
     catch (IOException e1) {
       e1.printStackTrace();
  }
     int len = arr.size();
    //System.out.println(len);
    String[][] studentcourse = new String[len][11];
    int n = 0;
   for(int i = 0; i < len ; i++){
    String str = arr.get(i);
    str=str.replaceAll("\\s+",",");
    str=str.replaceAll("::",",");
    String lineArray[]= str.split(",");
      for(int j = 0; j < lineArray.length ; j++){
		  if(lineArray[j].equals("") == false){
      studentcourse[n][j] = lineArray[j];
		  }
    }
     n++;
    }
  }

