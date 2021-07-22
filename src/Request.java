import java.io.Serializable;

public class Request implements Serializable {

    private EnumRequest EnumRequest;
    private DummyObject dummyObject;

    public EnumRequest getEnumRequest() {
        return EnumRequest;
    }

    public DummyObject getDummyObject() {
        return dummyObject;
    }
}
