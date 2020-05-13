/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.controller;

import java.io.*;
import javax.swing.*;
import  com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mussa
 */
public class ExportToPdf {
    public ExportToPdf(){
     
 }
 public String getFileName(String baseName){
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateformat.format(new Date());
        return baseName.concat(String.format("_%s.pdf",dateTimeInfo)); 
    }
 public void exportPdfData(JTable table) throws FileNotFoundException{
     String path = getFileName("CheckOutForm".concat("_Export"));
     try {
        
         DefaultTableModel model = (DefaultTableModel) table.getModel();
           String col[] = {model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),model.getColumnName(4),model.getColumnName(5),model.getColumnName(6),model.getColumnName(7)};
        
        Document document=new Document();
        PdfWriter.getInstance(document,new FileOutputStream(path));
        document.open();
        document.addTitle("Informations from chechout made");
        
        PdfPTable tab=new PdfPTable(col.length);
        tab.setWidthPercentage(100);
        for(int k=0;k<col.length;k++){
            tab.addCell(col[k]);
        }
         tab.completeRow();
        for(int k = 0;k<model.getRowCount();k++){
            for(int mu = 0;mu< model.getColumnCount();mu++){
                tab.addCell(model.getValueAt(k, mu).toString());
            }
            tab.completeRow();
        }
        document.add(tab);
        document.close();
     } catch (DocumentException ex) {
         Logger.getLogger(ExportToPdf.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
}
