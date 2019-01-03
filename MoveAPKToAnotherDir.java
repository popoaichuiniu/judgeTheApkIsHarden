import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Logger;



public class MoveAPKToAnotherDir {

public static void moveFile(String sourceFilePath,String targetFilePath)
    {
        
      
        File sourceFile=new File(sourceFilePath);
        if(sourceFile.exists())
        {
            File targetFile=new File(targetFilePath);
            File targetDir=targetFile.getParentFile();
            if(targetDir!=null)
                {
                    if(!targetDir.exists())
                        {
                            try {
                                targetDir.mkdirs();
                                  System.out.println("create dir successful!");
                            }
                            catch (Exception exception)
                            {
                                logger.warning(sourceFilePath+"*********"+targetDir.getAbsolutePath()+"创建失败！\n");
                            }
                        }
                    String targetDirPath=targetDir.getAbsolutePath();
                    BufferedReader bufferedReader=null;
                    System.out.println(targetDirPath);
                    try
                    {
                        Process process=Runtime.getRuntime().exec("mv "+sourceFilePath+" "+targetDirPath);
                        bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream())) ;
                    }
                    catch (IOException ioException)
                        {
                            logger.warning(sourceFilePath+"*********"+"执行mv命令出错！"+"\n");
                        }
                    
                    
                    String line=null;
                    try {
                        while((line=bufferedReader.readLine())!=null)
                        {
                            System.out.println(line);
                        }
                        
                    } catch (Exception e) {
                        logger.warning(sourceFilePath+"*********"+"读取mv输出命令日志出错！"+"\n");
                    }
                    
                    
                }

        }
    }

public static Logger logger=null;

public static void main(String[] args) {

	logger=Logger.getLogger("move_file_log");
        try {
            logger.addHandler(new FileHandler("MoveAPKToAnotherDir.log",true));
        } catch (Exception e) {
           System.out.println(e+"\n"+"日志初始化失败！");
        }

    String line =null;
    try {
    BufferedReader bufferedReader=new  BufferedReader(new FileReader("apk_harden"));
        
        while((line=bufferedReader.readLine())!=null)
        {
            //System.out.println("*"+line+"*");
            System.out.println("apkHarden"+line.substring(1));
            moveFile(line, "apkHarden"+line.substring(1));
        }
    } catch (IOException e) {
        //TODO: handle exception
    }
    

    //moveFile("1.txt", "xxx/YYYYYY/ZZZ.txt");

}
}
