import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static final int BSIZE=1024;

    public static void main(String...args){
        try {
            FileChannel fc=new FileOutputStream("test.txt").getChannel();
            ByteBuffer bf=ByteBuffer.allocate(BSIZE);
            fc.write(ByteBuffer.wrap("this is the first nio demo".getBytes()));
            fc =new FileInputStream("test.txt").getChannel();
            fc.read(bf);
            bf.flip();
            while (bf.hasRemaining()){
                System.out.print((char) bf.get());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
