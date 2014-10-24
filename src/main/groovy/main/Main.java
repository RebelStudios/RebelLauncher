package main;

import download.Downloader;
import download.Verifier;
import parsers.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by misterti.me on 5/26/2014.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        File f = new File("C:\\Users\\misterti.me\\Desktop\\XML\\mods.xml");
        File g = new File("C:\\Users\\misterti.me\\Desktop\\XML\\IC2-2.1.477.jar");

        Downloader.installResources();
//        XMLParser.parseMods(f);
    }
}
