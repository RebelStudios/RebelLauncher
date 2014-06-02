package parsers.classmodel.xml;

import javax.xml.bind.annotation.*;

/**
 * Created by misterti.me on 5/26/2014.
 */
@XmlRootElement(name = "packInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PackInfo {
    @XmlElement(name = "packName", required = true)
    public String packName = null;

    @XmlElement(name = "packVersion", required = true)
    public String packVersion = null;

    @XmlElement(name = "MCVersion", required = true)
    public String MCVersion = null;

    @XmlElement(name = "branch", required = true)
    public String branch = null; // unstable, alpha, beta, release


//    Mod repo works like this:
//    http://modrepo.rebelstudios.org/mods/IndustrialCraft2/IC2-2.1.477.jar
//    Link to version 2.1.477 of IC2. In the same directory, there is an IC2-2.1.477.xml file that goes something like this:
//    <mod>
//        <name>IndustrialCraft 2</name>
//        <file>IC2-2.1.477.jar</file>
//        <version>2.1.477</version>
//        <mc>1.6.4</mc>
//        <forge>9.1.11.965</forge>
//        <branch>Unstable</branch> <!-- and very much so, at that -->
//    </mod>
}
