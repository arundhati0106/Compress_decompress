/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author arund
 */

/*
Java provides I/O Streams to read and write data where, a Stream represents an input source or an output destination which could be a file, i/o devise, other program etc.
There are two types of streams available −
    InputStream − This is used to read (sequential) data from a source.
    OutputStream − This is used to write data to a destination.
*/
public class compress {
    public static void method (File file) throws FileNotFoundException, IOException {
        String fileDirectory = file.getParent();         //fetches the path of file, that is to be compressed
        System.out.println(fileDirectory);             //check if fileDirectory made properly
        
        FileInputStream fis = new FileInputStream(file); //read data from source, var name = file, file here is path
        FileOutputStream fos = new FileOutputStream(fileDirectory + "\\compressedFile.gz");
        
        //creates a zip file of the file, provided in the parameter
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        
        //store data inside each file using this array
        byte [] buffer = new byte[1024];
        int len;
        
        //len reads from input stream, it return -1 when it's at the end of the string... keep reading until we are at end of string
        while((len = fis.read(buffer)) != -1){
            //len return no of bytes read
            gzipOS.write(buffer, 0, len); //bytes read, starting point, no of bytes read
        }
        
        fis.close();
        gzipOS.close();
        fos.close();
    }
    
    public static void main(String[] args) throws IOException {
        //to check our method's functionality
//        System.out.print("Hello");
        File path = new File("D:\\coding proj\\netbeans\\minor_project1\\test.txt");
        method(path);
    }
    
}
