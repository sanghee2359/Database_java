import Parser.Parser;   // import Parser

import java.io.*;
import java.util.ArrayList;
import java.util.List;
// 제네릭 타입 string이었던거 리팩토링 해볼것입니다
public class FileController<T> {    // 이부분이 빠졌었네요
    Parser<T> parser;
    private boolean isRemoveColumName = true;

    public FileController(Parser<T> parser, boolean isRemoveColumName) {
        this.parser = parser;
        this.isRemoveColumName = isRemoveColumName;
    }

    List<T> readLine(String filename) throws IOException {    // default 메소드
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;

        if(isRemoveColumName){
            br.readLine();
        }
        while((str= br.readLine())!= null){
            result.add(parser.parse(str));    // 이때 이 parse메소드가 호출되면서 hospital 객체 생성이요
        }
        return result;
    }
    public void createANewFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
        System.out.println("Have a file generated?:"+file.exists());
    }
    public void writeLines(List<String> lines, String filename){
        File file = new File(filename);

        try{
            BufferedWriter writer
                    = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            for(String str : lines){
                writer.write(str);
            }
            writer.close();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        System.out.println("success");
    }
}
