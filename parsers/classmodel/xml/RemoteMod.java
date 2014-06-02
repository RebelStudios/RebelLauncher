package parsers.classmodel.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

/**
 * Created by misterti.me on 5/27/2014.
 */
@XmlRootElement(name = "mod")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoteMod {
    @XmlElement(name = "name")
    public String name;

    @XmlElement(name = "file")
    public String file;

    @XmlElement(name = "SHA")
    public String SHAHash;

    @XmlElement(name = "modVersion")
    public String modVersion;

    @XmlElement(name = "MC")
    public String MC;

    @XmlElement(name = "forgeVersion")
    public String forgeVersion;

    @XmlElement(name = "branch")
    public String branch;
}
