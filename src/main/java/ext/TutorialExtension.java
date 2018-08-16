//
//   Copyright 2018  Cityzen Data
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

import io.warp10.warp.sdk.WarpScriptExtension;

import java.util.HashMap;
import java.util.Map;

/**
 * Functions declared by this WarpScript extension must be present in the functions field.
 */
public class TutorialExtension extends WarpScriptExtension {

  private static final Map<String, Object> functions;

  static {
    functions = new HashMap<String, Object>();

    //
    // Add the tutorial function to the tutorial extension.
    // The key of the map entry is the command that will be available in WarpScript code.
    // Its value is the function that will be called when the command is executed.
    //

    functions.put("HELLOWARP10", new HELLOWARP10("HELLOWARP10"));
  }

  public Map<String, Object> getFunctions() {
    return functions;
  }
}
