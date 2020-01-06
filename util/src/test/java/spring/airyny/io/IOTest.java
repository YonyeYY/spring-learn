package spring.airyny.io;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOTest {

    @Test
    public void ioTest()throws Exception{
        FileOutputStream output = new FileOutputStream("temp.bat");
        for (int i = 1;i <= 10;i++){
            output.write(i);
        }
        output.close();

        FileInputStream input = new FileInputStream("temp.bat");
        int value;
        while ((value = input.read()) != -1){
            System.out.println(value + " ");
        }

        input.close();
    }


    @Test
    public void writeStream()throws Exception{

        DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));

        output.writeUTF("John");
        output.writeDouble(85.5);
        output.writeUTF("Jim");
        output.writeDouble(185.5);
        output.writeUTF("Jun");
        output.writeDouble(200);

        output.close();

        DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"));

        System.out.println(input.readUTF() + " " +input.readDouble());
        System.out.println(input.readUTF() + " " +input.readDouble());
        System.out.println(input.readUTF() + " " +input.readDouble());

    }

    @Test
    public void beanFactory(){
    }
}
