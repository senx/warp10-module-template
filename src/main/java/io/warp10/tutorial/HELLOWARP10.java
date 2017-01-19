//
//   Copyright 2016  Cityzen Data
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

package io.warp10.tutorial;

import io.warp10.script.NamedWarpScriptFunction;
import io.warp10.script.WarpScriptException;
import io.warp10.script.WarpScriptStack;
import io.warp10.script.WarpScriptStackFunction;

public class HELLOWARP10 extends NamedWarpScriptFunction implements WarpScriptStackFunction {

  public HELLOWARP10(String name) {
        super(name);
    }

  public Object apply(WarpScriptStack stack) throws WarpScriptException {

    //
    // Get params
    //

    Object firstText = stack.pop();
    Object secondText = stack.pop();

    if (!(firstText instanceof String)) {
      throw new WarpScriptException("First param must be a String");
    }
    if (!(secondText instanceof String)) {
      throw new WarpScriptException("Second param must be a String");
    }
    try {
      stack.push(firstText.toString() + ' ' + secondText.toString());
    } catch (WarpScriptException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new WarpScriptException("Stack exception" + e.getMessage() + e.getStackTrace().toString());
    }

    return stack;
  }
}
