package decoratorPattern.Practice.JavaIO;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

//소문자 데코레이터
//FilterInputStream = 데코레이터 (추상)
//LowerCaseInputStream = 데코레이터 구현 클래스
//InputStream = 추상 구성요소
public class LowerCaseInputStream extends FilterInputStream {
    public LowerCaseInputStream(InputStream in){ //InputStream이 컴포넌트 역할을 함
        super(in);
    }
    public int read() throws IOException{
        int c= super.read();
        return ((c==-1)? c: Character.toLowerCase((char) c));
    }
    public int read(byte[] b, int offset, int len) throws IOException{
        int result = super.read(b, offset, len);
        for(int i=offset; i< offset + result; i++){
            b[i]=(byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
