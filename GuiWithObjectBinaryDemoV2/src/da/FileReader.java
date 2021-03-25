/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author lecturer
 */
public abstract class FileReader {

    protected File filename;

    public void setFileName(String fn) {
        this.filename = new File(fn);
    }

    public abstract ArrayList<String> readAll();

    public abstract boolean write(String record);
}