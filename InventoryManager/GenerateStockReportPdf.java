/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.InventoryManager;

import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.util.Map;
//import javax.swing.text.Document;

/**
 *
 * @author Kaiqi
 */
public class GenerateStockReportPdf {
    public static void writePdf(String fileName, Map<String, String> itemNameDateMap){
        try{
            PdfWriter writer = new PdfWriter(fileName);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Paragraph title = new Paragraph("Stock Report")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(18)
                    .setBold();

            document.add(title);
            document.add(new Paragraph("\n"));
            
            float columnWidth[] = {200f, 200f};
            Table table = new Table(columnWidth);
            table.addHeaderCell("Item Name");
            table.addHeaderCell("Latest Date Received");

            for(Map.Entry<String, String> entry : itemNameDateMap.entrySet()){
                table.addCell(entry.getKey());
                table.addCell(entry.getValue());
            }

            document.add(table);
            document.close();
            System.out.println("PDF created successfully");
        
        

        
    
}catch (FileNotFoundException e){
    System.out.println(e.getMessage());
}
    }
}