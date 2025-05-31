/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


package com.mycompany.JavaY2.InventoryManager;

import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.FileNotFoundException;
import java.util.Map;

*
 *
 * @author Kaiqi


public class GenerateStockReportPdf extends GeneratedDate{
    public static void writePdf(String fileName, Map<String, StockReportContent> itemNameDateMap){
        try{
            PdfWriter writer = new PdfWriter(fileName);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.setMargins(30, 30, 30, 30);

            Paragraph title = new Paragraph("Stock Report")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(18)
                    .setBold();

            document.add(title);
            document.add(new Paragraph("\n"));

            float columnWidth[] = {200f, 200f, 200f, 200f};
            Table table = new Table(columnWidth);
            table.addHeaderCell("Group ID");
            table.addHeaderCell("Item Name");
            table.addHeaderCell("Quantity");
            table.addHeaderCell("Latest Date Received");

            for(StockReportContent entry : itemNameDateMap.values()){
                table.addCell(entry.groupId);
                table.addCell(entry.itemName);
                table.addCell(String.valueOf(entry.quantity));
                table.addCell(entry.dateReceived);
            }

            document.add(table);
            document.add(new Paragraph("\n"));
            String generatedDate = GeneratedDate.getCurrentDate();
            Paragraph dateParagraph = new Paragraph("Generated at: " + generatedDate)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(10);
            document.add(dateParagraph);
            document.close();
            System.out.println("PDF created successfully");





}catch (FileNotFoundException e){
    System.out.println(e.getMessage());
}
    }
}
*/
