package io.github.terramedia.endpoint;

import com.netflix.dyno.jedis.DynoJedisClient;
import io.github.terramedia.model.MyAwesomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Endpoint {


  private DynoJedisClient dynoJedisClient;

  @Autowired
  public Endpoint(DynoJedisClient dynoJedisClient) {
    this.dynoJedisClient = dynoJedisClient;
  }


  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public MyAwesomeModel setAndGetAValueInRedis(@RequestParam String value) {

    dynoJedisClient.set("value", value);
    return new MyAwesomeModel(dynoJedisClient.get("value"));
  }

  @ExceptionHandler
  @RequestMapping(value = "/error", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Exception exceptionHandler(Exception e) {
    return e;

  }

}
