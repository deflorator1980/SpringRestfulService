package test;

import hello_big.ShopBig;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import hello_big.GreetingControllerBig;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestRunner {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Result result = JUnitCore.runClasses(GreetingControllerBigTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
