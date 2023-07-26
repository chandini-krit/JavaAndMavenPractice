package org.example;
import org.junit.Test;
public class LogExecute {
    @Test
    public void shouldDemonstrateLogging(){
        LoggerExample obj=new LoggerExample();
        LoggerExample.process("first");
    }
}
