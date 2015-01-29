/**
   JavaServer Faces in Action example code, Copyright (C) 2004 Kito D. Mann.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

**/

package org.jia.hello;

import java.util.*;
import javax.faces.application.*;
import javax.faces.component.*;
import javax.faces.component.html.*;
import javax.faces.context.*;
import javax.faces.event.*;

public class HelloBean
{
  private int numControls;
  private HtmlPanelGrid controlPanel;

  public HtmlPanelGrid getControlPanel()
  {
    return controlPanel;
  }

  public void setControlPanel(HtmlPanelGrid controlPanel)
  {
    this.controlPanel = controlPanel;
  }

  public int getNumControls()
  {
    return numControls;
  }

  public void setNumControls(int numControls)
  {
    this.numControls = numControls;
  }

  public String goodbye()
  {
    return "success";
  }

  public void addControls(ActionEvent actionEvent)
  {
    UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
    Application application = FacesContext.getCurrentInstance().getApplication();
    List children = controlPanel.getChildren();
    children.clear();
    for (int count = 0; count < numControls; count++)
    {
      HtmlOutputText output =
          (HtmlOutputText)application.createComponent(HtmlOutputText.COMPONENT_TYPE);
      output.setValue(" " + count + " ");
      output.setStyle("color: blue");
      children.add(output);
    }
  }
}
