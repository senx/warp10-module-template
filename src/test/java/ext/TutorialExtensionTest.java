package ext;

import java.io.StringReader;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vividsolutions.jts.util.Assert;

import io.warp10.WarpConfig;
import io.warp10.script.MemoryWarpScriptStack;
import io.warp10.script.WarpScriptLib;

public class TutorialExtensionTest {
  
  @BeforeClass
  public static void beforeClass() throws Exception {
    StringBuilder props = new StringBuilder();
    
    props.append("warp.timeunits=us");
    WarpConfig.setProperties(new StringReader(props.toString()));
    WarpScriptLib.register(new TutorialExtension());
  }
  
  @Test
  public void testHELLOWARP10() throws Exception {
    MemoryWarpScriptStack stack = new MemoryWarpScriptStack(null, null, WarpConfig.getProperties());
       
    stack.exec("'foo' 'bar' HELLOWARP10");
    Object top = stack.pop();
    
    Assert.equals("bar foo", top);
  }
}
