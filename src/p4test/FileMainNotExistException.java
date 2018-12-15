/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4test;

import java.io.FileNotFoundException;

/**
 *
 * @author John
 */
public class FileMainNotExistException extends FileNotFoundException {

    public FileMainNotExistException() {
        super("\nO ARQUIVO PARA LEITURA NÃO EXISTE OU NÃO ESTÁ NO DIRETÓRIO DEVIDO.\n"
                + "CERTIFIQUE-SE DE QUE ELE SE ENCONTRA NO LOCAL CORRETO.");
    }

}
