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

  /**
   * This method takes as argument the current state of the WarpScript stack when the custom function is called.
   * It returns the state of the stack after the custom function have been applied.
   * @param stack
   * @return stack
   * @throws WarpScriptException
   */
  public Object apply(WarpScriptStack stack) throws WarpScriptException {

    //
    // Retrieve the arguments of the custom function on top of the stack
    //

    Object firstText = stack.pop();
    Object secondText = stack.pop();

    //
    // Check the class of the arguments retrieved
    //

    if (!(firstText instanceof String)) {
      throw new WarpScriptException("First param must be a String");
    }
    if (!(secondText instanceof String)) {
      throw new WarpScriptException("Second param must be a String");
    }

    //
    // Apply function and push its outputs onto the stack or raise an exception
    //

    try {
      stack.push(firstText.toString() + ' ' + secondText.toString());
    } catch (WarpScriptException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new WarpScriptException("Stack exception" + e.getMessage() + e.getStackTrace().toString());
    }

    //
    // Return the new state of the stack
    //

    return stack;
  }
}
