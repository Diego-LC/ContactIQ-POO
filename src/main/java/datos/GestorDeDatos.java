package datos;
import model.Contacto;
import model.PerfilUsuario;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class GestorDeDatos {

	public PerfilUsuario importarDatosContactos(String direccionArchivoContactos, PerfilUsuario perfilUsuario) {
		String textoArchivo = "";
		int contador = 0;
        try {
            File archivo = new File(direccionArchivoContactos);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Lee cada línea del archivo hasta que la línea sea nula
            while((textoArchivo = br.readLine()) != null){
				String[] data = textoArchivo.split(",");
				if (contador > 0) {
					Contacto contacto = new Contacto(data[0], data[1], data[2], data[3]);
					perfilUsuario.setContacto(contacto);
					if (data[4].equals("true")) {
						perfilUsuario.marcarComoFavorito(contacto);
					}
				}
				contador++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("error al leer el archivo " + direccionArchivoContactos+ " : " + e.getMessage());
        }
        return perfilUsuario;
	}

	public PerfilUsuario importarDatosPerfilUsuario(String direccionArchivo) {
		String textoArchivo = "";
		PerfilUsuario perfilUsuario = new PerfilUsuario();
		int contador = 0;
		try {
			File archivo = new File(direccionArchivo);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			//Lee cada línea del archivo hasta que la línea sea nula
			while((textoArchivo = br.readLine()) != null){
				String[] data = textoArchivo.split(",");
				if (contador != 0) {
					perfilUsuario.setNombre(data[0]);
					perfilUsuario.setApellido(data[1]);
					perfilUsuario.setCorreoElectronico(data[2]);
					perfilUsuario.setNumeroTelefono(data[3]);
				}
				contador++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("erro al leer el archivo " + direccionArchivo+ " : " + e.getMessage());
		}
		return perfilUsuario;
	}

	public boolean exportarDato(Object objeto, String direccionArchivo) {
        boolean lineaVacia=false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia=true;
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            //Si el documento no es nuevo y ya tiene registrados datos, se debe crear un salto de línea
            if(!lineaVacia && file.length() > 0){
                bw.newLine();
            }
            bw.write(objeto.toString());
            System.out.println("Guardado: " + objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador: " + e.getMessage() + " : " + e.getStackTrace());
            return false;
        }
    }

    public boolean borrarDatosArchivo(String direccionArchivo){
        try {
            File file = new File(direccionArchivo);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter buff = new BufferedWriter(writer);
            buff.close();
			return true;
        }catch (Exception e) {
            System.out.println("Error al borrar datos del archivo: " + e.getMessage() + " : " + e.getStackTrace());
			return false;
        }
    }

    public void generarQr(String texto, String direccionArchivo) {
        File outputFile = new File(direccionArchivo);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        int width = 300;
        int height = 300;
        String fileType = "png";

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, width, height);

            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ImageIO.write(image, fileType, outputFile);
        } catch (WriterException | IOException e) {
            System.err.println("Error al generar el código QR: " + e.getMessage());
        }
    }

    public void exportarContactosAExcel(String direccionArchivoCsv, String direccionArchivoExcel) {
    try (FileReader fileReader = new FileReader(direccionArchivoCsv);
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
        HSSFWorkbook workbook = new HSSFWorkbook()) {

        HSSFSheet sheet = workbook.createSheet("Contactos");
        int rowNum = 0;

        for (CSVRecord record : csvParser) {
            HSSFRow row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String field : record) {
                HSSFCell cell = row.createCell(colNum++);
                cell.setCellValue(field);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(direccionArchivoExcel)) {
            workbook.write(outputStream);
        }

    } catch (IOException e) {
        System.err.println("Error al exportar los contactos a Excel: " + e.getMessage());
    }
}
}