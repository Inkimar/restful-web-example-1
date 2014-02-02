/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author ingimar
 */
@WebServlet(loadOnStartup = 1, urlPatterns = {"/StartServlet"})
public class StartServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Start: INgimar -Starting up");
        List<String> list = new ArrayList<String>();
        list.add("key:value");
        setPropertyfile(list);
        System.out.println("End: INgimar -Starting up");
        
    }

    private void setConfiguration(String env) {
    }

    // saves the file in -> /home/ingimar/Glassfish-servers/glassfish-3.1.2.2/glassfish/domains/domain1/config
    private void setPropertyfile(List configs) {

        Properties prop = new Properties();

        OutputStream output = null;

        try {

            output = new FileOutputStream("ingimar.properties");
            prop.setProperty("key", "value");
            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {

            io.printStackTrace();

        } finally {

            if (output != null) {

                try {

                    output.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
