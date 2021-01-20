package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.DTO.Mensaje;
import com.escom.FRIDA_BackEnd.Entity.Imagen;
import com.escom.FRIDA_BackEnd.Repository.ImagenRepository;
import com.escom.FRIDA_BackEnd.Service.ImagenService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.aspectj.util.LangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ControladorImagen {
    @Autowired
    ImagenRepository repositorio;

    @PostMapping("/crear/imagen")
    public ResponseEntity<?> uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("idCaso") String idCaso) throws IOException{
        int idCasoEntero = Integer.valueOf(idCaso);
        Imagen img = new Imagen(file.getOriginalFilename(),compressBytes(file.getBytes()),idCasoEntero);
        repositorio.save(img);
        return new ResponseEntity(new Mensaje("La imagen ha sido guardada."), HttpStatus.CREATED);
    }
    
    @GetMapping(path = { "/get/imagenes/{idCaso}" })
    public List<Imagen> getImage(@PathVariable("idCaso") Long idCaso) throws IOException {
        List<Imagen> retrievedImage = repositorio.findByIdCaso(idCaso);
        List<Imagen> imgs = new ArrayList<>();
        for(Imagen i: retrievedImage) {     // Recorriendo lista de imagenes almacenadas del caso
            Imagen img = new Imagen(i.getNombreImagen(), decompressBytes(i.getBytes()), i.getIdCaso());
            imgs.add(img);
        }
        return imgs;
    }
    
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}