//
//   Copyright 2018  SenX S.A.S.
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//
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
