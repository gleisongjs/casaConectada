
package com.casaconectada.controller;

import com.casaconectada.action.SensorAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trnsformers
 */
public class SensorSV extends HttpServlet {

    
      @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        new SensorAction().execute(request, response);

    }

}
