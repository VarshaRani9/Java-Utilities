package com.xyz.utilities;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

	public static void main(String[] args) throws Exception{
		String outputPdfPath = "output.pdf";
		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(outputPdfPath));
			doc.open();
			doc.add(new Paragraph("Hello World!!"));
			doc.add(new Paragraph("PDF generated..."));
			doc.add(new Paragraph("\n"));
			
			PdfPTable table = new PdfPTable(3);
			table.addCell("Name");
			table.addCell("Age");
			table.addCell("City");
			table.addCell("Row1, Ram");
			table.addCell("Row1, 30");
			table.addCell("Row1, Delhi");
			table.addCell("Row2, Sita");
			table.addCell("Row2, 35");
			table.addCell("Row2, DDN");
			doc.add(table);
			doc.close();
			System.out.println("pdf generated");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
