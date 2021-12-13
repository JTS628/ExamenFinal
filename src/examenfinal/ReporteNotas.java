
package examenfinal;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import static examenfinal.NevaTarea.reporte;



public class ReporteNotas {
    
    String NombreArchivo;
    String Fecha;
    String RutaImagen;
    ArrayList <datosTareas> reporte;
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public ReporteNotas(String NombreArchivo, String Fecha, String RutaImagen , ArrayList<datosTareas> reporte) {
        this.NombreArchivo = NombreArchivo;
        this.Fecha = Fecha;
        this.RutaImagen = RutaImagen;
        this.reporte = reporte;
        documento = new Document();
        
        titulo = new Paragraph ("Reporte de Usuarios");
    }
    
    @SuppressWarnings("empty-statement")
    public void CrearReporte(){
    
          try{
              archivo = new FileOutputStream(NombreArchivo + ".pdf");
          
              PdfWriter.getInstance(documento, archivo);
          
              documento.open();
              titulo.setAlignment(1);
              documento.add(titulo);
              
              /*Image imagen1 = null;
              imagen1 = Image.getInstance(RutaImagen);
              imagen1.setAbsolutePosition(430, 760);
              imagen1.scaleAbsolute(100, 100);
              documento.add(imagen1);*/
              
              documento.add(Chunk.NEWLINE);
              documento.add(new Paragraph(""));
              documento.add(Chunk.NEWLINE);
              Paragraph Texto = new Paragraph( "El documento es confidencial y puede ser utilizado por personal autorizado. Si recibio este documento por error, por favor informelo a las autoridades pertinentes");
                            Texto.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
              documento.add(Texto);
              
              documento.add(Chunk.NEWLINE);
              documento.add(Chunk.NEWLINE);
              
              PdfPTable Tabla = new PdfPTable(5);
              
              Tabla.setWidthPercentage(100);
              PdfPCell nombreN = new PdfPCell (new Phrase("Nombre de Tarea"));
              nombreN.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell desc = new PdfPCell (new Phrase("Descripción"));
              desc.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell enc = new PdfPCell (new Phrase("Encargado"));
              enc.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
             
              Tabla.setWidthPercentage(100);
              PdfPCell estado = new PdfPCell (new Phrase("Estado"));
              estado.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell fecha = new PdfPCell (new Phrase("Fecha"));
              fecha.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.addCell(nombreN);
              Tabla.addCell(desc);
              Tabla.addCell(enc);
              Tabla.addCell(estado);
              Tabla.addCell(fecha);
              
              for (datosTareas p : reporte){
                  Tabla.addCell(p.getNobreTarea());
                  Tabla.addCell(p.getDescripcion());
                  Tabla.addCell(p.getEncargado());
                  Tabla.addCell(p.getEstado());
                  Tabla.addCell(p.getFecha());
                   
              }  
              documento.add(Tabla);
              
              
              
              BarcodeQRCode codigoqr = new BarcodeQRCode("Esto es un reporte de Notas",1,1,null);
              Image imagenQR = codigoqr.getImage();
              imagenQR.scaleAbsolute(100, 100);
              documento.add(imagenQR);
              
              documento.add(Chunk.NEWLINE);
              
              documento.add(new Paragraph(Fecha));
               
              documento.add(Chunk.NEWLINE);

             documento.close();


            JOptionPane.showMessageDialog(null, "Reporte de Notas creado");
          
          }catch(Exception e){}
    }
    
    
    
}
