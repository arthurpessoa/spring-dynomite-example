package io.github.terramedia.infra;

import com.netflix.dyno.connectionpool.Host;
import com.netflix.dyno.connectionpool.impl.lb.AbstractTokenMapSupplier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FakeTokenMapSupplier extends AbstractTokenMapSupplier {


  final String json =      "[]";


  @Override
  public String getTopologyJsonPayload(Set<Host> set) {
    return json;
  }

  @Override
    public String getTopologyJsonPayload(String hostname) {
      return json;
    }
}
