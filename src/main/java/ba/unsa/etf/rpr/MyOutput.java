package ba.unsa.etf.rpr;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class MyOutput extends ObjectOutputStream {


    MyOutput() throws IOException
    {
        super();
    }


    MyOutput(OutputStream o) throws IOException
    {
        super(o);
    }

    public void writeStreamHeader() throws IOException
    {
        return;
    }
}