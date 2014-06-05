package parsers;

import download.Downloader;
import parsers.classmodel.xml.Mod;
import parsers.classmodel.xml.ModType;
import parsers.classmodel.xml.PackInfo;
import parsers.classmodel.xml.RemoteMod;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by misterti.me on 5/26/2014.
 */
public class XMLParser {
    public static ArrayList<String> packInfoArray = null;
    public static PackInfo packInfo;

    public static Mod mod;

    public static ArrayList<RemoteMod> remoteMods = new ArrayList<RemoteMod>();
    public static RemoteMod remoteMod;

    public static void parsePackInfo(File f) throws JAXBException {
        JAXBContext jaxb = JAXBContext.newInstance(PackInfo.class);
        Unmarshaller unmarshaller = jaxb.createUnmarshaller();

        packInfo = (PackInfo) unmarshaller.unmarshal(f);

        packInfoArray.add(packInfo.packName);
        packInfoArray.add(packInfo.packVersion);
        packInfoArray.add(packInfo.MCVersion);
        packInfoArray.add(packInfo.branch);
        System.out.println(packInfoArray);
    }

    public static void parseMods(File f) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Mod.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            System.out.print("Parsing mods...");
            mod = (Mod) unmarshaller.unmarshal(f);
            System.out.println(" done.");

            int i = 0;
            while (i < mod.mods.size()) {
                if (mod.mods.get(i).xml != null) {
                    mod.mods.get(i).modType = ModType.OFFICIAL;

                    System.out.println("Mod #" + (i + 1) + " is from the official repository.");
                    System.out.print("Getting remote XML for mod #1...");
//                    InputStream is = Downloader.getRemoteModXML(new URL(mod.mods.get(i).xml));
                    System.out.println(" done.");
                    parseRemoteXML(Downloader.getRemoteModXML(new URL(mod.mods.get(i).xml)));

                } else {
                    mod.mods.get(i).modType = ModType.UNOFFICIAL;
                    System.out.println("Mod #" + (i + 1) + " is unofficial; if something goes wrong, it's not my fault.");
                }
                i++;
            }
        } catch (JAXBException e)         {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e)           {
            e.printStackTrace();
        }
    }

    public static void parseRemoteXML(InputStream inputStream) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(RemoteMod.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            System.out.print("Parsing remote mod XML...");
            remoteMod = (RemoteMod) unmarshaller.unmarshal(inputStream);
            remoteMods.add(remoteMod);
            System.out.println(" done.");
        } catch (JAXBException e) {

        }
    }
}
