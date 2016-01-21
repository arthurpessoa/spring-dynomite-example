package io.github.terramedia.infra;

import com.netflix.dyno.connectionpool.Host;
import com.netflix.dyno.connectionpool.HostSupplier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FakeHostSupplier implements HostSupplier {

  @Override
  public Collection<Host> getHosts() {
    final List<Host> hosts = new ArrayList<>();
    hosts.add(new Host("127.0.0.1", 8102).setStatus(Host.Status.Up).setRack("localdc"));
    return hosts;

  }
}
