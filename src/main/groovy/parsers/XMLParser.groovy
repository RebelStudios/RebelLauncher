package parsers

import download.Downloader
import parsers.classmodel.xml.Mod
import parsers.classmodel.xml.ModType
import parsers.classmodel.xml.PackInfo
import parsers.classmodel.xml.RemoteMod

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Unmarshaller

/**
 * Created by misterti.me on 5/26/2014.
 *
 * Ported to Groovy by Kepler Sticka-Jones on 10/24/2014.
 */
class XMLParser {
    static ArrayList<String> packInfoArray = null
    static PackInfo packInfo

    static Mod mod

    static ArrayList<RemoteMod> remoteMods = new ArrayList<RemoteMod>()
    static RemoteMod remoteMod

    static void parsePackInfo(File f) throws JAXBException {
        JAXBContext jaxb = JAXBContext.newInstance(PackInfo.class)
        Unmarshaller unmarshaller = jaxb.createUnmarshaller()

        packInfo = (PackInfo) unmarshaller.unmarshal(f)

        packInfoArray.add(packInfo.packName)
        packInfoArray.add(packInfo.packVersion)
        packInfoArray.add(packInfo.MCVersion)
        packInfoArray.add(packInfo.branch)
        println(packInfoArray)
    }

    static void parseMods(File f) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Mod.class)
            Unmarshaller unmarshaller = jaxb.createUnmarshaller()

            print("Parsing mods...")
            mod = (Mod) unmarshaller.unmarshal(f)
            println(" done.")

            int i = 0
            while (i < mod.mods.size()) {
                if (mod.mods.get(i).xml != null) {
                    mod.mods.get(i).modType = ModType.OFFICIAL

                    println("Mod #" + (i + 1) + " is from the official repository.")
                    print("Getting remote XML for mod #1...")
                    // InputStream is = Downloader.getRemoteModXML(new URL(mod.mods.get(i).xml))
                    println(" done.")
                    parseRemoteXML(Downloader.getRemoteModXML(new URL(mod.mods.get(i).xml)))

                } else {
                    mod.mods.get(i).modType = ModType.UNOFFICIAL
                    println("Mod #" + (i + 1) + " is unofficial; if something goes wrong, it's not my fault.")
                }
                i++
            }
        }
        catch (JAXBException e) { e.printStackTrace() }
        catch (MalformedURLException e) { e.printStackTrace() }
        catch (IOException e) { e.printStackTrace() }
    }

    static void parseRemoteXML(InputStream inputStream) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(RemoteMod.class)
            Unmarshaller unmarshaller = jaxb.createUnmarshaller()

            print("Parsing remote mod XML...")
            remoteMod = (RemoteMod) unmarshaller.unmarshal(inputStream)
            remoteMods.add(remoteMod)
            println(" done.")
        } catch (JAXBException ignored) { }
    }
}
