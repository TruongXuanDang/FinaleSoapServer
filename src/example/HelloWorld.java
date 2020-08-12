package example;
import com.demo.dao.ProductDAO;
import com.demo.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;

@WebService()
public class HelloWorld {
  ProductDAO dao = new ProductDAO();

  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);
  }

  @WebMethod
  public ArrayList<Product> getAllRooms(){
    try {
      ArrayList<Product> list = (ArrayList<Product>)dao.getProduct();
      return list;
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList();
    }
  }
}
