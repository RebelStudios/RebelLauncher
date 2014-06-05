package parsers.classmodel.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by misterti.me on 5/27/2014.
 */
@XmlRootElement(name = "mod")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoteMod {
    @XmlElement(name = "name", required = true)
    public String name;

    @XmlElement(name = "file", required = true)
    public String file;

    @XmlElement(name = "SHA", required = true)
    public String SHAHash;

    @XmlElement(name = "modVersion", required = true)
    public String modVersion;

    @XmlElement(name = "MC", required = true)
    public String MC;

    @XmlElement(name = "forgeVersion", required = true)
    public String forgeVersion;

    @XmlElement(name = "branch", required = true)
    public String branch;

    @XmlElement(name = "type", required = true)
    public String type;
}
