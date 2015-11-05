package hello_big;


public class NilBig {
    String hello;

    public NilBig(String hello) {
        this.hello = hello;
    }

    public String getHello() {
        return hello;
    }

    @Override
    public String toString() {
        return "NilBig{" +
                "hello='" + hello + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NilBig)){
            return false;
        }

        NilBig that = (NilBig) obj;
        return this.hello.equals(that.hello)
                && this.hello.equals(that.hello);
    }
}
