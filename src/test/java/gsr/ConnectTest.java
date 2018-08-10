package gsr;

import org.junit.Test;
import gsr.repository.Connect;

public class ConnectTest {


    @Test
    public void test(){
        new Connect().runQuery("SELECT * FROM texttable");
    }

}
