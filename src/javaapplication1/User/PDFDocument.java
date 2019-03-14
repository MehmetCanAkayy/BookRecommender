/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.User;
import com.adobe.acrobat.Viewer;
import  javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
 
public class PDFDocument extends JFrame {
 
private static final long serialVersionUID = 1L;
private Viewer  viewer;
 
public PDFDocument(String filename) {
this.setLayout(new  BorderLayout());
setSize(1024,  768);
 
try {
viewer = new Viewer();
FileInputStream fis = new  FileInputStream(filename);
viewer.setDocumentInputStream(fis);
this.add(viewer,  BorderLayout.CENTER);
viewer.activate();
getContentPane().add(viewer);
 
} catch (Exception e) {
e.printStackTrace();
}
}
}

