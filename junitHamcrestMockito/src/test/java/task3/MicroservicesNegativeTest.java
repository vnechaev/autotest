package task3;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MicroservicesNegativeTest {


    @Test
    public void checkOkStatus(){
        MicroServisJson microServis = mock(MicroServisJson.class);
        when(microServis.writeStudent("OkeyStateStudent")).thenReturn("state: ok");

        Assert.assertNotEquals("state: okey", microServis.writeStudent("OkeyStateStudent"));
    }

    @Test
    public void checkErrorMessage(){
        MicroServisJson microServis = mock(MicroServisJson.class);
        when(microServis.writeStudent("BadErrorStudent")).thenReturn("error : noError");

        Assert.assertNotEquals("error : 404", microServis.writeStudent("BadErrorStudent"));
    }

}
