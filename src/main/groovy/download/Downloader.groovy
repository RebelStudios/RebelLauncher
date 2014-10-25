package download

import parsers.XMLParser
import parsers.classmodel.xml.Resource

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Unmarshaller
import java.nio.file.Files

import static org.apache.commons.io.FileUtils.copyURLToFile

/**
 * Created by misterti.me on 5/27/2014.
 *
 * Ported to Groovy by Kepler Sticka-Jones on 10/24/2014.
 */
class Downloader {
    static InputStream getRemoteModXML(URL url) throws IOException {
        url.openConnection().getInputStream()
    }

    static void installMods(File where, File xml) {
        try {
            XMLParser.parseMods(xml)

            int i = 0;
            while (i  < XMLParser.mod.mods.size()) {
                downloadFile(new URL(XMLParser.remoteMods.get(i).file), new File(where.toString()), XMLParser.remoteMods.get(i).SHAHash)

                i++
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    static void installResources() throws JAXBException, IOException {
        JAXBContext jaxb = JAXBContext.newInstance(Resource.class)
        Unmarshaller unmarshaller = jaxb.createUnmarshaller()

        // What is the deal with this? JAXB doesn't like <?xml> tags?
        Resource resource = (Resource) unmarshaller.unmarshal(new File("C:\\Users\\misterti.me\\Desktop\\XML\\resources.xml"))

        File dest
        int i = 0
        while (i < resource.resources.size()) {
            dest = new File("C:\\Users\\misterti.me\\Desktop\\XML\\assets\\" + resource.resources.get(i).file.replaceAll("/", "\\\\"))

            println("[Install Assets] Downloading http://s3.amazonaws.com/MinecraftResources/" + resource.resources.get(i).file)
            downloadFile(new URL("http://s3.amazonaws.com/MinecraftResources/"
                            + resource.resources.get(i).file), dest, resource.resources.get(i).hash)
            i++
        }

        // Free up RAM
        resource.resources = null
    }

    /**
     *
     * @param url Location of remote file
     * @param dest Destination of file once downloaded
     * @param hash SHA1 hash of the file
     */
    static void downloadFile(URL url, File dest, String hash) {
        // TODO: Self sufficiency; remove Commons IO dependencies
        try {
            if (url.getFile().contains(".")) {
                copyURLToFile(url, dest)
                Verifier.verifyFile(dest, hash.replaceAll("\"", ""))
            } else {
                Files.createDirectories(dest.toPath().toAbsolutePath())
            }
        } catch (UnknownHostException ignored) {
            println("Failed to download requested file! Are you connected to the internet?")
        } catch (IOException e) {
            println("We appear to have a problem.")
            e.printStackTrace()
        }

    }
}
